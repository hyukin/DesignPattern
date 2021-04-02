package stratagy;

import flyweight.SetResult;
import java.awt.Image;

public class UpdateListPrint implements PrintGui{
    SetResult setresult=new SetResult();
    int indexList;
    
    @Override
    public void print() {
        setresult.removeModel();
        
        for(int i=indexList; i<indexList+5; i++)
            setresult.addModel(i);
    }

    @Override
    public void setElement(Object tmp) {
        indexList=(int)tmp;
    }

    @Override
    public Image getElement() {
        return null;
    }
}
