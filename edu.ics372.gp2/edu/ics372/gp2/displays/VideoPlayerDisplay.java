package edu.ics372.gp2.displays;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface VideoPlayerDisplay {

	/**
	 * 
	 */
	public void showTimeRemaining(int time);

	/**
	 * 
	 */
	public void showTurnOff();

	/**
	 * 
	 */
	public void showPaused();

	/**
	 * 
	 */
	public void showPlaying();
	
	/**
	 * Display fast forwarding
	 */
	public void showFastForward();
	
	/**
	 * 
	 */
	public void showStopped();

	/**
	 * I gave this method a parameter just to check if selecting a show works. if
	 * not needed we can delete the parameter.
	 */
	public void showSelected(String showName, String showLength);

	/**
	 * 
	 */
	public void showUnselected();

	/**
	 * 
	 */
	public void showSelectingOff();

	/**
	 * Indicate that the screen saver is on
	 */
	public void showScreenSaver();
}
