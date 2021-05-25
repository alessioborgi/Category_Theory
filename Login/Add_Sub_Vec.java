package Login;

/**
 * @author alessioborgi
 * @created 24 / 05 / 2021 - 15:56
 * @project CATEGORY_THEORY
 */

import Vector_Category.Vector;
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

        addsubVec.setTitle("Group Category");
        addsubVec.setWidth(700);
        addsubVec.setHeight(500);

        VBox addsubVBox = new VBox();
        addsubVBox.getStyleClass().add("background");
        Scene addsubScene = new Scene(addsubVBox);
        addsubScene.getStylesheets().add("Login/Styles.css");
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
        x1Text.setPromptText("First Vector's X"); //to set the hint text
        x1Text.setMinHeight(25);
        TextField y1Text = new TextField();
        y1Text.setPromptText("First Vector's Y"); //to set the hint text
        y1Text.setMinHeight(25);
        TextField x2Text = new TextField();
        x2Text.setPromptText("Second Vector's X"); //to set the hint text
        x2Text.setMinHeight(25);
        TextField y2Text = new TextField();
        y2Text.setPromptText("second Vector's Y"); //to set the hint text
        y2Text.setMinHeight(25);

        MenuButton operation = new MenuButton("Choose the operation");
        operation.getStyleClass().add("menu-create");
        operation.setStyle("-fx-font-size: 22 px");

        MenuItem add = new MenuItem("+");
        add.getStyleClass().add("menu-create");
        MenuItem sub = new MenuItem("-");
        sub.getStyleClass().add("menu-create");

        Button test = new Button("Test");
        test.getStyleClass().add("button-create");
        test.setStyle("-fx-font-size: 22 px");
        Label nul = new Label("     ");
        Button result = new Button("Result");
        result.getStyleClass().add("button-create");
        result.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("    ");
        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
        create.setStyle("-fx-font-size: 22 px");

        ///////////////////

        add.setOnAction(e->{operation.setText("+");});
        sub.setOnAction(e->{operation.setText("-");});

        ///////////////////


        result.setOnAction(e->{
            int x1 = Integer.parseInt(x1Text.getText());
            int y1 = Integer.parseInt(y1Text.getText());
            int x2 = Integer.parseInt(x2Text.getText());
            int y2 = Integer.parseInt(y2Text.getText());

            Vector<Integer> v1 = new Vector<>();
            v1.add(x1);
            v1.add(y1);
            Vector<Integer> v2 = new Vector<>();
            v2.add(x2);
            v2.add(y2);

            if (operation.getText().equals("+")){
                resultCheck.setText("" + v1.addition(v2));
                resultCheck.setStyle("-fx-font-size: 22 px");}
            else{
                resultCheck.setText(v1.subtraction(v2).toString());
                resultCheck.setStyle("-fx-font-size: 22 px");
            }
        });




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
