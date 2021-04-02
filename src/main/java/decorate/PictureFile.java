
package decorate;

public class PictureFile extends NoticeBoardDecorator {
  public PictureFile(NoticeBoard noticeboard) {
       this.noticeboard = noticeboard;
  }
 public String getAddContents() {
     if(countkey[1]==0){
         countkey[1] ++;
         returntext=noticeboard.getAddContents() +"[사진첨부]";
         return returntext;
     }
     else{
        
         return returntext;
     }
 }
  public int getKeyword() {
  
     
     // a= a+file[0];
        return noticeboard.getKeyword()+1;
  }
  
 

}
