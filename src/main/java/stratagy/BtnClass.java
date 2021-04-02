package stratagy;

public class BtnClass extends SetListener{
     public BtnClass(String keyword){
        printgui=new NewListPrint();
        
        printgui.setElement(keyword);
        printgui.print();
     }
}
