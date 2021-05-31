package Login.stages;
import Integer_Category.BooleanCategory;
import Integer_Category.IntegerCategory;
import Login.JavaFX;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.*;

/**
 * This class works with the Group Category, it is the graphical interface of the class "IntegerCategory.java", in
 * particular the nested class newGroup, which implements the interface "Group".
 * This code opens a window from the button "New Group" in the Create menu from the main page.
 * In this window, the user can find, first of all, a menuButton where the user can decide the type of the elements used
 * to represent this category (Integer or Boolean), and basing on this choice all the next menu will be set with
 * different items.
 * Then the user has to decide the operation that will be applied between the items.
 * After that the user has to define the identity and the inverse linked to the type and the operation chosen.
 * Last but not least, in the last HBox there are two buttons: one to test both the identity and the inverse chosen,
 * "Test"; and "Create" which automatically works as "Test" and then, in the main page, draws a circle, representing 
 * the object, in which the user can find all the detailed info about this specific Group, and can add two specific 
 * elements to which will be applied the operation defined, using the button "f".
 */

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
        typeHBox.setPrefHeight(75);
        typeHBox.setMinWidth(700);
        typeHBox.setAlignment(Pos.CENTER_LEFT);
        HBox morphHBox = new HBox();
        morphHBox.setPrefHeight(75);
        morphHBox.setMinWidth(700);
        morphHBox.setAlignment(Pos.CENTER_LEFT);
        HBox identityHBox = new HBox();
        identityHBox.setPrefHeight(75);
        identityHBox.setMinWidth(700);
        identityHBox.setAlignment(Pos.CENTER_LEFT);
        HBox inverseHBox = new HBox();
        inverseHBox.setPrefHeight(75);
        inverseHBox.setMinWidth(700);
        inverseHBox.setAlignment(Pos.CENTER_LEFT);
        HBox endHBox = new HBox();
        endHBox.setPrefHeight(37);
        endHBox.setMinWidth(700);
        endHBox.setAlignment(Pos.BASELINE_CENTER);
        HBox checkTest = new HBox();
        checkTest.setPrefHeight(37);
        checkTest.setMinWidth(700);
        checkTest.setAlignment(Pos.CENTER);

        Label typeText = new Label("    Type:   ");
        typeText.setStyle("-fx-font-size: 30 px");
        Label morphText = new Label("    Morphism:  ");
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

        MenuItem integer = new MenuItem("Integer");
        integer.getStyleClass().add("menu-create");

        MenuItem bool = new MenuItem("Boolean");
        bool.getStyleClass().add("menu-create");
        type.getItems().addAll(bool, integer);

        Button test = new Button("Test");
        test.getStyleClass().add("button-create");
        test.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("           ");
        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
        create.setStyle("-fx-font-size: 22 px");

        ComboBox comboBox = new ComboBox();
        comboBox.setPrefHeight(30);
        comboBox.setMinWidth(30);
        comboBox.getStyleClass().add("menu-create");

        ComboBox comboBoxInv = new ComboBox();
        comboBoxInv.setPrefHeight(30);
        comboBoxInv.setMinWidth(30);
        comboBoxInv.getStyleClass().add("menu-create");

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

        ObservableList<String> inv  =
                FXCollections.observableArrayList(
                        "-a",
                        "+a",
                        "0",
                        "1"

                );

        integer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboBox.getItems().clear();
                comboBox.getItems().addAll(options);
                type.setText("Integer");
            }
        });

        bool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comboBox.getItems().clear();
                comboBox.getItems().addAll(selezione);
                type.setText("Boolean");
            }
        });

        test.setOnAction(e->{
            if (type.getText().equals("Integer")){
                int id = Integer.parseInt(idText.getText());
                IntegerCategory.newGroup testgroup = new IntegerCategory.newGroup(id, (String)comboBox.getValue(), (String) comboBoxInv.getValue());
                String tstring = testgroup.test();
                if (testgroup.isAbelian()){fine.setText(tstring + " - Abelian Group");}
                else{fine.setText(tstring);}
                fine.setStyle("-fx-font-size: 22 px");

            }
            if (type.getText().equals("Boolean")){
                fine.setStyle("-fx-font-size: 22 px");
                String ide = idText.getText();
                boolean identity = false;
                boolean flag = false;
                if (ide.equals("1") || ide.equals("true") || ide.equals("True")){
                    identity = true;
                    flag = true;
                    idText.setText("true");
                }
                else if (ide.equals("0") || ide.equals("false") || ide.equals("False")){
                    identity = false;
                    flag = true;
                    idText.setText("false");
                }
                else { fine.setText("Please insert a boolean value"); }
                if (flag){
                    ArrayList tg = new Integer_Category.BooleanCategory.newGroup(identity, (String) comboBox.getValue(),(String) comboBoxInv.getValue()).test();
                    if ((boolean) tg.get(0)) {
                        fine.setText("TEST PASSED!");
                    }
                    else { fine.setText("" + tg.get(1)); }
                }
            }
        });

        create.setOnAction(e->{
            test.fire();

            if(fine.getText().equals("TEST PASSED!") ||
                    (fine.getText().equals("TEST PASSED! - Abelian Group"))) {
                Circle circle = new Circle();
                circle.setRadius(250);
                circle.setStroke(Color.BLACK);
                circle.setFill(JavaFX.background);
                circle.setCenterX(400.0f);
                circle.setCenterY(300.0f);

                Label name = new Label("NEW GROUP");
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


                String x = "Type: "+ type.getText() +"\n" +
                        "Operation: " + comboBox.getValue() +"\n"+
                        "Identity: " + idText.getText() +"\n"+
                        "Inverse: " + comboBoxInv.getValue()
                        ;
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

                info.setOnAction(f->{
                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.setTitle("Info");
                    alertInfo.setHeaderText("Group Features");
                    String s = "Type: "+ type.getText() +"\n" +
                            "Operation: " + comboBox.getValue() +"\n"+
                            "Identity: " + idText.getText() +"\n"+
                            "Inverse: " + comboBoxInv.getValue()
                            ;
                    alertInfo.setContentText(s);
                    alertInfo.show();
                });
                if (type.getText().equals("Integer")) {
                    IntegerCategory.newGroup intGroup= new IntegerCategory.newGroup(Integer.parseInt(idText.getText()), (String) comboBox.getValue(),(String) comboBoxInv.getValue());
                    func.setOnAction(g -> {
                        result.setText(String.valueOf(intGroup.apply(Integer.parseInt(a.getText()), Integer.parseInt(b.getText()))));
                    });
                }
                if(type.getText().equals("Boolean")){
                    BooleanCategory.newGroup BoolGroup = new BooleanCategory.newGroup(Boolean.parseBoolean(idText.getText()),(String) comboBox.getValue(),(String) comboBoxInv.getValue());
                    func.setOnAction(g -> {
                        String alfa = a.getText();
                        String beta = b.getText();
                        if(alfa.equals("1")){alfa = "True";}
                        else if(alfa.equals("0")){alfa = "False";}
                        if(beta.equals("1")){beta = "True";}
                        else if(beta.equals("0")){beta = "False";}
                        result.setText(String.valueOf(BoolGroup.apply(Boolean.parseBoolean(alfa), Boolean.parseBoolean(beta))));
                        if (!((beta.equalsIgnoreCase("True") || beta.equalsIgnoreCase("False")) && (alfa.equalsIgnoreCase("True") || alfa.equalsIgnoreCase("False")))){
                            result.setText("!!");
                        }
                    });
                }
                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(circle, name, a, leftArrow, b, rightArrow, func, result, info);
            }});

        comboBoxInv.getItems().addAll(inv);
        typeHBox.getChildren().addAll(typeText, type);
        morphHBox.getChildren().addAll(morphText, sourceText,comboBox , endMorph);
        identityHBox.getChildren().addAll(identityText, idText);
        inverseHBox.getChildren().addAll(inverseText, comboBoxInv);
        endHBox.getChildren().addAll(test, empty, create);
        checkTest.getChildren().addAll(fine);
        groupVBox.getChildren().addAll(typeHBox, morphHBox, identityHBox, inverseHBox, endHBox, checkTest);
        group.show();
    }
}
