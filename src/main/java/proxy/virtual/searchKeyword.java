package proxy.virtual;

import flyweight.SetResult;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class searchKeyword implements subject{
    
    SetResult setresult=new SetResult();
    static private searchServer searchK;
    private static boolean setkey=true;
    
    private static int printCount=0;
    
    public synchronized void callServer(String kword){
        
        searchK=new searchServer();
        searchK.keyword=kword;
        setresult.returnLoadLabel().setText("Loading...");
        setresult.videoList.clear();
        
        Runnable searchtest=new tSearch();
        Thread searchT=new Thread(searchtest);
        searchT.start();
        
        Runnable printtest=new tPrint();
        Thread print=new Thread(printtest);
        print.start();
        
    }
    
    public synchronized void search(){
        
        if(setkey){
            searchK.setKey();
            setkey=false;
        }
        
        searchK.search();
        System.out.println("finishSearch");
    }
    
    public synchronized void printResult(){
        
            boolean check = false;
            int index=0;
            
            System.out.println("Loading Video...");
            
            while(!check){
                if(setresult.getLock()==0){
                    
                    setresult.videoList.add(searchK.resVideo.get(index));
                    
                    if(index==5){
                        for(int i=index-5; i<index; i++){
                        setresult.addModel(i);
                        System.out.println(setresult.videoList.get(i).title);
                        }
                    }
                    
                if(searchK.resVideo.get(index).checkCode==true)
                    check=true;
                
                index++;
                printCount++;
                }
            }
            System.out.println("Finish Load");
    }
    
    public class tSearch implements Runnable{
        
        @Override
        public void run() {
            
            setresult.setLock(1);
            search();
            
        }
        
    }
    
    public class tPrint implements Runnable{
        
        @Override
        public void run() {
            printResult();
        }
        
    }
    
}
