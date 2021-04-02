
package decorate;

public class VideoFile extends NoticeBoardDecorator {
  public VideoFile(NoticeBoard noticeboard) {
      this.noticeboard = noticeboard;
  }
 public String getAddContents() {
       if(countkey[2]==0){
           countkey[2]++;
      returntext=noticeboard.getAddContents() +"[영상첨부]";
         return returntext;
       }
       else{
         return returntext;
       }
  }
   public int getKeyword() {
      return noticeboard.getKeyword()+1;
  }
   


}
