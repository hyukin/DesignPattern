
package decorate;

public abstract class NoticeBoard {
  protected String descriotion;
  static int[] countkey =new int[3];
  static String returntext;
  
  public String getAddContents() {
      return descriotion;
  }

  public abstract int getKeyword() ;
  
}
