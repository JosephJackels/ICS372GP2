package edu.ics372.gp2.states;

public class UnselectedState extends VideoPlayerState{
private static UnselectedState instance;
	
	private UnselectedState() {
		
	}
	
	public static UnselectedState getInstance() {
		if(instance == null) {
			instance = new UnselectedState();
		}
		return instance;
	}

	@Override
	public void enter() {
		VideoPlayerContext.getInstance().showUnselected();
	}

	@Override
	public void leave(VideoPlayerState newState) {
		if(newState.equals(OffState.getInstance())) {
			VideoPlayerContext.getInstance().showSelectOff();
		}
	}
	
	public void onOffRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	public void onSelectRequest() {
		VideoPlayerContext.getInstance().changeState(SelectedState.getInstance());
	}
}
