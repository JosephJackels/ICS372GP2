package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents the fast forward state.
 * 
 * @author Austin Wang
 */
public class FastForwardState extends VideoPlayerState implements Notifiable {
	private static FastForwardState instance;
	private Timer timer = null;
	private Show show;
	private int timeLeft;
	
	/**
	 * private constructor for singleton pattern
	 */
	private FastForwardState() {

	}

	/**
	 * singleton object
	 * 
	 * @return object
	 */
	public static FastForwardState getInstance() {
		if (instance == null) {
			instance = new FastForwardState();
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
	public void leave() {
		timer.stop();
		timer = null;
		
	}
	
	/**
	 * Initialize the state
	 */
	@Override
	public void enter() {
		timeLeft = show.getShowLength() - show.getElapsedTime();
		int time = (timeLeft % 2 == 0) ? (timeLeft / 2) : (timeLeft / 2) + 1;
		timer = new Timer(this, time);
		VideoPlayerContext.getInstance().showFastForward();
	}
	
	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		timeLeft -= 2;
		show.setElapsedTime(show.getElapsedTime() + 2);
		if (timeLeft < 0) {
			timeLeft = 0;
		}		
		VideoPlayerContext.getInstance().showTimeLeft(timeLeft);
		
	}

	@Override
	public void onTimerRunsOut() {
		VideoPlayerContext.getInstance().showTimeLeft(0);
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
		
	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub
		
	}
}
