package UI;

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
            MainController mainController = mainLoader.getController();
            Scene scene = new Scene(root);
            primaryStage.setTitle("TTRPG Toolbox");
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(image);
            primaryStage.show();

            //call the initialization into the main controller
            mainController.initializeControllers(primaryStage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}