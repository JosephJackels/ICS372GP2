package edu.ics372.gp2.buttons;

import edu.ics372.gp2.collections.ShowList;
import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

/**
 * This class represents the show object selected. Each show will get selected
 * whenever it receives a mouse click after the video player is on. The selected
 * show will get displayed on the main screen.
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 *
 */
public class SelectControl extends ListView<Show> {
	public SelectControl() {
		super(ShowList.getInstance().getShowsList());
		setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				Show show = getSelectionModel().getSelectedItem();
				VideoPlayerContext.getInstance().selectRequest(show);
			}
		});

	}
}
