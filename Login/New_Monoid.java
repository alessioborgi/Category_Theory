package Login;

import Set_Category.SetCat;
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


public class New_Monoid extends Application {
    public void start(Stage monoid) {

        monoid.setWidth(700);
        monoid.setHeight(500);
        monoid.setTitle("Monoid Category");


        VBox monoidVBox = new VBox();

        Scene monoidScene = new Scene(monoidVBox);

        monoid.setScene(monoidScene);


        HBox typeHBox = new HBox();
        typeHBox.setMinHeight(100);
        typeHBox.setMinWidth(700);
        typeHBox.setAlignment(Pos.CENTER_LEFT);
        HBox morphHBox = new HBox();
        morphHBox.setMinHeight(100);
        morphHBox.setMinWidth(700);
        morphHBox.setAlignment(Pos.CENTER_LEFT);
        HBox identityHBox = new HBox();
        identityHBox.setMinHeight(100);
        identityHBox.setMinWidth(700);
        identityHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setMinHeight(100);
        endHBox.setMinWidth(700);
        endHBox.setAlignment(Pos.CENTER);



        Label typeText = new Label("    Type:   ");
        typeText.setStyle("-fx-font-size: 30 px");
        Label morphText = new Label("    Function:  ");
        morphText.setStyle("-fx-font-size: 30 px");
        Label sourceText = new Label("  Source A   ");
        sourceText.setStyle("-fx-font-size: 22 px");
        Label endMorph = new Label ("   Source B");
        endMorph.setStyle("-fx-font-size: 22 px");
        Label identityText = new Label("    Identity:   ");
        identityText.setStyle("-fx-font-size: 30 px");

        TextField inputText = new TextField("Type the identity...");
        inputText.setMinHeight(30);

        MenuButton type = new MenuButton("Choose the type");
        type.setStyle("-fx-font-size: 22 px");
        type.setFont(new Font("Book Antiqua", 30));

        MenuButton morph = new MenuButton("Choose the function");
        morph.setStyle("-fx-font-size: 22 px");



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
        identityHBox.getChildren().addAll(identityText, inputText);
        endHBox.getChildren().addAll(test, empty, create);

        monoidVBox.getChildren().addAll(typeHBox, morphHBox, identityHBox, endHBox);
        monoid.show();
    }
    }
