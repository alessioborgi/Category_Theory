package Login.stages;

import Integer_Category.IntegerCategory;
import Login.JavaFX;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;



public class New_Ring extends Application{
    public void start(Stage ring) {

        ring.setTitle("Ring Category");
        ring.setWidth(700);
        ring.setHeight(600);

        VBox ringVBox = new VBox();
        ringVBox.getStyleClass().add("background");
        Scene ringScene = new Scene(ringVBox);
        ringScene.getStylesheets().add("Login/Styles.css");
        ring.setScene(ringScene);

        HBox typeHBox = new HBox();
        typeHBox.setMinHeight(70);
        typeHBox.setMinWidth(700);
        typeHBox.setAlignment(Pos.CENTER_LEFT);
        HBox addHBox = new HBox();
        addHBox.setMinHeight(70);
        addHBox.setMinWidth(700);
        addHBox.setAlignment(Pos.CENTER_LEFT);
        HBox mulHBox = new HBox();
        mulHBox.setMinHeight(70);
        mulHBox.setMinWidth(700);
        mulHBox.setAlignment(Pos.CENTER_LEFT);
        HBox idAddHBox = new HBox();
        idAddHBox.setMinHeight(70);
        idAddHBox.setMinWidth(700);
        idAddHBox.setAlignment(Pos.CENTER_LEFT);
        HBox idMulHBox = new HBox();
        idMulHBox.setMinHeight(70);
        idMulHBox.setMinWidth(700);
        idMulHBox.setAlignment(Pos.CENTER_LEFT);
        HBox invHBox = new HBox();
        invHBox.setMinHeight(50);
        invHBox.setMinWidth(700);
        invHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setMaxHeight(30);
        endHBox.setMinWidth(700);
        endHBox.setAlignment(Pos.BASELINE_CENTER);
        HBox testBox = new HBox();
        testBox.setAlignment(Pos.BASELINE_CENTER);
        testBox.setMinHeight(70);
        testBox.setMinWidth(700);

        Label typeText = new Label("    Type:   ");
        typeText.setStyle("-fx-font-size: 30 px");
        Label addText = new Label("    Add:     ");
        addText.setStyle("-fx-font-size: 30 px");
        Label sourceAdd = new Label("Source  A   ");
        sourceAdd.setStyle("-fx-font-size: 22 px");
        Label endAdd = new Label ("   Source B");
        endAdd.setStyle("-fx-font-size: 22 px");
        Label mulText = new Label("    Mul:     ");
        mulText.setStyle("-fx-font-size: 30 px");
        Label sourceMul = new Label("Source  A   ");
        sourceMul.setStyle("-fx-font-size: 22 px");
        Label endMul = new Label ("   Source B");
        endMul.setStyle("-fx-font-size: 22 px");
        Label idAddText = new Label("    IdAdd:   ");
        idAddText.setStyle("-fx-font-size: 30 px");
        Label idMulText = new Label("    IdMul:   ");
        idMulText.setStyle("-fx-font-size: 30 px");
        Label inverseLabel = new Label("    Inverse:    ");
        inverseLabel.setStyle("-fx-font-size: 30 px");


        TextField idAddTxt = new TextField();
        idAddTxt.setMinHeight(30);
        idAddTxt.setPromptText("Type the Add's ID"); //to set the hint text
        TextField idMulTxt = new TextField();
        idMulTxt.setMinHeight(30);
        idMulTxt.setPromptText("Type the Mul's ID"); //to set the hint text


        MenuButton type = new MenuButton("Choose the type");
        type.getStyleClass().add("menu-create");
        type.setStyle("-fx-font-size: 22 px");

        Label result = new Label("");
        Button test = new Button("Test");
        test.getStyleClass().add("button-create");
        test.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("           ");
        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
        create.setStyle("-fx-font-size: 22 px");

        MenuItem Int = new MenuItem("Integer");
        Int.getStyleClass().add("menu-create");
        MenuItem Boo = new MenuItem("Boolean");
        Boo.getStyleClass().add("menu-create");

        ComboBox comboBoxMul = new ComboBox();
        comboBoxMul.setPrefHeight(30);
        comboBoxMul.setMinWidth(30);
        comboBoxMul.getStyleClass().add("menu-create");



        ComboBox comboBoxAdd = new ComboBox();
        comboBoxAdd.setPrefHeight(30);
        comboBoxAdd.setMinWidth(30);
        comboBoxAdd.getStyleClass().add("menu-create");
        ObservableList<String> optionsAdd =
                FXCollections.observableArrayList(
                        "+",
                        "-"
                );


        ObservableList<String> optionsMul =
                FXCollections.observableArrayList(
                        "*",
                        "/"
                );


        ObservableList<String> noOPt =
                FXCollections.observableArrayList(
                        "No Options Available"



                );


        ComboBox comboBoxInv = new ComboBox();
        comboBoxInv.setPrefHeight(30);
        comboBoxInv.setMinWidth(30);
        comboBoxInv.getStyleClass().add("menu-create");


        ObservableList<String> inverse =
                FXCollections.observableArrayList(
                        "-a",
                        "+a",
                        "0",
                        "1"

                );



        //////////////////////

        Int.setOnAction(e->{
            comboBoxAdd.getItems().clear();
            comboBoxAdd.getItems().addAll(optionsAdd);
            type.setText("Integer");
            comboBoxMul.getItems().clear();
            comboBoxMul.getItems().addAll(optionsMul);


        });


        Boo.setOnAction(e->{
            type.setText("Boolean");
            comboBoxAdd.getItems().clear();
            comboBoxMul.getItems().clear();
            comboBoxAdd.getItems().addAll(noOPt);
            comboBoxMul.getItems().addAll(noOPt);



        });

        test.setOnAction(e->{
            result.setStyle("-fx-font-size: 22 px");
            if(type.getText().equals("Integer")){
                IntegerCategory.newRing kkk= new IntegerCategory.newRing(Integer.parseInt(idAddTxt.getText()), Integer.parseInt(idMulTxt.getText()), (String)comboBoxAdd.getValue(),(String)comboBoxMul.getValue(),(String)comboBoxInv.getValue());
                if(kkk.test()){
                    System.out.println("Correct");
                    result.setText("TEST PASSED!");
                }
                else {
                    System.out.println("Wrong");
                    result.setText("WRONG!");
                }
            }
        });

        ////////////////////////


        create.setOnAction(e->{
            test.fire();
            if(result.getText().equals("TEST PASSED!")) {
                Circle circle = new Circle();
                circle.setRadius(235);
                circle.setStroke(Color.BLACK);
                circle.setFill(JavaFX.background);
                circle.setCenterX(400.0f);
                circle.setCenterY(300.0f);

                Label name = new Label("NEW RING");
                name.setStyle("-fx-font-size: 25 px");
                name.setTranslateX(250.0f);
                name.setTranslateY(150.0f);

                TextField a = new TextField();
                a.setPromptText("a...");
                a.setMinHeight(30);
                a.setMaxWidth(100);
                a.setTranslateX(200.0f);
                a.setTranslateY(300.0f);

                TextField b = new TextField();
                b.setPromptText("b...");
                b.setMinHeight(30);
                b.setMaxWidth(100);
                b.setTranslateX(475.0f);
                b.setTranslateY(300.0f);


                Label leftArrow = new Label("-->");
                leftArrow.setStyle("-fx-font-size: 22 px");
                leftArrow.setTranslateY(300.0f);
                leftArrow.setTranslateX(300.0f);

                Label rightArrow = new Label("<--");
                rightArrow.setStyle("-fx-font-size: 22 px");
                rightArrow.setTranslateX(440.0f);
                rightArrow.setTranslateY(300.0f);

                Label resultA = new Label();
                resultA.setTranslateY(300.0f);
                resultA.setTranslateX(360.0f);
                resultA.setStyle("-fx-font-size: 25 px");

                Label resultB = new Label();
                resultB.setTranslateY(300.0f);
                resultB.setTranslateX(400.0f);
                resultB.setStyle("-fx-font-size: 25 px");


                Label operation = new Label("+|x");
                operation.setStyle("-fx-font-size: 30 px");
                operation.setTranslateX(360.0f);
                operation.setTranslateY(230.0f);

                Button func = new Button("f");
                func.setStyle("-fx-font-size: 25 px");
                func.setTranslateX(370.0f);
                func.setTranslateY(375.0f);
                func.getStyleClass().add("button-create");

                Label division = new Label("|");
                division.setTranslateY(298.0f);
                division.setTranslateX(381.0f);
                division.setStyle("-fx-font-size: 28 px");


                String x = "Type: " + type.getText() + "\n" +
                        "Operation: " + comboBoxAdd.getValue() + "\n" +
                        "Operation: " + comboBoxMul.getValue() + "\n" +
                        "Id ADD: " + idAddTxt.getText() + "\n" +
                        "Id MUL: " + idMulTxt.getText() + "\n" +
                        "Inverse: " + comboBoxInv.getValue();
                Tooltip t = new Tooltip(x);
                Button info = new Button("i");
                info.setShape(new Circle(1.5));
                info.setTranslateX(500.0f);
                info.setTranslateY(125.0f);
                info.setStyle("-fx-font-size: 30 px");
                info.getStyleClass().add("button-create");
                t.setShowDelay(Duration.millis(0));
                t.setHideDelay(Duration.millis(0));
                info.setTooltip(t);


                info.setOnAction(f -> {
                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.setTitle("Info");
                    alertInfo.setHeaderText("Ring Features");
                    String s = "Type: " + type.getText() + "\n" +
                            "Operation: " + comboBoxAdd.getValue() + "\n" +
                            "Operation: " + comboBoxMul.getValue() + "\n" +
                            "Id ADD: " + idAddTxt.getText() + "\n" +
                            "Id MUL: " + idMulTxt.getText() + "\n" +
                            "Inverse: " + comboBoxInv.getValue();
                    alertInfo.setContentText(s);
                    alertInfo.show();
                });

                func.setOnAction(g -> {

                    int idA = Integer.parseInt(idAddTxt.getText());
                    int idM = Integer.parseInt(idMulTxt.getText());
                    IntegerCategory.newRing k = new IntegerCategory.newRing(idA, idM, (String) comboBoxAdd.getValue(),
                            (String) comboBoxMul.getValue(), (String) comboBoxInv.getValue());
                    int aInt = Integer.parseInt(a.getText());
                    int bInt = Integer.parseInt(b.getText());

                    int i = k.add(aInt, bInt);
                    int j = k.mult(aInt, bInt);

                    resultA.setText(String.valueOf(i));
                    resultB.setText(String.valueOf(j));
                });


                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(circle, name, a, leftArrow, b, rightArrow, func, resultA, info, resultB,
                        operation, division);

            }
        });


        comboBoxInv.getItems().addAll(inverse);

        typeHBox.getChildren().addAll(typeText, type);
        addHBox.getChildren().addAll(addText, sourceAdd, comboBoxAdd, endAdd);
        mulHBox.getChildren().addAll(mulText, sourceMul, comboBoxMul, endMul);
        idAddHBox.getChildren().addAll(idAddText, idAddTxt);
        idMulHBox.getChildren().addAll(idMulText, idMulTxt);
        endHBox.getChildren().addAll(test, empty, create);
        type.getItems().addAll(Int, Boo);
        invHBox.getChildren().addAll(inverseLabel, comboBoxInv);
        testBox.getChildren().addAll(result);
        ringVBox.getChildren().addAll(typeHBox, addHBox, mulHBox, idAddHBox, idMulHBox, invHBox,testBox ,endHBox);
        ring.show();


    }
}
