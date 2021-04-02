/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy.virtual;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import flyweight.SetResult;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import gui.Video;

/**
 *
 * @author hjk
 */
public class searchServer implements subject {
  //real server
    
  private static String PROPERTIES_FILENAME = "youtube.key"; //Global instance properties filename

  private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport(); //Global instance of the HTTP transport

  private static final JsonFactory JSON_FACTORY = new JacksonFactory(); //Global instance of the JSON factory

  private static final long NUMBER_OF_VIDEOS_RETURNED = 20; //유튜브에서 가져올 검색 결과 수(지금은 5개)

  private static YouTube youtube; //모든 API 요청을 만들기 위한 Youtube object 전역 변수
  
  public static List<Video> resVideo=new ArrayList<Video>(); //비디오 객체를 담은 리스트
  
  static YouTube.Search.List search; //유튜브 서치 리스트
  static List<SearchResult> searchResultList;
  public String keyword=""; //입력받은 키워드 저장
  static SetResult setresult=new SetResult();
  
    public static int searchCount=-1;
  
    public void search(){
        try {
        search.setQ(keyword);
      
        search.setType("video"); //비디오 검색하기로 설정 (가능한 설정옵션: "video,playlist,channel".)
        /*
         * This method reduces the info returned to only the fields we need and makes calls more
         * efficient.
         */
        search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
        SearchListResponse searchResponse = search.execute();

        searchResultList = searchResponse.getItems();

        if (searchResultList != null) {
            resVideo.clear();
            prettyPrint(searchResultList.iterator(), keyword);
        }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
  }

  /*
   * 검색 결과 이터레이터로 출력
   */
  private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {
    
    if (!iteratorSearchResults.hasNext()) {
      System.out.println("검색 결과가 없습니다.");
    }

    while (iteratorSearchResults.hasNext()) {
      SearchResult singleVideo = iteratorSearchResults.next();
      ResourceId rId = singleVideo.getId(); //video ID
      
      // Double checks the kind is video.
      if (rId.getKind().equals("youtube#video")) {
        Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().get("default");

        String vId=rId.getVideoId();
        String title=singleVideo.getSnippet().getTitle();
        String thumbnailImg=thumbnail.getUrl();
        
        resVideo.add(new Video(vId, title,thumbnailImg));
        if(resVideo.size()==5){
            setresult.setLock(0);
        }
        searchCount++;
      }
    }
        resVideo.get(resVideo.size()-1).checkCode=true;
        setresult.returnLoadLabel().setText("Finish!");
    }
    
    public void setKey(){
        Properties properties = new Properties();
        try {
            InputStream in = searchServer.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);

            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
              public void initialize(HttpRequest request) throws IOException {}
            }).setApplicationName("youtube-cmdline-search-sample").build();

            search = youtube.search().list("id,snippet");
            /*
             * 개인 유튜브 api키 연동 
             */
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            
        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                + " : " + e.getMessage());
            System.exit(1);
        }
    }

}
