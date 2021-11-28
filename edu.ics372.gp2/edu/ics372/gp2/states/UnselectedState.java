package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.*;
import edu.ics372.gp2.entities.Show;

public class UnselectedState extends VideoPlayerState implements Notifiable {
	private static UnselectedState instance;
	private Timer timer;

	/**
	 * private constructor for singleton pattern
	 */
	private UnselectedState() {

	}

	/**
	 * for singleton pattern
	 * 
	 * @return UnselectedState object
	 */
	public static UnselectedState getInstance() {
		if (instance == null) {
			instance = new UnselectedState();
		}
		return instance;
	}

	/**
	 * process On request
	 */
	@Override
	public void onRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process Off request.
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * process select show request
	 * 
	 * @param show
	 */
	@Override
	public void selectRequest(Show show) {
		VideoPlayerContext.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(SelectedState.getInstance());
	}

	/**
	 * process Play request
	 */
	@Override
	public void playRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process Pause request
	 */
	@Override
	public void pauseRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process Stop request
	 */
	@Override
	public void stopRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process Rewind request
	 */
	@Override
	public void rewindRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process Fast Forward request
	 */
	@Override
	public void fastFowardRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process timeout after no buttons pressed
	 */
	@Override
	public void onTimerRunsOut() {
		VideoPlayerContext.getInstance().changeState(ScreenSaverState.getInstance());

	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub

	}

	/**
	 * initialize the State.
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 10);
		VideoPlayerContext.getInstance().showUnselected();
	}

	/**
	 * Uninitialized the state.
	 * 
	 * @param newState
	 */
	@Override
	public void leave(VideoPlayerState newState) {
		if (newState.equals(OffState.getInstance())) {
			timer.stop();
			timer = null;
			VideoPlayerContext.getInstance().showSelectOff();
		}

		if (newState.equals(ScreenSaverState.getInstance())) {
			timer.stop();
			timer = null;
			VideoPlayerContext.getInstance().showScreenSaver();
		}
	}

}
