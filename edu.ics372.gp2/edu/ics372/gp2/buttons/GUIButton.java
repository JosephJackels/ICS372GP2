package edu.ics372.gp2.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * This class represents the abstract GUIButton object which eliminates the
 * conditional.
 * 
 * @author Dilli, Joseph, Austin, Andy, Leo
 *
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {
	/**
	 * Create button with proper text. This button listen to itself whenever it is
	 * clicked.
	 * 
	 * @param string the text of the button
	 */
	public GUIButton(String string) {
		super(string);
		setOnAction(this);
	}
}
