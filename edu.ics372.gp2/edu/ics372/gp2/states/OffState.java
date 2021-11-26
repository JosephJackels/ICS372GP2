package edu.ics372.gp2.states;

public class OffState extends VideoPlayerState{
	private static OffState instance;
	
	private OffState() {
		
	}
	
	public static OffState getInstance() {
		if(instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	@Override
	public void enter() {
		VideoPlayerContext.getInstance().showVideoPlayerOff();
	}

	@Override
	public void leave() {
		VideoPlayerContext.getInstance().showVideoPlayerOn();
	}
	
	public void onOnRequest() {
		VideoPlayerContext.getInstance().changeState(UnselectedState.getInstance());
	}
}
