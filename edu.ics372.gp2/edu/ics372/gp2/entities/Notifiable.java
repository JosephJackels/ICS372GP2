package edu.ics372.gp2.entities;

public interface Notifiable {
	
	public void OnTimerTick(int timerValue);
	
	public void onVideoRunsOut();
}
