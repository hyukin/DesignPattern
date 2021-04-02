package state;


public class NoWatchedState implements State {
 
	WatchInfo watchInfo;
        
  public NoWatchedState(WatchInfo watchInfo) {
      this.watchInfo=watchInfo;
  }
@Override
  public void entervideo() {
      System.out.println("영상을 시청합니다.");
      watchInfo.setState(watchInfo.getNoSelectedState());
      //상태전환
  }
@Override
  public void recommendation() {    
      System.out.println("영상을 시청해야 추천 할 수 있습니다.");
  }
@Override
  public void subscribe() {
      System.out.println("영상을 시청해야 구독 할 수 있습니다.");
  }
@Override
  public void exitvideo() {
      System.out.println("영상을 종료합니다.");
  }
  
@Override
  public String toString() {
      return "영상시청을 하고 있지 않은 상태";
  }

}
