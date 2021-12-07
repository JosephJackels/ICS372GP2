package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for fast forward request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class FastFowardButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for fast forwarding
	 * 
	 * @param string the text for the button
	 */
	public FastFowardButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on the fast forward button.
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().fastForwardRequest();
	}

}
