package edu.ics372.gp2.collections;

import java.beans.PropertyChangeSupport;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.ics372.gp2.entities.Show;

/**
 * ShowList is used to store a collection of show objects.
 * 
 * @author Austin Wang
 *
 */
public class ShowList {
	private List<Show> shows = new LinkedList<Show>();
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	private static ShowList showList;

	/**
	 * Creates the showList
	 */
	private ShowList() {

	}

	/**
	 * Creates instance of ShowList if it doesn't already exist.
	 *
	 * @return instance of ShowList
	 */
	public static ShowList getInstance() {
		if (showList == null) {
			showList = new ShowList();
		}
		return showList;
	}

	/**
	 * adding show to the list
	 * 
	 * @param show
	 * @return true iff show can be added
	 */
	public boolean insertShow(Show show) {
		return shows.add(show);
	}

	/**
	 * Searches for a show given a show's name.
	 * 
	 * @param showName
	 * @return show or null if show not found
	 */
	public Show getShow(String showName) {
		Iterator<Show> iterator = shows.listIterator();
		while (iterator.hasNext()) {
			Show show = iterator.next();
			if (showName.equals(show.getShowName())) {
				return show;
			}
		}
		return null;
	}

	/**
	 * Removes a show from showList
	 * 
	 * @param showName
	 * @return true iff show could be removed
	 */
	public boolean removeMember(String memberId) {
		Show show = getShow(memberId);
		if (show == null) {
			return false;
		} else {
			return shows.remove(show);
		}
	}

	public Iterator<Show> getMembers() {
		return shows.listIterator();
	}

}
