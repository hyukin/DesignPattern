package proxy.virtual;

public class TestDriver {
    public static void main(String[] argc){
        
        System.out.println("---프록시 사용---");
        searchKeyword search=new searchKeyword();
        search.callServer("토끼");
        
    }
}



