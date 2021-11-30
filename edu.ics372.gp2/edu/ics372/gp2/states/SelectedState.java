package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

public class SelectedState extends VideoPlayerState implements Notifiable {
	private static SelectedState instance;
	private Timer timer;

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
	 * process On request
	 */
	@Override
	public void onRequest() {
		timer.setTimeValue(10);
	}

	/**
	 * process off request
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * process Select request
	 */
	@Override
	public void selectRequest(Show show) {
		VideoPlayerContext.getInstance().setShow(show);
		timer.setTimeValue(10);
		VideoPlayerContext.getInstance().showSelected();
	}

	/**
	 * process play request
	 */
	@Override
	public void playRequest() {
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
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
		ScreenSaverState.getInstance().setPreviousState(this);
		ScreenSaverState.getInstance().setShow(VideoPlayerContext.getInstance().getShow());
		VideoPlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	/**
	 * initialized the State
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 10);
		VideoPlayerContext.getInstance().showSelected();
	}

	/**
	 * Uninitialized the state.
	 * 
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
	}
}
