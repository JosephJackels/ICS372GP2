package edu.ics372.gp2.buttons;

import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SelectButton extends GUIButton implements EventHandler<ActionEvent>{

	public SelectButton(String string) {
		super(string);
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		VideoPlayerContext.getInstance().onSelectRequest();
		
	}

}
