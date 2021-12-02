package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for play request
 */
public class PlayButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for playing
	 * 
	 * @param string
	 */
	public PlayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Process play, if show is selected
		VideoPlayerContext.getInstance().playShowRequest();
	}

}
