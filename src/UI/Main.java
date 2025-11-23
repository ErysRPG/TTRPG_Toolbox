package UI;
	
import CharacterSheet.CharacterController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Image image = new Image("/resources/logo.png");
			Parent root = FXMLLoader.load(getClass().getResource("mainView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("TTRPG Toolbox");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(image);
			primaryStage.show();
			
			


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}