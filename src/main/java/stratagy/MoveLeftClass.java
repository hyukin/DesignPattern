
package stratagy;

public class MoveLeftClass extends SetListener {
    int indexList;
    public MoveLeftClass(int index){
        indexList=index;
        printgui=new UpdateListPrint();
        
        
        if(indexList-5>-1){
            indexList=indexList-5;
            printgui.setElement(indexList);
            printgui.print();
        }
    }
    
    @Override
    public int getIndex(){
        return indexList;
    }
}
