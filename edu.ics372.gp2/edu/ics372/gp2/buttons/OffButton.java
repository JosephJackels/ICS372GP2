package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for off request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class OffButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for turning the video player off
	 * 
	 * @param string the text for the off button
	 */
	public OffButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on the off button
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().offRequest();
	}

}
