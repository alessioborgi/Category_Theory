package Free_Drawing.menu;
/**
 * @created 25 / 05 / 2021 - 23:13
 * @project CATEGORY_THEORY
 * @author alessioborgi
 */
import Free_Drawing.Controller;
import Free_Drawing.Vertex;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class New_Vertex extends Application{

    public static TextField idNode1Text;
    public static Button create;

    public void start(Stage new_vertex) {


        new_vertex.setWidth(700);
        new_vertex.setHeight(500);
        new_vertex.setTitle("New Vertex");

        VBox newVertexVBox = new VBox();
        newVertexVBox.getStyleClass().add("background");
        Scene newVertexScene = new Scene(newVertexVBox);
        newVertexScene.getStylesheets().add("Login/Styles.css");

        new_vertex.setScene(newVertexScene);

        //////////////////////////////////

        HBox idNode1HBox = new HBox();
        idNode1HBox.setMinHeight(100);
        idNode1HBox.setMinWidth(700);
        idNode1HBox.setAlignment(Pos.CENTER_LEFT);
        //HBox idNode2HBox = new HBox();
        //idNode2HBox.setMinHeight(100);
        //idNode2HBox.setMinWidth(700);
        //idNode2HBox.setAlignment(Pos.CENTER_LEFT);
        HBox compositionHBOX = new HBox();
        compositionHBOX.setMinHeight(100);
        compositionHBOX.setMinWidth(700);
        compositionHBOX.setAlignment(Pos.CENTER_LEFT);
        HBox createHBOX = new HBox();
        createHBOX.setMinHeight(100);
        createHBOX.setMinWidth(700);
        createHBOX.setAlignment(Pos.CENTER);


        Label idNode1 = new Label("    ID Node 1:   ");
        idNode1.setStyle("-fx-font-size: 30 px");
        Label idNode2 = new Label("    ID Node 2:  ");
        idNode2.setStyle("-fx-font-size: 30 px");
        Label composition = new Label("   Composition:    ");
        composition.setStyle("-fx-font-size: 30 px");

        idNode1Text = new TextField();
        idNode1Text.setPromptText("Insert the ID...");
        idNode1Text.setMinHeight(25);

        TextField idNode2Text = new TextField();
        idNode2Text.setPromptText("Insert the ID...");
        idNode2Text.setMinHeight(25);

        TextField compositionText = new TextField();
        compositionText.setPromptText(" ID node...");
        compositionText.setMinHeight(25);

        create = new Button("Create");
        create.setStyle("-fx-font-size: 22 px");
        create.getStyleClass().add("button-create");
        
        idNode1HBox.getChildren().addAll(idNode1, idNode1Text);
        //idNode2HBox.getChildren().addAll(idNode2, idNode2Text);

        compositionHBOX.getChildren().addAll(composition, compositionText);
        createHBOX.getChildren().addAll(create);
        newVertexVBox.getChildren().addAll(idNode1HBox, compositionHBOX, createHBOX);
        new_vertex.show();
    }
}
