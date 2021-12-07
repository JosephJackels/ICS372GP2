package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for stop request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class StopButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for stopping
	 * 
	 * @param string the text on the stop button
	 */
	public StopButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on stop button
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().stopRequest();
	}

}
