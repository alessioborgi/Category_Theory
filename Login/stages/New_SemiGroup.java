package Login.stages;


import Integer_Category.IntegerCategory;
import Login.JavaFX;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;



public class New_SemiGroup extends Application {
    public void start(Stage semigroup) {

        semigroup.setWidth(700);
        semigroup.setHeight(500);
        semigroup.setTitle("Semigroup Category");

        VBox semigroupVBox = new VBox();
        semigroupVBox.getStyleClass().add("background");
        Scene semigroupScene = new Scene(semigroupVBox);
        semigroupScene.getStylesheets().add("Login/Styles.css");


        semigroup.setScene(semigroupScene);

        //////////////////////////////////

        HBox typeHBoxSG = new HBox();
        typeHBoxSG.setMinHeight(150);
        typeHBoxSG.setMinWidth(700);
        typeHBoxSG.setAlignment(Pos.CENTER_LEFT);
        HBox morphHBoxSG = new HBox();
        morphHBoxSG.setMinHeight(150);
        morphHBoxSG.setMinWidth(700);
        morphHBoxSG.setAlignment(Pos.CENTER_LEFT);
        HBox endHBoxSG = new HBox();
        endHBoxSG.setMinHeight(150);
        endHBoxSG.setMinWidth(700);
        endHBoxSG.setAlignment(Pos.CENTER);


        Label typeTextSG = new Label("    Type:   ");
        typeTextSG.setStyle("-fx-font-size: 30 px");
        Label morphTextSG = new Label("    Function:  ");
        morphTextSG.setStyle("-fx-font-size: 30 px");
        Label sourceTextSG = new Label("Source  A   ");
        sourceTextSG.setStyle("-fx-font-size: 22 px");
        Label endMorphSG = new Label("   Target B");
        endMorphSG.setStyle("-fx-font-size: 22 px");


        MenuButton typeSG = new MenuButton("Choose the type");
        typeSG.getStyleClass().add("menu-create");
        typeSG.setStyle("-fx-font-size: 22 px");
        typeSG.setFont(new Font("Book Antiqua", 30));

        MenuButton morphSG = new MenuButton("Choose the function");
        morphSG.getStyleClass().add("menu-create");
        morphSG.setStyle("-fx-font-size: 22 px");

        MenuItem integer = new MenuItem("Integer");
        morphSG.getStyleClass().add("menu-create");
        MenuItem bool = new MenuItem("Boolean");
        morphSG.getStyleClass().add("menu-create");
        typeSG.getItems().addAll(bool, integer);


        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
        create.setStyle("-fx-font-size: 22 px");


        ////////////

        ComboBox comboBox = new ComboBox();
        comboBox.setPrefHeight(30);
        comboBox.setMinWidth(30);
        comboBox.getStyleClass().add("menu-create");

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "+",
                        "-",
                        "*",
                        "/",
                        "^"

                );

        ObservableList<String> selezione =
                FXCollections.observableArrayList(
                        "∧ (and)",
                        "V (or)",
                        "⊕ (xor)"

                );


        /////////


        integer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboBox.getItems().clear();
                comboBox.getItems().addAll(options);
                typeSG.setText("Integer");
            }
        });

        bool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboBox.getItems().clear();
                comboBox.getItems().addAll(selezione);
                typeSG.setText("Boolean");
            }
        });

        ///////////


        create.setOnAction(e -> {
            Circle circle = new Circle();
            circle.setRadius(250);
            circle.setStroke(Color.BLACK);
            circle.setFill(JavaFX.background);
            circle.setCenterX(400.0f);
            circle.setCenterY(300.0f);

            Label name = new Label("NEW SEMIGROUP");
            name.setStyle("-fx-font-size: 25 px");
            name.setTranslateX(250.0f);
            name.setTranslateY(150.0f);

            TextField a = new TextField();
            a.setPromptText("a...");
            a.setMinHeight(30);
            a.setTranslateX(175.0f);
            a.setTranslateY(300.0f);

            TextField b = new TextField();
            b.setPromptText("b...");
            b.setMinHeight(30);
            b.setTranslateX(475.0f);
            b.setTranslateY(300.0f);


            Label leftArrow = new Label("-->");
            leftArrow.setStyle("-fx-font-size: 22 px");
            leftArrow.setTranslateY(300.0f);
            leftArrow.setTranslateX(325.0f);

            Label rightArrow = new Label("<--");
            rightArrow.setStyle("-fx-font-size: 22 px");
            rightArrow.setTranslateX(440.0f);
            rightArrow.setTranslateY(300.0f);

            Label result = new Label();
            result.setTranslateY(300.0f);
            result.setTranslateX(385.0f);
            result.setStyle("-fx-font-size: 22 px");


            Button func = new Button("f");
            func.setStyle("-fx-font-size: 25 px");
            func.setTranslateX(380.0f);
            func.setTranslateY(375.0f);
            func.getStyleClass().add("button-create");


            String x = "Type: " + typeSG.getText() + "\n" +
                    "Operation: " + comboBox.getValue() ;
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
                alertInfo.setHeaderText("Semigroup Features");
                String s = "Type: " + typeSG.getText() + "\n" +
                        "Operation: " + comboBox.getValue() ;
                alertInfo.setContentText(s);
                alertInfo.show();
            });


            func.setOnAction(g -> {

                IntegerCategory.newSemigroup k = new IntegerCategory.newSemigroup((String) comboBox.getValue());
                int aInt = Integer.parseInt(a.getText());
                int bInt = Integer.parseInt(b.getText());

                int i = k.apply(aInt, bInt);

                result.setText(String.valueOf(i));


            });


            JavaFX.draw.getChildren().clear();
            JavaFX.draw.getChildren().addAll(circle, name, a, leftArrow, b, rightArrow, func, result, info);


        });


        typeHBoxSG.getChildren().addAll(typeTextSG, typeSG);
        morphHBoxSG.getChildren().addAll(morphTextSG, sourceTextSG, comboBox, endMorphSG);
        endHBoxSG.getChildren().addAll(create);
        semigroupVBox.getChildren().addAll(typeHBoxSG, morphHBoxSG, endHBoxSG);
        semigroup.show();


    }

}
