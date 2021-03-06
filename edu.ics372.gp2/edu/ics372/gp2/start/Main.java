package edu.ics372.gp2.start;

import edu.ics372.gp2.displays.GUIDisplay;
import javafx.application.Application;

/**
 * This class starts the program.
 * 
 * @author Dilli, Joseph, Andy , Leo, Austin
 *
 */
public class Main {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}
