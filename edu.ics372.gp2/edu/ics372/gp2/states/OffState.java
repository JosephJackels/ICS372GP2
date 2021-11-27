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
	 * @return object
	 */
	public static OffState getInstance() {
		if(instance == null) {
			instance = new OffState();
		}
		return instance;
	}
	
	/**
	 * process on request.
	 */
	public void onOnRequest() {
		VideoPlayerContext.getInstance().changeState(UnselectedState.getInstance());
	}

	/**
	 * initialize the state.
	 */
	@Override
	public void enter() {
		VideoPlayerContext.getInstance().showVideoPlayerOff();
	}

	/**
	 * Uninitialized the state.
	 * @param newState
	 */
	@Override
	public void leave(VideoPlayerState newState) {
		VideoPlayerContext.getInstance().showVideoPlayerOn();
	}

}
