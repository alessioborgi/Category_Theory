package Free_Drawing.menu;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author elenamuia
 * @author alessioborgi
 * @author federicavaleau
 * @author francescodanese
 * @created 24 / 05 / 2021 - 15:52
 * @project CATEGORY_THEORY
 */

/**
 * This code opens a window from the button "Free Drawing" in the Draw menu from the main page.
 * In this window, the user can define the Id of the created vertex. So the user can add the ID in the proper TextField.
 * Then when "Create" is pressed, in the last page a new vertex is created having the selected ID and if the user 
 * doesn't set a new ID, the following one will be again the increasing numbers (look at Vertex.java)
 */

public class Define_ID extends Application{

    public static TextField idNode1Text;
    public static Button create;

    public void start(Stage new_vertex) {

        new_vertex.setWidth(500);
        new_vertex.setHeight(250);
        new_vertex.setTitle("Define ID");

        VBox newVertexVBox = new VBox();
        newVertexVBox.getStyleClass().add("background");
        Scene newVertexScene = new Scene(newVertexVBox);
        newVertexScene.getStylesheets().add("Login/Styles.css");
        new_vertex.setScene(newVertexScene);

        HBox idNode1HBox = new HBox();
        idNode1HBox.setMinHeight(100);
        idNode1HBox.setMinWidth(500);
        idNode1HBox.setAlignment(Pos.CENTER_LEFT);

       HBox createHBOX = new HBox();
        createHBOX.setMinHeight(100);
        createHBOX.setMinWidth(500);
        createHBOX.setAlignment(Pos.CENTER);

        Label idNode1 = new Label("    ID Node 1:   ");
        idNode1.setStyle("-fx-font-size: 30 px");

        idNode1Text = new TextField();
        idNode1Text.setPromptText("Insert the ID...");
        idNode1Text.setMinHeight(25);

        TextField compositionText = new TextField();
        compositionText.setPromptText(" Arrow ID...");
        compositionText.setMinHeight(25);

        create = new Button("Create");
        create.setStyle("-fx-font-size: 22 px");
        create.getStyleClass().add("button-create");

        idNode1HBox.getChildren().addAll(idNode1, idNode1Text);
        createHBOX.getChildren().addAll(create);
        newVertexVBox.getChildren().addAll(idNode1HBox, createHBOX);
        new_vertex.show();
    }
}
