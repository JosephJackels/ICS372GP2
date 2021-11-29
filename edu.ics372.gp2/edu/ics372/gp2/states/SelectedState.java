package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;

public class SelectedState extends VideoPlayerState {
	private static SelectedState instance;
	private Show show = null;

	/**
	 * Private constructor for singleton pattern.
	 */
	private SelectedState() {

	}

	/**
	 * for singleton
	 * 
	 * @return SelectedState object
	 */
	public static SelectedState getInstance() {
		if (instance == null) {
			instance = new SelectedState();
		}

		return instance;
	}

	/**
	 * Delete this method if we can't change show that was selected during this
	 * state. process select show request
	 * 
	 * @param show
	 */
	public void selectRequest(Show show) {
		this.show = show;
		VideoPlayerContext.getInstance().showSelected(show);
	}

	public void playRequest() {
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	/**
	 * process off request
	 */
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * initialized the State
	 */
	@Override
	public void enter() {
		this.show = VideoPlayerContext.getInstance().getShow();
		VideoPlayerContext.getInstance().showSelected(show);
	}

	/**
	 * Uninitialized the state.
	 * 
	 * @param newState
	 */
	@Override
	public void leave(VideoPlayerState newState) {
		if (newState.equals(OffState.getInstance())) {
			VideoPlayerContext.getInstance().showSelectOff();
		}
	}

}
