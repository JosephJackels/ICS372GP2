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
	public void showTurnOn();

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
	 * 
	 */
	public void showStopped();
	
	/**
	 * 
	 */
	public void showSelected();
	
	/**
	 * 
	 */
	public void showUnselected();
	
	/**
	 * 
	 */
	public void showSelectingOff();
}
