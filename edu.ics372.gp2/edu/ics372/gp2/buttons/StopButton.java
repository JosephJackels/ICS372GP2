package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for stop request
 */
public class StopButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for stopping
	 * 
	 * @param string
	 */
	public StopButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().stopRequest();
	}

}
