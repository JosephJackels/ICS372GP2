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
	// off, select, stop (unselected)
	
	@Override
	public void offRequest() {
		
	}
	
	@Override
	public void playRequest() {
		timer.stop();
		VideoPlayerContext.getInstance().changeState(PlayingState.getInstance());
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		timer.stop();
		VideoPlayerContext.getInstance().showTimeLeft(0);
	}

	@Override
	public void enter() {
		VideoPlayerContext.getInstance().getShow().setElapsedTime(0);
		VideoPlayerContext.getInstance().showStopped();
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
		ScreenSaverState.getInstance().setPreviousState(UnselectedState.getInstance());
		VideoPlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void onVideoRunsOut() {
		// TODO Auto-generated method stub
	}

}
