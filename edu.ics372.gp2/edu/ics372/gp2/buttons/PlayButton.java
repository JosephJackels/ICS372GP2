package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The button for play request
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 */
public class PlayButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * The button for playing
	 * 
	 * @param string the text on the play button
	 */
	public PlayButton(String string) {
		super(string);
	}

	/**
	 * This handles the click on the play button
	 */
	@Override
	public void handle(ActionEvent event) {
		VideoPlayerContext.getInstance().playShowRequest();
	}

}
