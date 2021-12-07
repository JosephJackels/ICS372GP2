package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for rewind request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class RewindButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for rewinding
	 * 
	 * @param string the text on the rewind button
	 */
	public RewindButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on the rewind button
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().rewindRequest();
	}

}
