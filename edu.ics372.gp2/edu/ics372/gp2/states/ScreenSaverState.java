package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;

/**
 * Represents Screen saver state
 * 
 * @author Austin Wang
 *
 */
public class ScreenSaverState extends VideoPlayerState {
	private static ScreenSaverState instance;
	private VideoPlayerState previousState;
	private Show show;

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
	
	public void setPreviousState(VideoPlayerState previousState) {
		this.previousState = previousState;
	}
	
	public void setShow(Show show) {
		this.show = show;
	}
	
	/**
	 * process On request
	 */
	@Override
	public void onRequest() {
		VideoPlayerContext.getInstance().changeState(previousState);
	}
	
	/**
	 * process Off request
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}
	
	/**
	 * Process selection request
	 */
	@Override
	public void selectRequest() {
		VideoPlayerContext.getInstance().changeState(previousState);
	}
	
	/**
	 * process Play request
	 */
	@Override
	public void playRequest() {
		if (previousState.equals(UnselectedState.getInstance())) {
			VideoPlayerContext.getInstance().changeState(previousState);
		} else {
			VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
		}
	}
	
	/**
	 * Process pause request
	 */
	@Override
	public void pauseRequest() {
		VideoPlayerContext.getInstance().changeState(previousState);
	}
	
	/**
	 * Process stop request
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(previousState);
	}
	
	/**
	 * Process rewind request
	 */
	@Override
	public void rewindRequest() {
		VideoPlayerContext.getInstance().changeState(previousState);
	}
	
	/**
	 * Process fast forward request
	 */
	@Override
	public void fastFowardRequest() {
		VideoPlayerContext.getInstance().changeState(previousState);
	}
	
	@Override
	public void leave() {
		VideoPlayerContext.getInstance().setShow(show);
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		this.show = VideoPlayerContext.getInstance().getShow();
		VideoPlayerContext.getInstance().showScreenSaver();
	}

}
