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



public class New_Ring extends Application{
    public void start(Stage ring) {

        ring.setTitle("Ring Category");
        ring.setWidth(700);
        ring.setHeight(500);

        VBox ringVBox = new VBox();
        Scene ringScene = new Scene(ringVBox);

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

        TextField idAddTxt = new TextField("Type the IdAdd...");
        idAddTxt.setMinHeight(30);
        TextField idMulTxt = new TextField("Type the IdMul...");
        idMulTxt.setMinHeight(30);


        MenuButton type = new MenuButton("Choose the type");
        type.setStyle("-fx-font-size: 22 px");
        MenuButton Add = new MenuButton("Choose the addFunction");
        Add.setStyle("-fx-font-size: 22 px");
        MenuButton Mul = new MenuButton("Choose the mulFunction");
        Mul.setStyle("-fx-font-size: 22 px");

        Button test = new Button("Test");
        test.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("           ");
        Button create = new Button("Create");
        create.setStyle("-fx-font-size: 22 px");

        MenuItem Int = new MenuItem("Integer");
        MenuItem St = new MenuItem("String");
        MenuItem Boo = new MenuItem("Boolean");

        MenuItem add = new MenuItem("+");
        MenuItem sub = new MenuItem("-");
        MenuItem mul = new MenuItem("*");
        MenuItem div = new MenuItem("/");

        //////////////////////

        Int.setOnAction(e->{
            Add.getItems().clear();
            Add.getItems().addAll(add, sub);
            type.setText("Integer");
            Mul.getItems().clear();
            Mul.getItems().addAll(mul, div);
            Add.setText("Choose the addFunction");
            Mul.setText("Choose the mulFunction");
        });


        Boo.setOnAction(e->{
            type.setText("Boolean");
            Add.setText("No Options Available");
            Mul.setText("No Options Available");
            Add.getItems().clear();
            Mul.getItems().clear();
        });

        ////////////////////////

        add.setOnAction(e->{Add.setText("+");});
        sub.setOnAction(e->{Add.setText("-");});
        mul.setOnAction(e->{Mul.setText("*");});
        div.setOnAction(e->{Mul.setText("/");});

        //////////////////////

        typeHBox.getChildren().addAll(typeText, type);
        addHBox.getChildren().addAll(addText, sourceAdd, Add, endAdd);
        mulHBox.getChildren().addAll(mulText, sourceMul, Mul, endMul);
        idAddHBox.getChildren().addAll(idAddText, idAddTxt);
        idMulHBox.getChildren().addAll(idMulText, idMulTxt);
        endHBox.getChildren().addAll(test, empty, create);
        type.getItems().addAll(Int, St, Boo);

        Mul.getItems().addAll(mul, div);
        ringVBox.getChildren().addAll(typeHBox, addHBox, mulHBox, idAddHBox, idMulHBox, invHBox, endHBox);
        ring.show();


    }
}
