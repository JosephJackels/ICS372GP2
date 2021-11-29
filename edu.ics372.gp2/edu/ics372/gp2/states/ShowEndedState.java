package edu.ics372.gp2.states;

import edu.ics372.gp2.timer.Notifiable;
import edu.ics372.gp2.timer.Timer;

public class ShowEndedState extends VideoPlayerState implements Notifiable{
	/**
	 * Show has ended, waits for 10 seconds until either: press Play to restart show
	 * (enter playing state) press Stop to end timer and deselct show (enter
	 * unselcted state) press Select to select a different show
	 */
	private static ShowEndedState instance;
	private Timer timer = null;

	private ShowEndedState() {

	}

	public static ShowEndedState getInstance() {
		if (instance == null) {
			instance = new ShowEndedState();
		}
		return instance;
	}
	
	//TODO handle events once a show is stopped
	
	@Override
	public void playRequest() {
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		// TODO show 10 second count down
		timer = new Timer(this, 10);
		VideoPlayerContext.getInstance().showTimeLeft(10);
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub
		VideoPlayerContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		VideoPlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub
	}

}
