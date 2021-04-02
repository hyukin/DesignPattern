package state;


public class NoSelectedState implements State {
    WatchInfo watchInfo;
    
    public NoSelectedState(WatchInfo watchInfo) {
      this.watchInfo=watchInfo;
  }
    
  @Override
  public void entervideo() {
      System.out.println("이미 영상을 시청하고 있습니다.");
  }
  
@Override
  public void recommendation() {
	
       System.out.println("추천 하였습니다.");
       watchInfo.setState(watchInfo.getClickedRecommendationState());  
       watchInfo.getRecCount();
  }

@Override
  public void subscribe() {
        
        System.out.println("구독 하였습니다.");
        watchInfo.setState(watchInfo.getClickedSubscribeState());
        watchInfo.getSubCount();
  }

@Override
  public void exitvideo() {
      System.out.println("영상을 종료합니다.");
      watchInfo.setState(watchInfo.getNoWatchedState());
  }

@Override
  public String toString() {
      return "영상은 시작되었고 추천괴 구독이 눌러지지 않은 상태";
  }

}
