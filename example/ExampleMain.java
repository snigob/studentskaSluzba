package example;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExampleMain extends Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(ExampleMain.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = ExampleMain.class.getResource("MainView.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

        try {
            Parent root = (Parent) fxmlLoader.load(location.openStream());

            // in case you need access to the controller
            MainViewController mainViewController = fxmlLoader.getController();

            primaryStage.setScene(new Scene(root, 900, 600));
            Scene s = primaryStage.getScene();
            s.setRoot(root);
            primaryStage.sizeToScene();
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}