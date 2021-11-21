package edu.ics372.gp2.timer;

public interface Notifiable {
	public void OnTimerTick(int timerValue);
	public void onTimerRunsOut();
}
