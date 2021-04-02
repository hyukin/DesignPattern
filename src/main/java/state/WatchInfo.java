package state;

public class WatchInfo {

    State noWatchedState;
    State noSelectedState;
    State clickedRecommendationState;
    State allSelectedState;
    State clickedSubscribeState;
    State state = noWatchedState;
    public static int subcount = 0;
    public static int reccount = 0;

    public WatchInfo() {
        noWatchedState = new NoWatchedState(this);
        noSelectedState = new NoSelectedState(this);
        clickedRecommendationState = new ClickedRecommendationState(this);
        allSelectedState = new AllSelectedState(this);
        clickedSubscribeState = new ClickedSubscribeState(this);
        state = noWatchedState;     //영상재생 안한 상태로 초기화

    }

    public void entervideo() {
        state.entervideo();
    }

    public void recommendation() {
        state.recommendation();
    }

    public void subscribe() {
        state.subscribe();
    }

    public void exitvideo() {
        state.exitvideo();
    }

    void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getNoWatchedState() {
        return noWatchedState;
    }

    public State getNoSelectedState() {
        return noSelectedState;
    }

    public State getClickedSubscribeState() {
        return clickedSubscribeState;
    }

    public State getClickedRecommendationState() {
        return clickedRecommendationState;
    }

    public State getAllSelectedState() {
        return allSelectedState;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n");
        result.append("\n");
        result.append("영상시청 상태:" + state + "\n");
        return result.toString();
    }

    public static int getSubCount() {
        subcount++;
        System.out.println("구독자 수 : " + subcount + "명");
        return subcount;
    }

    public static int getRecCount() {
        reccount++;
        System.out.println("추천 수 : " + reccount);
        return reccount;
    }
}
