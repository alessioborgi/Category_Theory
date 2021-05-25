package Free_Drawing; /**
 * @created 22 / 05 / 2021 - 14:40
 * @project CATEGORY_THEORY
 * @author alessioborgi
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {
    public static Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("Free.fxml"));
        Scene  scene  =  new  Scene(root, 800, 800);
        scene.getStylesheets().add("MyStyles.css");
        primaryStage.setTitle("Free Graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
