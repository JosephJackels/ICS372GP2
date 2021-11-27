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

	public Show(String showName, int showLength) {
		this.showName = showName;
		this.setShowLength(showLength);
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
	
	@Override
	public String toString() {
		return showName + " " + showLength + " seconds";
	}

}
