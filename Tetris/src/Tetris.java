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

	private static Board Game;
	
	public static void main(String[] args) {
		
		launch(args);

	}
	
	
	public  void start(Stage primaryStage) {
		
		final int width = 500;
		final int hight = 700;
		
		primaryStage.setTitle("Tetris");
		
		final Pane root = new Pane();
		
		final Button btnS = new Button();
		btnS.setAlignment(Pos.CENTER);
		btnS.setText("Start!");
		btnS.setLayoutX(width/2.43);
		btnS.setLayoutY(hight/9);
		btnS.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				newGame(primaryStage);
			}
			
		});
		
		final Button btnC = new Button();
		btnC.setText("control");
		btnC.setLayoutX(width/2.5);
		btnC.setLayoutY((hight/9)*2);
		btnC.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				showControls(primaryStage);
			}
			
		});
		
		final Button btnP = new Button();
		btnP.setText("pieces");
		btnP.setLayoutX(width/2.5);
		btnP.setLayoutY((hight/9)*3);
		btnP.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.exit(0);
			}
			
		});
		
		final Button btnE = new Button();
		btnE.setText("exit");
		btnE.setLayoutX(width/2.5);
		btnE.setLayoutY((hight/9)*4);
		btnE.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.exit(0);
			}
			
		});
		
		root.getChildren().add(btnS);
		root.getChildren().add(btnC);
		root.getChildren().add(btnP);
		root.getChildren().add(btnE);
		
		primaryStage.setResizable(false);
		
		primaryStage.setScene(new Scene(root, width, hight));
		primaryStage.show();
	}

	
	
	/**
	 * shows Controls
	 * 
	 * @param primaryStage
	 */
	public void showControls(Stage primaryStage) {
		
		final int width = 300;
		final int hight = 500;
		
		primaryStage.setTitle("Tetris");
		
		final Pane root = new Pane();
		
		final Button btnB = new Button();
		btnB.setText("go back");
		btnB.setLayoutX(width/2.5);
		btnB.setLayoutY((hight/9)*6);
		btnB.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				start(primaryStage);
			}
			
		});
		
		root.getChildren().add(btnB);
		
		primaryStage.setScene(new Scene(root, width, hight));
		primaryStage.show();
	}
	
	
	
	
	public void newGame(Stage primaryStage) {
		
		Game = new Board();
		
		final int width = (Game.getDeX()*10)+Game.getSep();
		final int hight = (Game.getDey()*20)+Game.getSep();
		
		primaryStage.setTitle("Tetris");
		
		final Pane Mainroot = new Pane();
		
		Mainroot.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
			}
		});
		
		
		for(int x = 0; x<10; x++) {
			for(int y = 0; y<20; y++) {
				Mainroot.getChildren().addAll(Game.getMain()[x][y]);
			}
		}
		
		primaryStage.setScene(new Scene(Mainroot, width, hight));
		primaryStage.show();
		Mainroot.requestFocus();

		
		
	}
	
}
