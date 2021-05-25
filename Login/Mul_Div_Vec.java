package Login;

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

public class Mul_Div_Vec extends Application {
    public void start(Stage muldivVec) {

        muldivVec.setTitle("Group Category");
        muldivVec.setWidth(700);
        muldivVec.setHeight(500);

        VBox muldivVBox = new VBox();
        Scene muldivScene = new Scene(muldivVBox);
        muldivVec.setScene(muldivScene);

        HBox vHBox = new HBox();
        vHBox.setMinHeight(70);
        vHBox.setMinWidth(700);
        vHBox.setAlignment(Pos.CENTER_LEFT);
        HBox operationHBox = new HBox();
        operationHBox.setMinHeight(70);
        operationHBox.setMinWidth(700);
        operationHBox.setAlignment(Pos.CENTER_LEFT);
        HBox scalarHBox = new HBox();
        scalarHBox.setMinHeight(70);
        scalarHBox.setMinWidth(700);
        scalarHBox.setAlignment(Pos.CENTER_LEFT);
        HBox identityHBox = new HBox();
        identityHBox.setMinHeight(70);
        identityHBox.setMinWidth(700);
        identityHBox.setAlignment(Pos.CENTER_LEFT);
        HBox resultHBox = new HBox();
        resultHBox.setMinHeight(70);
        resultHBox.setMinWidth(700);
        resultHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setMinHeight(60);
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
        Label mulIdLabel = new Label("     IdCheck:  ");
        mulIdLabel.setStyle("-fx-font-size: 30 px");
        Label resultLabel = new Label("     Result:    ");
        resultLabel.setStyle("-fx-font-size: 30 px");
        Label resultCheck = new Label();

        TextField xText = new TextField();
        xText.setMinHeight(25);
        TextField yText = new TextField();
        yText.setMinHeight(25);
        TextField kText = new TextField();
        kText.setMinHeight(25);
        TextField idMulText = new TextField();
        idMulText.setMinHeight(25);

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



        Alert alertidMul = new Alert(Alert.AlertType.INFORMATION);

        ////////////////////////////
        mul.setOnAction(e->{operation.setText("*");});
        div.setOnAction(e->{operation.setText("/");});
        /////////////////////////////////

        test.setOnAction(e->{
            int x = Integer.parseInt(xText.getText());
            int y = Integer.parseInt(yText.getText());
            int id = Integer.parseInt(idMulText.getText());

            Vector_Category.Vector<Integer> v = new Vector<>();
            v.add(x);
            v.add(y);
            if (operation.getText().equals("*")) {
                if ((boolean) Vector.IdMul(v, id)) {
                    alertidMul.setTitle("Prove Identity");
                    alertidMul.setHeaderText("Identity Checked:");
                    String s = "CORRECT insertion";
                    alertidMul.setContentText(s);
                    alertidMul.show();
                } else {
                    alertidMul.setTitle("Prove Identity");
                    alertidMul.setHeaderText("Identity Checked:");
                    String s = "WRONG insertion";
                    alertidMul.setContentText(s);
                    alertidMul.show();


                }}else{
                    if ((boolean) Vector.IdDiv(v, id)) {
                        alertidMul.setTitle("Prove Identity");
                        alertidMul.setHeaderText("Identity Checked:");
                        String s = "CORRECT insertion";
                        alertidMul.setContentText(s);
                        alertidMul.show();
                    } else {
                        alertidMul.setTitle("Prove Identity");
                        alertidMul.setHeaderText("Identity Checked:");
                        String s = "WRONG insertion";
                        alertidMul.setContentText(s);
                        alertidMul.show();

                    }


                }
            });





        result.setOnAction(e-> {
            int x = Integer.parseInt(xText.getText());
            int y = Integer.parseInt(yText.getText());
            int k = Integer.parseInt(kText.getText());

            Vector_Category.Vector<Integer> v = new Vector<>();
            v.add(x);
            v.add(y);
            if (operation.getText().equals("*")){
                resultCheck.setText("" + v.scalarMul(k));
                resultCheck.setStyle("-fx-font-size: 22 px");}
            else{
                resultCheck.setText(v.scalarDiv(k).toString());
                resultCheck.setStyle("-fx-font-size: 22 px");
            }
        });




        vHBox.getChildren().addAll(vLabel, xLabel, xText, yLabel, yText);
        operationHBox.getChildren().addAll(operationLabel, operation);
        scalarHBox.getChildren().addAll(scalarLabel, kLabel, kText);
        identityHBox.getChildren().addAll(mulIdLabel, idMulText);
        resultHBox.getChildren().addAll(resultLabel, resultCheck);
        endHBox.getChildren().addAll(test, nul, result, empty, create);
        operation.getItems().addAll(mul, div);
        muldivVBox.getChildren().addAll(vHBox, operationHBox, scalarHBox, identityHBox,resultHBox, endHBox);




        muldivVec.show();





    }
}
