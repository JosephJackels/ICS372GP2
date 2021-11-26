/**
 * 
 */
package edu.ics372.gp2.displays;

/**
 * @author Dilli
 *
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
