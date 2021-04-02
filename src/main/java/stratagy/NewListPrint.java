package stratagy;

import flyweight.SetResult;
import java.awt.Image;
import proxy.virtual.searchKeyword;

public class NewListPrint implements PrintGui{
    SetResult setResult=new SetResult();
    String str;
    
    @Override
    public void print() {
        setResult.removeModel();
        
        searchKeyword searchKey=new searchKeyword();
        searchKey.callServer(str);
    }

    @Override
    public void setElement(Object tmp) {
        str=(String)tmp;
    }

    @Override
    public Image getElement() {
        return null;
    }
}
