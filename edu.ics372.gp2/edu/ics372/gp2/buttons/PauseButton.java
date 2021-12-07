package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for pause request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class PauseButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for pausing
	 * 
	 * @param string the text on the pause button
	 */
	public PauseButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on the pause button
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().pauseRequest();
	}

}
