package Login.stages;


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
        Label endMorphSG = new Label ("   Target B");
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
        MenuItem string = new MenuItem("String");
        morphSG.getStyleClass().add("menu-create");
        MenuItem bool = new MenuItem("Boolean");
        morphSG.getStyleClass().add("menu-create");
        typeSG.getItems().addAll(bool, integer, string);

        
        
        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
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
                morphSG.getItems().clear();
                morphSG.getItems().addAll(add, sub, mul, div, per, pow);
                typeSG.setText("Integer");
            }
        });

        bool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                morphSG.getItems().clear();
                morphSG.getItems().addAll(and, or, xor, nand, nor, xnor);
                typeSG.setText("Boolean");
            }
        });

        ///////////

        add.setOnAction(e->{
            morphSG.setText("+");
        });

        sub.setOnAction(e->{
            morphSG.setText("-");
        });

        mul.setOnAction(e->{
            morphSG.setText("*");
        });

        div.setOnAction(e->{
            morphSG.setText("/");
        });

        per.setOnAction(e->{
            morphSG.setText("%");
        });

        pow.setOnAction(e->{
            morphSG.setText("^");
        });

        //////////////

        and.setOnAction(e-> {morphSG.setText("∧"); });

        or.setOnAction(e->{ morphSG.setText("V"); });

        xor.setOnAction(e->{morphSG.setText("⊕");});

        nand.setOnAction(e->{morphSG.setText("¬∧");});

        nor.setOnAction(e->{morphSG.setText("¬V");});

        xnor.setOnAction(e->{morphSG.setText("¬⊕");});


        typeHBoxSG.getChildren().addAll(typeTextSG, typeSG);
        morphHBoxSG.getChildren().addAll(morphTextSG, sourceTextSG, morphSG, endMorphSG);

        endHBoxSG.getChildren().addAll(create);

        semigroupVBox.getChildren().addAll(typeHBoxSG, morphHBoxSG, endHBoxSG);
        semigroup.show();






    }
}
