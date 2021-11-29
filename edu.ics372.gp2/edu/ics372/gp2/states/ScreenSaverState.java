package edu.ics372.gp2.states;

/**
 * Represents Screen saver state
 * 
 * @author Austin Wang
 *
 */
public class ScreenSaverState extends VideoPlayerState {
	private static ScreenSaverState instance;

	/**
	 * private constructor for singleton
	 */
	private ScreenSaverState() {

	}

	/**
	 * Returns the instance of Screen saver or creates one if it doesn't already
	 * exist.
	 * 
	 * @return instance of screen saver
	 */
	public static ScreenSaverState getInstance() {
		if (instance == null) {
			instance = new ScreenSaverState();
		}
		return instance;
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

}
