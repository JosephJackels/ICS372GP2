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
	 * Process play request
	 */
	@Override
	public void playRequest() {
		// update timer
		// display time

		// shouldnt this method not do anything?
		// if the show is already playing, pressing play should do nothing right?
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

	public void offRequest() {
		VideoPlayerContext.getInstance().changeState(OffState.getInstance());
	}

	public void pauseRequest() {
		// save elapsed time somehow?
		show.setElapsedTime(show.getShowLength() - timer.getTimeValue());
		VideoPlayerContext.getInstance().changeState(PausedState.getInstance());
	}

	/**
	 * Process leaving playing state
	 */
	@Override
	public void leave(VideoPlayerState newState) {

		// set clock to zero and null
		// change video player context to not playing
		timer.stop();
		timer = null;

		// if show is finished or stop button is pressed reset show's elapsed time
		if (newState.equals(newState.equals(ShowEndedState.getInstance()))) {
			show.setElapsedTime(0);
		}

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

	}

	@Override
	public void onTimerRunsOut() {
		// show that there is 0 time remaining
		// change to ShowEndedState
		VideoPlayerContext.getInstance().showTimeLeft(0);
		VideoPlayerContext.getInstance().changeState(ShowEndedState.getInstance());
	}

}
