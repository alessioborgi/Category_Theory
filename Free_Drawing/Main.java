package Free_Drawing;

/**
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
    /*
        This class has the power to create the stage for the new Free_Drawing stage.
     */
    public static Parent root;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
            Implementation of the Abstract Class of the Application class.
         */
        root = FXMLLoader.load(getClass().getResource("Free.fxml"));
        Scene  scene  =  new  Scene(root, 700, 775);
        scene.getStylesheets().add("MyStyles.css");
        primaryStage.setTitle("Free Graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
