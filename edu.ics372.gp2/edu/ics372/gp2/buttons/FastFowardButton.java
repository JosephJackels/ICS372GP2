package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for fast forward request
 */
public class FastFowardButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for fast forwarding
	 * 
	 * @param string
	 */
	public FastFowardButton(String string) {
		super(string);
	}
	
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().fastForwardRequest();
	}

}
