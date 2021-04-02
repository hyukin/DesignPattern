package state;
public class AllSelectedState implements State {
	
  WatchInfo watchInfo;

  public AllSelectedState(WatchInfo watchInfo) {
      this.watchInfo=watchInfo;
  }
 @Override
  public void entervideo() {
      System.out.println("이미 영상을 시청하고 있습니다.");
  }
@Override
  public void recommendation() {
       System.out.println("이미 추천한 영상입니다.");
  }
@Override
  public void subscribe() {
       System.out.println("이미 구독한 영상입니다.");
  }
@Override
  public void exitvideo() {
      System.out.println("영상을 종료합니다.");
      watchInfo.setState(watchInfo.getNoWatchedState());
  }
@Override
  public String toString() {
      return "추천/구독 모두 반영된 상태";
  }
}
