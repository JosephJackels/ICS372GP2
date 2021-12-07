package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents the rewind state.
 * 
 * @author Austin Wang
 */
public class RewindState extends VideoPlayerState implements Notifiable {
	private static RewindState instance;
	private Timer timer = null;
	private Show show;

	/**
	 * private constructor for singleton pattern
	 */
	private RewindState() {

	}

	/**
	 * singleton object
	 * 
	 * @return object
	 */
	public static RewindState getInstance() {
		if (instance == null) {
			instance = new RewindState();
		}
		return instance;
	}

	/**
	 * Process off request
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * Process play request
	 */
	@Override
	public void playRequest() {
		VideoPlayerContext.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	/**
	 * Process stop request
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		show.decreaseTime(2);
		VideoPlayerContext.getInstance().showTimeLeft(show.getElapsedTime(), show.getShowLength());
	}

	@Override
	public void onTimerRunsOut() {
		show.setElapsedTime(0);
		VideoPlayerContext.getInstance().changeState(SelectedState.getInstance());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {
		show = VideoPlayerContext.getInstance().getShow();
		int time = (show.getElapsedTime() % 2 == 0) ? (show.getElapsedTime() / 2) : (show.getElapsedTime() / 2) + 1;
		timer = new Timer(this, time);
//		timeLeft = show.getShowLength() - show.getElapsedTime();
		VideoPlayerContext.getInstance().showRewind();
	}
}
