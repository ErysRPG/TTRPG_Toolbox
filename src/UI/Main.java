package UI;
	
import java.util.List;

import CharacterSheet.CharacterController;
import Journal.JournalController;
import Journal.JournalEntry;
import RandomTables.tablesController;
import SaveLoad.saveLoadController;
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
			
			// load the three controllers
			FXMLLoader characterLoader = new FXMLLoader(getClass().getResource("/CharacterSheet/characterView.fxml"));
			Parent root1 = characterLoader.load();
			CharacterController characterController = characterLoader.getController();

			FXMLLoader journalLoader = new FXMLLoader(getClass().getResource("/Journal/journalView.fxml"));
			Parent root2 = journalLoader.load();
			JournalController journalController = journalLoader.getController();
			
			FXMLLoader tablesLoader = new FXMLLoader(getClass().getResource("/RandomTables/tablesView.fxml"));
			Parent root3 = tablesLoader.load();
			tablesController tablesController = tablesLoader.getController();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/SaveLoad/saveLoadView.fxml"));
			Parent root4 = loader.load();
			saveLoadController saveCtrl = loader.getController();
			saveCtrl.setPrimaryStage(primaryStage);

			saveCtrl.setCharacterController(characterController);
			saveCtrl.setJournalController(journalController);
			saveCtrl.setTablesController(tablesController);



		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}