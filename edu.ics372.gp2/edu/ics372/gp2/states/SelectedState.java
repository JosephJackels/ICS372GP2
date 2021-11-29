package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

public class SelectedState extends VideoPlayerState implements Notifiable {
	private static SelectedState instance;
	private Show show = null;
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
	 * Delete this method if we can't change show that was selected during this
	 * state. process select show request
	 * 
	 * @param show
	 */
	public void selectRequest(Show show) {
		this.show = show;
		VideoPlayerContext.getInstance().setShow(show);
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
	 * process timeout after no buttons pressed
	 */
	@Override
	public void onTimerRunsOut() {
		ScreenSaverState.getInstance().setPreviousState(this);
		VideoPlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	/**
	 * initialized the State
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 10);
		this.show = VideoPlayerContext.getInstance().getShow();
		VideoPlayerContext.getInstance().showSelected(show);
	}

	/**
	 * Uninitialized the state.
	 * 
	 * @param newState
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
		/*
		 * if (newState.equals(OffState.getInstance())) {
		 * VideoPlayerContext.getInstance().showSelectOff(); }
		 */
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub
	}

}
