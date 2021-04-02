
package decorate;

public class MusicFile extends NoticeBoardDecorator {
  public MusicFile(NoticeBoard noticeboard) {
     this.noticeboard = noticeboard;
  }

  public String getAddContents() {
       if(countkey[0]==0){
           countkey[0] ++;
       returntext=noticeboard.getAddContents() +"[음악첨부]";
         return returntext;
       }
       else{
         return returntext;
       }
  }
  public int getKeyword(){
       return noticeboard.getKeyword()+1;
  }
   

}
