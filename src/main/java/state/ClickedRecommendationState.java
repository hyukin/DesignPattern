package state;

public class ClickedRecommendationState implements State {
  WatchInfo watchInfo;
 public ClickedRecommendationState(WatchInfo watchInfo) {
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
    
    System.out.println("구독 추천 모두 하였습니다.");
    watchInfo.setState(watchInfo.getAllSelectedState());
    watchInfo.getSubCount();
              
  }
@Override
  public void exitvideo() {
      System.out.println("영상을 종료하였습니다.");
      watchInfo.setState(watchInfo.getNoWatchedState());
  }



  
@Override
  public String toString() {
      return "추천이 반영된 상태";
  }

}