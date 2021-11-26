package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;

/**
 * Represents the playing state
 * @author leo
 *
 */
public class PlayingState extends VideoPlayerState implements Notifiable{
	private static PlayingState instance;
	
	/**
	 * Singleton for playing state
	 */
	private PlayingState() {
		
	}
	
	/**
	 * Creates lone instance of playing state
	 * @return
	 */
	public static PlayingState getInstance() {
		if (instance == null) {
			instance = new PlayingState();
		}
		return instance;
	}
	
	//TODO add other events
	
	/**
	 * Process play request
	 */
	@Override
	public void onPlayRequest() {
		//update timer
		//display time
	}
	
	/**
	 * Process timer tick
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		// show time left
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
	public void leave(VideoPlayerState newState) {
		//set clock to zero and null
		//change video player context to not playing
	}

	/**
	 * Enter playing state
	 */
	@Override
	public void enter() {
		//create new timer
		//show time of video
	}

}
