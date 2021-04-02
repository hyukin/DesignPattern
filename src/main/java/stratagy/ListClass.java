package stratagy;

import java.awt.Image;

public class ListClass extends SetListener{
    Image image;
    public ListClass(int index){
        printgui=new ImagePrint();
        
        printgui.setElement(index);
        
        printgui.print();
        image=printgui.getElement();
    }
    
    public Image getImage(){
        return image;
    }
}


