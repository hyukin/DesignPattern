package stratagy;

public class TestDriver {
    public static void main(String[] args){
        
        System.out.println("---------BtnClass-------------");
        BtnClass btnclass=new BtnClass("자바");
        System.out.println("---------PrintImgClass-------------");
        PrintImgClass printimgclass=new PrintImgClass("https://www.evernote.com/shard/s449/sh/29c143ab-d389"
                + "-416d-90ac-591f2e5a7ec3/586689b69a6125aec7399f3272e1d282/res/02b2f9f7-2a75-452a-baa1-e2924e918cd6/ytubeMain.PNG");
        System.out.println("---------MoveLeftClass-------------");
        MoveLeftClass moveleftclass=new MoveLeftClass(5);
        System.out.println("---------MoveRightClass-------------");
        MoveRightClass moverightclass=new MoveRightClass(5);
        System.out.println("---------ListClass-------------");
        ListClass listclass=new ListClass(1);
        System.out.println("----------------------");
    }
}

