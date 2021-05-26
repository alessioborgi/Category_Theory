package Login.stages;




import Integer_Category.IntegerCategory;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;



public class New_Group extends Application {
    public void start(Stage group) {
        group.setTitle("Group Category");
        group.setWidth(700);
        group.setHeight(500);

        VBox groupVBox = new VBox();
        groupVBox.getStyleClass().add("background");
        Scene groupScene = new Scene(groupVBox);
        groupScene.getStylesheets().add("Login/Styles.css");
        group.setScene(groupScene);


        HBox typeHBox = new HBox();
        typeHBox.setMinHeight(75);
        typeHBox.setMinWidth(700);
        typeHBox.setAlignment(Pos.CENTER_LEFT);
        HBox morphHBox = new HBox();
        morphHBox.setMinHeight(75);
        morphHBox.setMinWidth(700);
        morphHBox.setAlignment(Pos.CENTER_LEFT);
        HBox identityHBox = new HBox();
        identityHBox.setMinHeight(75);
        identityHBox.setMinWidth(700);
        identityHBox.setAlignment(Pos.CENTER_LEFT);
        HBox inverseHBox = new HBox();
        inverseHBox.setMinHeight(75);
        inverseHBox.setMinWidth(700);
        inverseHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setMinHeight(75);
        endHBox.setMinWidth(700);
        endHBox.setAlignment(Pos.CENTER);

        Label typeText = new Label("    Type:   ");
        typeText.setStyle("-fx-font-size: 30 px");
        Label morphText = new Label("    Function:  ");
        morphText.setStyle("-fx-font-size: 30 px");
        Label identityText = new Label("    Identity:   ");
        Label sourceText = new Label("Source  A   ");
        sourceText.setStyle("-fx-font-size: 22 px");
        Label endMorph = new Label ("   Source B");
        endMorph.setStyle("-fx-font-size: 22 px");
        identityText.setStyle("-fx-font-size: 30 px");
        Label inverseText = new Label("    Inverse:    ");
        inverseText.setStyle("-fx-font-size: 30 px");

        TextField idText = new TextField();
        idText.setMinHeight(30);
        idText.setPromptText("Type Identity");
        Label fine = new Label();



        MenuButton type = new MenuButton("Choose the type");
        type.getStyleClass().add("menu-create");
        type.setStyle("-fx-font-size: 22 px");


        MenuButton inv = new MenuButton("Choose the inverse");
        inv.getStyleClass().add("menu-create");
        type.setStyle("-fx-font-size: 22 px");


        MenuItem integer = new MenuItem("Integer");
        integer.getStyleClass().add("menu-create");
        MenuItem string = new MenuItem("String");
        string.getStyleClass().add("menu-create");
        MenuItem bool = new MenuItem("Boolean");
        bool.getStyleClass().add("menu-create");
        type.getItems().addAll(bool, integer, string);

        Button test = new Button("Test");
        test.getStyleClass().add("button-create");
        test.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("           ");
        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
        create.setStyle("-fx-font-size: 22 px");

        ////////////



        ComboBox comboBox = new ComboBox();
        comboBox.setPrefHeight(30);
        comboBox.setMinWidth(30);
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "+",
                        "-",
                        "*",
                        "/",
                        "%",
                        "^"
                );





        /////////

        ObservableList<String> selezione =
                FXCollections.observableArrayList(
                        "∧",
                        "V",
                        "⊕",
                        "¬∧",
                        "¬V",
                        "¬⊕"
                );

        integer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboBox.getItems().addAll(options);
                type.setText("Integer");
            }
        });

        bool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboBox.getItems().addAll(selezione);
                type.setText("Boolean");
            }
        });



        test.setOnAction(e->{
            if (type.getText().equals("Integer")){
                int id = Integer.parseInt(idText.getText());
                if (new IntegerCategory.newMonoid(id, (String)comboBox.getValue()).test()){
                    fine.setText("     TEST PASSED!");
                    fine.setStyle("-fx-font-size: 22 px");
                }
                else{
                    fine.setText("      ERROR!");
                    fine.setStyle("-fx-font-size: 22 px");
                }

            }

        });



        typeHBox.getChildren().addAll(typeText, type);
        morphHBox.getChildren().addAll(morphText, sourceText,comboBox , endMorph);
        identityHBox.getChildren().addAll(identityText, idText, fine);
        inverseHBox.getChildren().addAll(inverseText, inv);
        endHBox.getChildren().addAll(test, empty, create);
        groupVBox.getChildren().addAll(typeHBox, morphHBox, identityHBox, inverseHBox, endHBox);
        group.show();

    }
}
