package edu.ics372.gp2.states;


public class SelectedState extends VideoPlayerState{

	private static SelectedState instance;
	
	private SelectedState() {
		
	}
	
	public static SelectedState getInstance() {
		if(instance == null) {
			instance = new SelectedState();
		}
		
		return instance;
	}
	

	
	@Override
	public void enter() {
		VideoPlayerContext.getInstance().showSelected();
	}
	
	public void onOffRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	@Override
	public void leave(VideoPlayerState newState) {
		if(newState.equals(OffState.getInstance())) {
			VideoPlayerContext.getInstance().showSelectOff();
		}
	}
	

}
