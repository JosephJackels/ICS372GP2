package edu.ics372.gp2.displays;

/**
 * Specifies what the display system should do.
 * 
 * @author Dilli
 */
public interface VideoPlayerDisplay {

	/**
	 * Display the show time remaining
	 * 
	 * @param time remaining time
	 */
	public void showTimeRemaining(int elapsedTime, int showTime);

	/**
	 * Display show turn off
	 */
	public void showTurnOff();

	/**
	 * Display show paused
	 */
	public void showPaused();

	/**
	 * Display show playing
	 */
	public void showPlaying();

	/**
	 * Display rewinding
	 */
	public void showRewind();

	/**
	 * Display fast forwarding
	 */
	public void showFastForward();

	/**
	 * Display show stopped
	 */
	public void showStopped(int time);

	/**
	 * Display show selected
	 */
	public void showSelected(String showName, String showLength);

	/**
	 * Display show unselected message
	 */
	public void showUnselected();

	/**
	 * Display no show is selected message
	 */
	public void showSelectingOff();

	/**
	 * Indicate that the screen saver is on
	 */
	public void showScreenSaver();
}
