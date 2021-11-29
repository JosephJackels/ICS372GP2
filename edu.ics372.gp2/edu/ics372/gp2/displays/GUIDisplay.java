/**
 * 
 */
package edu.ics372.gp2.displays;

import edu.ics372.gp2.buttons.FastFowardButton;
import edu.ics372.gp2.buttons.GUIButton;
import edu.ics372.gp2.buttons.OffButton;
import edu.ics372.gp2.buttons.OnButton;
import edu.ics372.gp2.buttons.PauseButton;
import edu.ics372.gp2.buttons.PlayButton;
import edu.ics372.gp2.buttons.RewindButton;
import edu.ics372.gp2.buttons.SelectControl;
import edu.ics372.gp2.buttons.StopButton;
import edu.ics372.gp2.entities.Show;
import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Dilli
 *
 */
public class GUIDisplay extends Application implements VideoPlayerDisplay {

	private GUIButton offButton;
	private GUIButton onButton;
	private GUIButton pauseButton;
	private GUIButton playButton;
	private GUIButton rewindButton;
	private GUIButton fastForwardButton;
	private GUIButton stopButton;
	private Text videoPlayerStatus = new Text("Video Status: Off\n");
	private Text infoText = new Text("");
	private Text timerValue = new Text(" ");
//	private Text playingStatus = new Text("Not Started");
	private Text showText = new Text("Shows");

	@Override
	public void start(Stage arg0) throws Exception {
		offButton = new OffButton("OFF");
		onButton = new OnButton("ON");
		pauseButton = new PauseButton("PAUSE");
		playButton = new PlayButton("PLAY");
		rewindButton = new RewindButton("REW");
		fastForwardButton = new FastFowardButton("FF");
		stopButton = new StopButton("STOP");

//		//insert 2 shows as test subject
//		ShowList.getInstance().insertShow(new Show("World War Z Trailer", 30));
//		ShowList.getInstance().insertShow(new Show("The Grudge Trailer", 30));
		// create a listView
		ListView<Show> shows = new SelectControl();

		HBox stage = new HBox();
		VBox buttonControls = new VBox();
		VBox displayContainer = new VBox();
		TextFlow statusDisplay = new TextFlow();
		statusDisplay.setPadding(new Insets(5, 10, 10, 10));
		statusDisplay.setStyle("-fx-background-color: white;" + "-fx-border-color: black");
		statusDisplay.setMinWidth(500);
		statusDisplay.setMinHeight(140);

		statusDisplay.getChildren().addAll(videoPlayerStatus, infoText);
		statusDisplay.getChildren().add(timerValue);
//		statusDisplay.getChildren().add(showSelectingStatus);
		buttonControls.getChildren().addAll(onButton, offButton, playButton, stopButton, pauseButton, fastForwardButton,
				rewindButton);
		displayContainer.getChildren().addAll(statusDisplay, showText, shows);
		stage.getChildren().addAll(buttonControls, displayContainer);

		Scene scene = new Scene(stage, 553, 557);
		arg0.setScene(scene);

		arg0.setTitle("Video Player");
		VideoPlayerContext.getInstance().setDisplay(this);
		arg0.show();
		arg0.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	
	@Override
	public void showTimeRemaining(int time) {
		// TODO Auto-generated method stub
		timerValue.setText("Time Remaining: " + time + "\n");
	}
	
	/**
	 * Indicate the video player is off
	 */
	@Override
	public void showTurnOff() {
		videoPlayerStatus.setText("Video Status: Off\n");
		infoText.setText("");
		timerValue.setText("");
	}

	/**
	 * Indicate the video is paused
	 */
	@Override
	public void showPaused() {
		videoPlayerStatus.setText("Video Status: Paused\n");
	}

	/**
	 * Indicate the video is playing
	 */
	@Override
	public void showPlaying() {
		videoPlayerStatus.setText("Video Status: Playing\n");
		
	}

	/**
	 * Indicate show is ended (Should the name be changed to displayShowEnded?)
	 */
	@Override
	public void showStopped() {
		videoPlayerStatus.setText("Video Status: show ended\n");
		infoText.setText("");
		timerValue.setText("");
	}

	/**
	 * Indicate show is selected and displats show info
	 */
	@Override
	public void showSelected(String showName, String showLength) {
		videoPlayerStatus.setText("Video Status: Show selected\n");
		infoText.setText("Show: " + showName + "\nShow length: " + showLength + " seconds\n");
//		playingStatus.setText("Not Started\n");
	}

	/**
	 * Indicate no show is selected
	 */
	@Override
	public void showUnselected() {
		videoPlayerStatus.setText("Video Status: Show unselected");
		infoText.setText("");
		timerValue.setText("");
//		playingStatus.setText("");
	}

	/*
	 * Is this needed since selecting off is just the unselected state right?
	 */
	@Override
	public void showSelectingOff() {
		videoPlayerStatus.setText("Off");

	}

	/**
	 * Indicate video player is in screen saver mode
	 */
	@Override
	public void showScreenSaver() {
		videoPlayerStatus.setText("Video Status: Screen Saver");
		infoText.setText("");
		timerValue.setText("");
//		playingStatus.setText("");

	}

}
