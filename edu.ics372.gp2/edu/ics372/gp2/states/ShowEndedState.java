package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Show has ended, waits for 10 seconds until either: press Play to restart show
 * (enter playing state) press Stop to end timer and de-select show (enter
 * unselected state) press Select to select a different show
 */
public class ShowEndedState extends VideoPlayerState implements Notifiable {
	private static ShowEndedState instance;
	private Timer timer = null;

	/**
	 * private constructor for singleton
	 */
	private ShowEndedState() {

	}

	/**
	 * returns lone instance of showended
	 * 
	 * @return
	 */
	public static ShowEndedState getInstance() {
		if (instance == null) {
			instance = new ShowEndedState();
		}
		return instance;
	}

	/**
	 * process the entering of this state
	 */
	@Override
	public void enter() {
		VideoPlayerContext.getInstance().getShow().setElapsedTime(0);
		VideoPlayerContext.getInstance().showStopped(10);
		timer = new Timer(this, 10);
	}

	/**
	 * process the exiting of this state
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
		VideoPlayerContext.getInstance().getShow().setElapsedTime(0);;
	}

	/**
	 * process off
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * process select show request
	 */
	@Override
	public void selectRequest(Show show) {
		VideoPlayerContext.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(SelectedState.getInstance());
	}

	/**
	 * process play
	 */
	@Override
	public void playRequest() {
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	/**
	 * process stop (de-select) request
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(UnselectedState.getInstance());
	}

	/**
	 * process each timer tick
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		VideoPlayerContext.getInstance().showStopped(timerValue);
	}

	/**
	 * process the ending of the timer
	 */
	@Override
	public void onTimerRunsOut() {
		ScreenSaverState.getInstance().setPreviousState(UnselectedState.getInstance());
		VideoPlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}
}
