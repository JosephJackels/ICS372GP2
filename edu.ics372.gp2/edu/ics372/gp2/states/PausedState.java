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

	@Override
	public void leave(VideoPlayerState newState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub

	}

}
