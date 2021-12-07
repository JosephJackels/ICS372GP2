package edu.ics372.gp2.entities;

/**
 * This class represents a show. It has the show name and the show length;
 * 
 * @author Austin
 *
 */
public class Show {
	private String showName;
	private int showLength;
	private int elapsedTime;

	public Show(String showName, int showLength) {
		this.showName = showName;
		this.setShowLength(showLength);
		elapsedTime = 0;
	}

	public String getShowName() {
		return showName;
	}

	public int getShowLength() {
		return showLength;
	}

	public void setShowLength(int showLength) {
		this.showLength = showLength;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	public void increaseTime(int time) {
		elapsedTime += time;
		if (elapsedTime > showLength) {
			elapsedTime = showLength;
		}
	}
	
	public void decreaseTime(int time) {
		elapsedTime -= time;
		if (elapsedTime < 0) {
			elapsedTime = 0;
		}
	}

	@Override
	public String toString() {
		return showName + " " + showLength + " seconds";
	}

}
