package state;


public class Testcase {
    public static void main(String[] args) {
        
        WatchInfo watchInfo = new WatchInfo();  //영상정보상태 객체 생성
        
        System.out.println(watchInfo);		//최초상태(영상재생x)
        watchInfo.entervideo();                 //영상시청
        watchInfo.recommendation();             //추천
        watchInfo.subscribe();                  //구독
        System.out.println(watchInfo);          //추천 구독 모두반영된 현상태 출력
        watchInfo.exitvideo();                  //영상 종료
        watchInfo.entervideo();                 //재진입
        watchInfo.recommendation();             //추천
        watchInfo.subscribe();                  //구독
        watchInfo.exitvideo();                  //영상 종료
        System.out.println(watchInfo);          //종료된상태 
       
     
    }
  
}