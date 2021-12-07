package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for on request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class OnButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for turning the video player on
	 * 
	 * @param string
	 */
	public OnButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on the On button
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().onRequest();
	}

}
