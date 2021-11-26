/**
 * 
 */
package edu.ics372.gp2.displays;

import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import edu.ics372.gp2.buttons.*;
import edu.ics372.gp2.states.VideoPlayerContext;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

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
	private GUIButton selectButton;
	private Text videoPlayerStatus = new Text("Off");
	private Text timerValue = new Text("            ");
	private Text showSelectingStatus = new Text("Off");
	private Text playingStatus = new Text("Off");
	
	@Override
	public void start(Stage arg0) throws Exception {
		offButton = new OffButton("Off");
		onButton = new OnButton("On");
		pauseButton = new PauseButton("Pause");
		playButton = new PlayButton("Play");
		rewindButton = new RewindButton("Rewind");
		fastForwardButton = new FastFowardButton("Fast Forward");
		stopButton = new StopButton("Stop");
		selectButton = new SelectButton("Select");
		GridPane pane = new GridPane();
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.add(offButton, 0, 1);
		pane.add(onButton, 1, 1);
		pane.add(selectButton, 2, 1);
		pane.add(playButton, 3, 1);
		pane.add(stopButton, 4, 1);
		pane.add(pauseButton, 5, 1);
		pane.add(rewindButton, 6, 1);
		pane.add(fastForwardButton, 7, 1);
		pane.add(videoPlayerStatus, 4, 0);
		Scene scene = new Scene(pane);
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
		videoPlayerStatus.setText("idle: show unselected");

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
		videoPlayerStatus.setText("idle: show selected");
	}

}
