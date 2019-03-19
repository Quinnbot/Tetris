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
		
		final int width = 300;
		final int hight = 500;
		
		primaryStage.setTitle("Tetris");
		
		final Pane root = new Pane();
		
		final Button btnS = new Button();
		btnS.setAlignment(Pos.CENTER);
		btnS.setText("Start!");
		btnS.setLayoutX(width/2.43);
		btnS.setLayoutY(hight/9);
		
		final Button btnC = new Button();
		btnC.setText("control");
		btnC.setLayoutX(width/2.5);
		btnC.setLayoutY((hight/9)*2);

		root.getChildren().add(btnS);
		root.getChildren().add(btnC);
		
		primaryStage.setScene(new Scene(root, width, hight));
		primaryStage.show();
		
		
	}
	

}
