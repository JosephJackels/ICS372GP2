package edu.ics372.gp2.collections;

import java.util.Iterator;

import edu.ics372.gp2.entities.Show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * ShowList is used to store a collection of show objects.
 * 
 * @author Austin Wang
 *
 */
public class ShowList {
	private ObservableList<Show> shows = FXCollections.observableArrayList();
	private static ShowList showList;

	/**
	 * Creates the showList
	 */
	private ShowList() {
		defaultShows();
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
	 * Adding a show to the list
	 * 
	 * @param show
	 * @return true iff show can be added
	 */
	public boolean insertShow(Show show) {
		return shows.add(show);
	}

	/**
	 * @return return an ObservableList that contains many shows.
	 */
	public ObservableList<Show> getShowsList() {
		return shows;
	}

	/**
	 * Removes a show from showList
	 * 
	 * @param showName
	 * @return true iff show could be removed
	 */
	public boolean removeShow(String showName) {
		Iterator<Show> iterator = getShowsIterator();
		while (iterator.hasNext()) {
			Show show = iterator.next();
			if (showName.equals(show.getShowName())) {
				shows.remove(shows.indexOf(show));
				return true;
			}
		}
		return false;
	}

	public Iterator<Show> getShowsIterator() {
		return shows.listIterator();
	}
	
	private void defaultShows() {
		for (int i = 1; i < 6; i++) {
			String showName = "N" + i;
			int showLength = 10 * i;
			insertShow(new Show(showName, showLength));
		}
	}

}
