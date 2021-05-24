package Login;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;


public class Add_Sub_Vec extends Application {

    public void start(Stage addsubVec) {

        addsubVec.setTitle("Addition and Subtraction Vector");
        addsubVec.setWidth(700);
        addsubVec.setHeight(500);

        VBox addsubVBox = new VBox();
        Scene addsubScene = new Scene(addsubVBox);
        addsubVec.setScene(addsubScene);


        HBox v1HBox = new HBox();
        v1HBox.setMinHeight(100);
        v1HBox.setMinWidth(700);
        v1HBox.setAlignment(Pos.CENTER_LEFT);
        HBox operationHBox = new HBox();
        operationHBox.setMinHeight(110);
        operationHBox.setMinWidth(700);
        operationHBox.setAlignment(Pos.CENTER_LEFT);
        HBox v2HBox = new HBox();
        v2HBox.setMinHeight(100);
        v2HBox.setMinWidth(700);
        v2HBox.setAlignment(Pos.CENTER_LEFT);
        HBox resultHBox = new HBox();
        resultHBox.setMinHeight(90);
        resultHBox.setMinWidth(700);
        resultHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setMinHeight(70);
        endHBox.setMinWidth(700);
        endHBox.setAlignment(Pos.BASELINE_CENTER);


        Label v1Label = new Label("     V1:     ");
        v1Label.setStyle("-fx-font-size: 30 px");
        Label x1Label = new Label("x    ");
        x1Label.setStyle("-fx-font-size: 22 px");
        Label y1Label = new Label("       y    ");
        y1Label.setStyle("-fx-font-size: 22 px");
        Label operationLabel = new Label("     Operation:    ");
        operationLabel.setStyle("-fx-font-size: 30 px");
        Label v2Label = new Label("     V2:     ");
        v2Label.setStyle("-fx-font-size: 30 px");
        Label x2Label = new Label("x    ");
        x2Label.setStyle("-fx-font-size: 22 px");
        Label y2Label = new Label("      y    ");
        y2Label.setStyle("-fx-font-size: 22 px");
        Label resultLabel = new Label("     Result:    ");
        resultLabel.setStyle("-fx-font-size: 30 px");
        Label resultCheck = new Label();


        TextField x1Text = new TextField();
        x1Text.setMinHeight(25);
        TextField y1Text = new TextField();
        y1Text.setMinHeight(25);
        TextField x2Text = new TextField();
        x2Text.setMinHeight(25);
        TextField y2Text = new TextField();
        y2Text.setMinHeight(25);

        MenuButton operation = new MenuButton("Choose the operation");
        operation.setStyle("-fx-font-size: 22 px");

        MenuItem add = new MenuItem("+");
        MenuItem sub = new MenuItem("-");

        Button test = new Button("Test");
        test.setStyle("-fx-font-size: 22 px");
        Label nul = new Label("     ");
        Button result = new Button("Result");
        result.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("    ");
        Button create = new Button("Create");
        create.setStyle("-fx-font-size: 22 px");


        ///////////////////

        add.setOnAction(e->{operation.setText("+");});
        sub.setOnAction(e->{operation.setText("-");});

        ///////////////////




        v1HBox.getChildren().addAll(v1Label, x1Label, x1Text, y1Label, y1Text);
        operationHBox.getChildren().addAll(operationLabel, operation);
        v2HBox.getChildren().addAll(v2Label, x2Label, x2Text, y2Label, y2Text);
        resultHBox.getChildren().addAll(resultLabel, resultCheck);
        endHBox.getChildren().addAll(test, nul, result, empty, create);
        operation.getItems().addAll(add, sub);
        addsubVBox.getChildren().addAll(v1HBox, operationHBox, v2HBox, resultHBox, endHBox);
        addsubVec.show();




    }
}
