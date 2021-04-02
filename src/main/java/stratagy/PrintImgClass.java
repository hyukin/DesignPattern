package stratagy;

import java.awt.Image;

public class PrintImgClass extends SetListener{
    Image image;
    public PrintImgClass(String str){
        printgui=new ImageStrPrint();
        
        printgui.setElement(str);
        printgui.print();
        image=printgui.getElement();
    }
    
    public Image getImage(){
        return image;
    }
}
