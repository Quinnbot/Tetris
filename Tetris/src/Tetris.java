import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Tetris extends Application  {

	private static Controls Game;//to store the game object in.
	/**
	 * starts the game
	 * @param args
	 */
	public static void main(String[] args) {
		
		launch(args);

	}
	
	/**
	 * displays the main game screen with the options to start the game and exit.
	 */
	public  void start(Stage primaryStage) {
		
		final int width = 200;
		final int hight = 200;
		
		primaryStage.setTitle("Tetris");
		
		final Pane root = new Pane();
		
		final Button btnS = new Button();
		btnS.setAlignment(Pos.CENTER);
		btnS.setText("Start!");
		btnS.setLayoutX(width/2.43);
		btnS.setLayoutY(hight/9);
		btnS.setOnAction(new EventHandler<ActionEvent>() {//start game button
			
			public void handle(ActionEvent event) {
				newGame(primaryStage);
			}
			
		});
		
		final Button btnE = new Button();
		btnE.setText("exit");
		btnE.setLayoutX(width/2.5);
		btnE.setLayoutY((hight/9)*3);
		btnE.setOnAction(new EventHandler<ActionEvent>() {//exit button
			
			public void handle(ActionEvent event) {
				System.exit(0);
			}
			
		});
		
		root.getChildren().add(btnS);
		root.getChildren().add(btnE);
		
		primaryStage.setResizable(false);
		
		primaryStage.setScene(new Scene(root, width, hight));
		primaryStage.show();
	}

	
	
	/**
	 *stores the game object and sets up the controls.
	 * 
	 * @param primaryStage
	 */
	public void newGame(Stage primaryStage) {
		
		Game = new Controls();
		
		final int width = (Game.getDeX()*10)+Game.getSep();
		final int hight = (Game.getDey()*20)+Game.getSep();
		
		primaryStage.setTitle("Tetris");
		
		final Pane Mainroot = new Pane();
		
		Mainroot.setOnKeyPressed(new EventHandler<KeyEvent>() {//controls
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.R) {
					Game.rotateR();
				}
				if(event.getCode() == KeyCode.E) {
					Game.rotateL();
				}
				if(event.getCode() == KeyCode.RIGHT) {
					Game.moveR();
				}
				if(event.getCode() == KeyCode.LEFT) {
					Game.moveL();
				}
				if(event.getCode() == KeyCode.DOWN) {
					Game.moveD();
				}
				if(event.getCode() == KeyCode.TAB) {
					Game.printGrid();
				}
			}
		});
		
		
		for(int x = 0; x<10; x++) {
			for(int y = 0; y<20; y++) {
				Mainroot.getChildren().addAll(Game.getMain()[x][y]);//packs the game board
			}
		}
		
		primaryStage.setScene(new Scene(Mainroot, width, hight));
		primaryStage.show();
		Mainroot.requestFocus();//sets focus so that you can actually use the controls.

		
		
	}
	
}
