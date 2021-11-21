package edu.ics372.gp2.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PauseButton extends GUIButton implements EventHandler<ActionEvent> {

	public PauseButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Change state to paused
	}

}
