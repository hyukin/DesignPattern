package state;

public class ClickedSubscribeState implements State {
	WatchInfo watchInfo;

	public ClickedSubscribeState(WatchInfo watchInfo) {
		this.watchInfo = watchInfo;
	}

	@Override
	public void entervideo() {
		System.out.println("이미 영상을 시청하고 있습니다.");
	}

	@Override
	public void recommendation() {
		

                System.out.println("추천 구독 모두 하였습니다!");
		watchInfo.setState(watchInfo.getAllSelectedState());
                watchInfo.getRecCount();//추천 1증가
	}

	@Override
	public void exitvideo() {
		System.out.println("영상을 종료합니다.");
		watchInfo.setState(watchInfo.getNoWatchedState());
	}

	@Override
	public void subscribe() {
		System.out.println("이미 구독한 채널입니다.");
	}

	@Override
	public String toString() {
		return "구독이 반영된 상태";
	}

}
