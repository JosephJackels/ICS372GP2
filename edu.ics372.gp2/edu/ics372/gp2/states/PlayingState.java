package edu.ics372.gp2.states;

import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

/**
 * Represents the playing state
 * 
 * @author leo
 *
 */
public class PlayingState extends VideoPlayerState implements Notifiable {
	private static PlayingState instance;
	private Show show = null;
	private Timer timer = null;

	/**
	 * Singleton for playing state
	 */
	private PlayingState() {

	}

	/**
	 * Creates lone instance of playing state
	 * 
	 * @return
	 */
	public static PlayingState getInstance() {
		if (instance == null) {
			instance = new PlayingState();
		}
		return instance;
	}

	/**
	 * Process off
	 */
	@Override
	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	/**
	 * Process pause
	 */
	public void pauseRequest() {
		VideoPlayerContext.getInstance().changeState(PausedState.getInstance());
	}

	/**
	 * Process stop
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
	}

	/**
	 * Process rewind
	 */
	@Override
	public void rewindRequest() {
		VideoPlayerContext.getInstance().changeState(RewindState.getInstance());
	}

	/**
	 * Process fast forwarding
	 */
	@Override
	public void fastFowardRequest() {
		VideoPlayerContext.getInstance().changeState(FastForwardState.getInstance());
	}

	/**
	 * Process timer tick
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		show.increaseTime(1);
		VideoPlayerContext.getInstance().showTimeLeft(show.getElapsedTime(), show.getShowLength());
	}

	/**
	 * Process leaving playing state
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	/**
	 * Enter playing state
	 */
	@Override
	public void enter() {
		show = VideoPlayerContext.getInstance().getShow();
		timer = new Timer(this, show.getShowLength() - show.getElapsedTime());
		VideoPlayerContext.getInstance().showPlaying();
	}

	@Override
	public void onTimerRunsOut() {
		VideoPlayerContext.getInstance().showTimeLeft(show.getElapsedTime(), show.getShowLength());
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
	}

}
