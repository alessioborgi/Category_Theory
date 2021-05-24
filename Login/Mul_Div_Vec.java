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

public class Mul_Div_Vec extends Application {
    public void start(Stage muldivVec) {

        muldivVec.setTitle("Multiplication and Division Vector");
        muldivVec.setWidth(700);
        muldivVec.setHeight(500);

        VBox muldivVBox = new VBox();
        Scene muldivScene = new Scene(muldivVBox);
        muldivVec.setScene(muldivScene);

        HBox vHBox = new HBox();
        vHBox.setMinHeight(100);
        vHBox.setMinWidth(700);
        vHBox.setAlignment(Pos.CENTER_LEFT);
        HBox operationHBox = new HBox();
        operationHBox.setMinHeight(110);
        operationHBox.setMinWidth(700);
        operationHBox.setAlignment(Pos.CENTER_LEFT);
        HBox scalarHBox = new HBox();
        scalarHBox.setMinHeight(100);
        scalarHBox.setMinWidth(700);
        scalarHBox.setAlignment(Pos.CENTER_LEFT);
        HBox resultHBox = new HBox();
        resultHBox.setMinHeight(90);
        resultHBox.setMinWidth(700);
        resultHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setMinHeight(70);
        endHBox.setMinWidth(700);
        endHBox.setAlignment(Pos.BASELINE_CENTER);


        Label vLabel = new Label("     V1:     ");
        vLabel.setStyle("-fx-font-size: 30 px");
        Label xLabel = new Label("x    ");
        xLabel.setStyle("-fx-font-size: 25 px");
        Label yLabel = new Label("       y    ");
        yLabel.setStyle("-fx-font-size: 25 px");
        Label operationLabel = new Label("     Operation:    ");
        operationLabel.setStyle("-fx-font-size: 30 px");
        Label scalarLabel = new Label("     Scalar :     ");
        scalarLabel.setStyle("-fx-font-size: 30 px");
        Label kLabel = new Label("K    ");
        kLabel.setStyle("-fx-font-size: 25 px");
        Label resultLabel = new Label("     Result:    ");
        resultLabel.setStyle("-fx-font-size: 30 px");
        Label resultCheck = new Label();

        TextField xText = new TextField();
        xText.setMinHeight(25);
        TextField yText = new TextField();
        yText.setMinHeight(25);
        TextField kText = new TextField();
        kText.setMinHeight(25);

        MenuButton operation = new MenuButton("Choose the operation");
        operation.setStyle("-fx-font-size: 22 px");

        MenuItem mul = new MenuItem("*");
        MenuItem div = new MenuItem("/");

        Button test = new Button("Test");
        test.setStyle("-fx-font-size: 22 px");
        Label nul = new Label("     ");
        Button result = new Button("Result");
        result.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("    ");
        Button create = new Button("Create");
        create.setStyle("-fx-font-size: 22 px");

        ////////////////////////////
        mul.setOnAction(e->{operation.setText("*");});
        div.setOnAction(e->{operation.setText("/");});
        /////////////////////////////////


        vHBox.getChildren().addAll(vLabel, xLabel, xText, yLabel, yText);
        operationHBox.getChildren().addAll(operationLabel, operation);
        scalarHBox.getChildren().addAll(scalarLabel, kLabel, kText);
        resultHBox.getChildren().addAll(resultLabel, resultCheck);
        endHBox.getChildren().addAll(test, nul, result, empty, create);
        operation.getItems().addAll(mul, div);
        muldivVBox.getChildren().addAll(vHBox, operationHBox, scalarHBox, resultHBox, endHBox);




        muldivVec.show();





    }
}
