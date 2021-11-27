/**
 * 
 */
package edu.ics372.gp2.displays;

import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import edu.ics372.gp2.buttons.*;
import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private Text videoPlayerStatus = new Text("Off");
	private Text timerValue = new Text("            ");
	private Text showSelectingStatus = new Text("Off");
	private Text playingStatus = new Text("Off");
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

		
		HBox stage = new HBox();
		VBox buttonControls = new VBox();
		VBox displayContainer = new VBox();
		TextFlow statusDisplay = new TextFlow();
		statusDisplay.setPadding(new Insets(5, 10, 10, 10));
		statusDisplay.setStyle("-fx-background-color: white;" + "-fx-border-color: black");
		statusDisplay.setMinWidth(500);
		statusDisplay.setMinHeight(140);
		
		statusDisplay.getChildren().add(videoPlayerStatus);
		buttonControls.getChildren().addAll(onButton, offButton, playButton, 
				stopButton, pauseButton, fastForwardButton, rewindButton);
		displayContainer.getChildren().addAll(statusDisplay, showText);
		stage.getChildren().addAll(buttonControls, displayContainer);
		
		Scene scene = new Scene(stage, 553, 600);
		arg0.setScene(scene);
		
		arg0.setTitle("video Player");
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

	}

	@Override
	public void showTurnOn() {
		videoPlayerStatus.setText("On");

	}

	@Override
	public void showTurnOff() {
		videoPlayerStatus.setText("Off");

	}

	@Override
	public void showPaused() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showPlaying() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showStopped() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showSelected() {
		showSelectingStatus.setText("idle: show selected");
	}

	@Override
	public void showUnselected() {
		showSelectingStatus.setText("idle: show unselected");		
	}

	@Override
	public void showSelectingOff() {
		showSelectingStatus.setText("Off");
		
	}
	
	
}
