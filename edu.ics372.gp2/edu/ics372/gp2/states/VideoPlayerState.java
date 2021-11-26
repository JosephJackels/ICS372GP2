package edu.ics372.gp2.states;

/**
 * Super class for all states
 * @author leo
 *
 */
public abstract class VideoPlayerState {
	
	/**
	 * leave current state
	 */
	public abstract void leave(VideoPlayerState newState);
	
	/**
	 * enter current state
	 */
	public abstract void enter();
	
	/**
	 * Process play request
	 */
	public void onPlayRequest() {
		
	}
	
	/**
	 * Process pause
	 */
	public void onPauseRequest() {
		
	}
	
	/**
	 * Process stop
	 */
	public void onStopRequest() {
		
	}
	
	/**
	 * Process rewind
	 */
	public void onRewindRequest() {
		
	}
	
	/**
	 * Process fast forward
	 */
	public void onFastFowardRequest() {
		
	}
	
	/**
	 * Process off
	 */
	public void onOffRequest() {
		
	}
	
	/**
	 * Process selection
	 */
	public void onSelectRequest() {
		
	}
	
	/**
	 * process On
	 */
	public void onOnRequest() {
		
	}

}
