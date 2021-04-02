package stratagy;

public class MoveRightClass extends SetListener{
    int indexList;
    public MoveRightClass(int index){
        indexList=index;
        printgui=new UpdateListPrint();
        
        if(indexList+5<16){
            indexList=indexList+5;
            printgui.setElement(indexList);
            printgui.print();
        }
    }
    
    @Override
    public int getIndex(){
        return indexList;
    }
}
