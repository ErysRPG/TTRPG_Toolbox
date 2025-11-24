package UI;

import CharacterSheet.CharacterController;
import Journal.JournalController;
import RandomTables.tablesController;
import SaveLoad.saveLoadController;
import javafx.application.Application;
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

            // load primary view
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("mainView.fxml"));
            Parent root = mainLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("TTRPG Toolbox");
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(image);
            primaryStage.show();

            // load controllers
            FXMLLoader characterLoader = new FXMLLoader(getClass().getResource("/CharacterSheet/characterView.fxml"));
            characterLoader.load();
            CharacterController characterController = characterLoader.getController();

            FXMLLoader journalLoader = new FXMLLoader(getClass().getResource("/Journal/journalView.fxml"));
            journalLoader.load();
            JournalController journalController = journalLoader.getController();

            FXMLLoader tablesLoader = new FXMLLoader(getClass().getResource("/RandomTables/tablesView.fxml"));
            tablesLoader.load();
            tablesController tablesController = tablesLoader.getController();

            // load save controller
            FXMLLoader saveLoader = new FXMLLoader(getClass().getResource("/SaveLoad/saveLoadView.fxml"));
            saveLoader.load();
            saveLoadController saveCtrl = saveLoader.getController();

            // pass references
            saveCtrl.setPrimaryStage(primaryStage);
            saveCtrl.setCharacterController(characterController);
            saveCtrl.setJournalController(journalController);
            saveCtrl.setTablesController(tablesController);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}