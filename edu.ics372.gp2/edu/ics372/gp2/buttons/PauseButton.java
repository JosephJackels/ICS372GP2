package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for pause request
 */
public class PauseButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for pausing
	 * 
	 * @param string
	 */
	public PauseButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().pauseRequest();
	}

}
