package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;

public class PausedState extends VideoPlayerState {
	private static PausedState instance;
	private Show show;

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
		VideoPlayerContext.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}
	
	/**
	 * process Stop request
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
		VideoPlayerContext.getInstance().showStopped();
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

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	

}
