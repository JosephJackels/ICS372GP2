package edu.ics372.gp2.buttons;

import edu.ics372.gp2.collections.ShowList;
import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

public class SelectControl extends ListView<Show> {
	public SelectControl() {
		super(ShowList.getInstance().getShowsList());
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				Show show = (Show) getSelectionModel().getSelectedItem();
				VideoPlayerContext.getInstance().selectRequest(show);
			}
		});

	}
}
