
package decorate;

public abstract class NoticeBoardDecorator extends NoticeBoard {
  protected NoticeBoard noticeboard;
 
  public abstract String getAddContents() ;


  public String returntetx(String maintext) {
      System.out.println(maintext);
      return maintext;
  }

}
