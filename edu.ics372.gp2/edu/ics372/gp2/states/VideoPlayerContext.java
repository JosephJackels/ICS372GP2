package edu.ics372.gp2.states;

import edu.ics372.gp2.displays.VideoPlayerDisplay;
import edu.ics372.gp2.entities.Show;

/**
 * This class observers the context of the Video Player.
 * 
 * @author leo
 *
 */
public class VideoPlayerContext {
	private VideoPlayerDisplay display;
	private VideoPlayerState currentState;
	private static VideoPlayerContext instance;
	private Show show;

	/**
	 * Private constructor for singleton
	 */
	private VideoPlayerContext() {
		instance = this;
		currentState = OffState.getInstance();
	}

	/**
	 * Get single instance
	 * 
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
	 * 
	 * @param display
	 */
	public void setDisplay(VideoPlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Lets idle unselected be the default starting state
	 */
	public void initialize() {
		// set state to idle unselected
		// instance.changeState(idleState.getInstance());
	}

	/**
	 * Changes current state
	 * 
	 * @param newState
	 */
	public void changeState(VideoPlayerState newState) {
		currentState.leave();
		currentState = newState;
		currentState.enter();
	}

	public void showVideoPlayerOff() {
		display.showTurnOff();
	}

	public void showSelected() {
		display.showSelected(show.getShowName(), Integer.toString(show.getShowLength()));
	}

	public void showUnselected() {
		display.showUnselected();
	}

	public void showStopped() {
		display.showStopped();
	}
	
	/**
	 * Marked to be deleted if not needed.
	 */
	public void showSelectOff() {
		display.showSelectingOff();
	}

	public void showScreenSaver() {
		display.showScreenSaver();

	}

	public void showPlaying() {
		display.showPlaying();
	}
	
	public void showPaused() {
		display.showPaused();
	}
	
	public void showFastForward() {
		display.showFastForward();
	}
	
	public void showTimeLeft(int time) {
		display.showTimeRemaining(time);
	}

	public void offRequest() {
		currentState.offRequest();
	}

	public void onRequest() {
		currentState.onRequest();
	}

	public void selectRequest() {
		currentState.selectRequest();
	}

	public void playShowRequest() {
		currentState.playRequest();
	}
	
	public void pauseRequest() {
		currentState.pauseRequest();
	}
	
	public void stopRequest() {
		currentState.stopRequest();
	}

	public void rewindRequest() {
		currentState.rewindRequest();
	}

	public void fastForwardRequest() {
		currentState.fastFowardRequest();
	}

	public VideoPlayerState getCurrentState() {
		return currentState;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Show getShow() {
		return this.show;
	}

}
