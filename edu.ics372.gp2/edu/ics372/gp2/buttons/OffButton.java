package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for off request
 */
public class OffButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for turning the video player off
	 * 
	 * @param string
	 */
	public OffButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().offRequest();
	}

}
