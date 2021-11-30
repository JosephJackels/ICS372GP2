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

	// TODO add other events

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
		// save elapsed time somehow?
		show.setElapsedTime(show.getShowLength() - timer.getTimeValue());
		PausedState.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(PausedState.getInstance());
	}
	
	/**
	 * Process stop
	 */
	@Override
	public void stopRequest() {
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
//		VideoPlayerContext.getInstance().showStopped(); <- this should be handled by showEndedState upon entering.
	}
	
	/**
	 * Process fast forwarding
	 */
	@Override
	public void fastFowardRequest() {
		show.setElapsedTime(show.getShowLength() - timer.getTimeValue());
		FastForwardState.getInstance().setShow(show);
		VideoPlayerContext.getInstance().changeState(FastForwardState.getInstance());
	}
	
	/**
	 * Process timer tick
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		// show time left
		VideoPlayerContext.getInstance().showTimeLeft(timerValue);
	}

	/**
	 * Process the video ending
	 */
	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub
		// show 0 time left
		// change to idle state
	}

	/**
	 * Process leaving playing state
	 */
	@Override
	public void leave() {

		// set clock to zero and null
		// change video player context to not playing
		timer.stop();
		timer = null;

		// if show is finished or stop button is pressed reset show's elapsed time
	}

	/**
	 * Enter playing state
	 */
	@Override
	public void enter() {
		// create new timer
		// show time of video

		// Can't just create a new timer can we? What happens when we leave
		// playing state to paused state and return? Need some way to track elapsed
		// time? I think maybe have that be another field in the show object that
		// can be stored and retrieved whenever leaving the state?
		show = VideoPlayerContext.getInstance().getShow();
		timer = new Timer(this, show.getShowLength() - show.getElapsedTime());
		VideoPlayerContext.getInstance().showPlaying();
		VideoPlayerContext.getInstance().showSelected();
	}

	@Override
	public void onTimerRunsOut() {
		// show that there is 0 time remaining
		// change to ShowEndedState
		VideoPlayerContext.getInstance().showStopped();
		VideoPlayerContext.getInstance().showTimeLeft(0);
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
	}

}
