package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for rewind request
 */
public class RewindButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for rewinding
	 * 
	 * @param string
	 */
	public RewindButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().rewindRequest();
	}

}
