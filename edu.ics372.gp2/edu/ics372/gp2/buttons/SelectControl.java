package edu.ics372.gp2.buttons;

import edu.ics372.gp2.collections.ShowList;
import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

public class SelectControl extends ListView {
	public SelectControl() {
		super(ShowList.getInstance().getShowsList()); // gets the ObservableList
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				/*
				 * Question: during the SelectedState(Idle; Show Selected in transition table),
				 * if we click on another show, will it change the selected show? or nothing
				 * will happen?
				 * 
				 * Answer: If another show is selected, the state would not change. It would
				 * still be in a show selected state regardless of which show is selected.
				 */
				Show show = (Show) getSelectionModel().getSelectedItem();
				/*
				 * VideoPlayerContext.getInstance().setShow(show);
				 * VideoPlayerContext.getInstance().selectRequest();
				 */
				VideoPlayerContext.getInstance().selectRequest(show);
			}
		});

	}
}
