package stratagy;

public class LastPrintClass extends SetListener {
    public LastPrintClass(String keyword){
        printgui=new NewListPrint();
        
        printgui.setElement(keyword);
        printgui.print();
    }
}
