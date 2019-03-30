import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Tetris extends Application{

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
	 * starts a new game
	 * 
	 * @param primaryStage
	 */
	public void newGame(Stage primaryStage) {
		
		final int width = 300;
		final int hight = 500;
		
		primaryStage.setTitle("Tetris");
		
		final Pane root = new Pane();
		
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
	

}
