package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;

/**
 * Super class for all states
 * 
 * @author leo
 *
 */
public abstract class VideoPlayerState {

	/**
	 * leave current state
	 */
	public abstract void leave();

	/**
	 * enter current state
	 */
	public abstract void enter();

	/**
	 * Process play request
	 */
	public void playRequest() {

	}

	/**
	 * Process pause
	 */
	public void pauseRequest() {

	}

	/**
	 * Process stop
	 */
	public void stopRequest() {

	}

	/**
	 * Process rewind
	 */
	public void rewindRequest() {

	}

	/**
	 * Process fast forward
	 */
	public void fastFowardRequest() {

	}

	/**
	 * Process off
	 */
	public void offRequest() {

	}

	/**
	 * Process selection
	 */
	public void selectRequest() {

	}

	/**
	 * process On
	 */
	public void onRequest() {

	}
}
