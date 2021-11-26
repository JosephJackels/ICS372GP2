package edu.ics372.gp2.states;

import edu.ics372.gp2.displays.VideoPlayerDisplay;

/**
 * This class observers the context of the Video Player.
 * @author leo
 *
 */
public class VideoPlayerContext {
	private VideoPlayerDisplay display;
	private VideoPlayerState currentState;
	private static VideoPlayerContext instance;
	
	/**
	 * Private constructor for singleton
	 */
	private VideoPlayerContext() {
		instance = this;
		currentState = OffState.getInstance();
		//set current state to idle unselected
		//currentState =
	}
	
	/**
	 * Get single instance
	 * @return
	 */
	public static VideoPlayerContext getInstance() {
		if (instance == null) {
			instance = new VideoPlayerContext();
		}
		return instance;
	}
	
	/**
	 * set display
	 * @param display
	 */
	public void setDisplay(VideoPlayerDisplay display) {
		this.display = display;
	}
	
	/**
	 * Lets idle unselected be the default starting state
	 */
	public void initialize() {
		//set state to idle unselected
		//instance.changeState(idleState.getInstance());
	}
	
	/**
	 * Changes current state
	 * @param newState
	 */
	public void changeState(VideoPlayerState newState) {
		currentState.leave(newState);
		currentState = newState;
		currentState.enter();
	}
	

	public void showVideoPlayerOff() {
		display.showTurnOff();
	}
	

	public void showVideoPlayerOn() {
		display.showTurnOn();
	}
	

	public void showSelected() {
		display.showSelected();
	}
	
	public void showUnselected() {
		display.showUnselected();
	}
	
	public void showSelectOff() {
		display.showSelectingOff();
	}
	
	public void onOffRequest() {
		currentState.onOffRequest();
	}
	
	public void onOnRequest() {
		currentState.onOnRequest();
	}
	
	public void onSelectRequest() {
		currentState.onSelectRequest();
	}
	
	public VideoPlayerState getCurrentState() {
		return currentState;
	}
}
