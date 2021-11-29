package edu.ics372.gp2.states;

public class ShowEndedState extends VideoPlayerState {
	/**
	 * Show has ended, waits for 10 seconds until either: press Play to restart show
	 * (enter playing state) press Stop to end timer and deselct show (enter
	 * unselcted state) press Select to select a different show
	 */
	private static ShowEndedState instance;

	private ShowEndedState() {

	}

	public static ShowEndedState getInstance() {
		if (instance == null) {
			instance = new ShowEndedState();
		}
		return instance;
	}
	
	//TODO handle events once a show is stopped

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

}
