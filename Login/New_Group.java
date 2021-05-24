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



public class New_Group extends Application {
    public void start(Stage group) {
        group.setTitle("Group Category");
        group.setWidth(700);
        group.setHeight(500);

        VBox groupVBox = new VBox();

        Scene groupScene = new Scene(groupVBox);

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

        TextField idText = new TextField("Type the identity...");
        idText.setMinHeight(30);



        MenuButton type = new MenuButton("Choose the type");
        type.setStyle("-fx-font-size: 22 px");


        MenuButton morph = new MenuButton("Choose the function");
        morph.setStyle("-fx-font-size: 22 px");

        MenuButton inv = new MenuButton("Choose the inverse");
        type.setStyle("-fx-font-size: 22 px");


        MenuItem integer = new MenuItem("Integer");
        MenuItem string = new MenuItem("String");
        MenuItem bool = new MenuItem("Boolean");
        type.getItems().addAll(bool, integer, string);

        Button test = new Button("Test");
        test.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("           ");
        Button create = new Button("Create");
        create.setStyle("-fx-font-size: 22 px");

        ////////////

        MenuItem add = new MenuItem("+");
        MenuItem sub = new MenuItem("-");
        MenuItem mul = new MenuItem("*");
        MenuItem div = new MenuItem("/");
        MenuItem per = new MenuItem("%");
        MenuItem pow = new MenuItem("^");




        /////////

        MenuItem and = new MenuItem("∧");
        MenuItem or = new MenuItem("V");
        MenuItem xor = new MenuItem("⊕");
        MenuItem nand = new MenuItem("¬∧");
        MenuItem nor = new MenuItem("¬V");
        MenuItem xnor = new MenuItem("¬⊕");

        integer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                morph.getItems().clear();
                morph.getItems().addAll(add, sub, mul, div, per, pow);
                type.setText("Integer");
            }
        });

        bool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                morph.getItems().clear();
                morph.getItems().addAll(and, or, xor, nand, nor, xnor);
                type.setText("Boolean");
            }
        });

        ///////////

        add.setOnAction(e->{
            morph.setText("+");
        });

        sub.setOnAction(e->{
            morph.setText("-");
        });

        mul.setOnAction(e->{
            morph.setText("*");
        });

        div.setOnAction(e->{
            morph.setText("/");
        });

        per.setOnAction(e->{
            morph.setText("%");
        });

        pow.setOnAction(e->{
            morph.setText("^");
        });

        //////////////

        and.setOnAction(e-> {morph.setText("∧"); });

        or.setOnAction(e->{ morph.setText("V"); });

        xor.setOnAction(e->{morph.setText("⊕");});

        nand.setOnAction(e->{morph.setText("¬∧");});

        nor.setOnAction(e->{morph.setText("¬V");});

        xnor.setOnAction(e->{morph.setText("¬⊕");});



        typeHBox.getChildren().addAll(typeText, type);
        morphHBox.getChildren().addAll(morphText, sourceText, morph, endMorph);
        identityHBox.getChildren().addAll(identityText, idText);
        inverseHBox.getChildren().addAll(inverseText, inv);
        endHBox.getChildren().addAll(test, empty, create);
        groupVBox.getChildren().addAll(typeHBox, morphHBox, identityHBox, inverseHBox, endHBox);
        group.show();

    }
}
