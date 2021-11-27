package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;

public class UnselectedState extends VideoPlayerState{
	private static UnselectedState instance;
	
	/**
	 * private constructor for singleton pattern
	 */
	private UnselectedState() {
		
	}
	
	/**
	 * for singleton pattern
	 * @return UnselectedState object
	 */
	public static UnselectedState getInstance() {
		if(instance == null) {
			instance = new UnselectedState();
		}
		return instance;
	}

	/**
	 * process Off request.
	 */
	public void onOffRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * process select show request
	 * @param show
	 */
	public void onSelectRequest(Show show) {
		VideoPlayerContext.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(SelectedState.getInstance());
	}
	
	/**
	 * initialize the State.
	 */
	@Override
	public void enter() {
		VideoPlayerContext.getInstance().showUnselected();
	}

	/**
	 * Uninitialized the state.
	 * @param newState
	 */
	@Override
	public void leave(VideoPlayerState newState) {
		if(newState.equals(OffState.getInstance())) {
			VideoPlayerContext.getInstance().showSelectOff();
		}
	}
}
