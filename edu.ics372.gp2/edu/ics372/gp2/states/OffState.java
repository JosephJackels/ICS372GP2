package edu.ics372.gp2.states;
/**
 * represent Offstate
 * @author andy
 *
 */
public class OffState extends VideoPlayerState{
	private static OffState instance;
	
	/**
	 * private constructor for singleton pattern
	 */
	private OffState() {
		
	}
	
	/**
	 * singleton object
	 * @return
	 */
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
	public void leave(VideoPlayerState newState) {
		VideoPlayerContext.getInstance().showVideoPlayerOn();
	}
	
	public void onOnRequest() {
		VideoPlayerContext.getInstance().changeState(UnselectedState.getInstance());
	}
}
