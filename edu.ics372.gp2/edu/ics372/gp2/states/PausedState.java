package edu.ics372.gp2.states;

public class PausedState extends VideoPlayerState {
	private static PausedState instance;

	private PausedState() {

	}

	public static PausedState getInstance() {
		if (instance == null) {
			instance = new PausedState();
		}
		return instance;
	}

	/**
	 * process Off request.
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * process Play request
	 */
	@Override
	public void playRequest() {
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	/**
	 * process Stop request
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
	}

	@Override
	public void leave() {
	}

	/**
	 * Initialize the state
	 * 
	 */
	@Override
	public void enter() {
		VideoPlayerContext.getInstance().showPaused();

	}

}
