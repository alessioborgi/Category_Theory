package Login.stages;
import Login.JavaFX;
import Vector_Category.Vectors;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author elenamuia
 * @author alessioborgi
 * @author federicavaleau
 * @author francescodanese
 * @created 24 / 05 / 2021 - 15:52
 * @project CATEGORY_THEORY
 */


/**
 * This class implements the JavaFx libraries in order to create the graphic interface of the class Vector
 * (with Add_Sub_Vec.java). In this class the user finds a window in which he/she can perform various actions:
 * In the first line the user has to add the two elements which will compose our vector "v1". Then the user
 * will choose the operation that will be applied to our vectors (in this case * or /).
 * In the third line the user can decide the scalar k which will be multiplied or divided by v1.
 * Then the user will add the identity element which will be applied to the first element, and the button "Test"
 * checks it the identity written is correct.
 * The button "Result" writes the result vector between v1 and k next to the label "Result:"
 * The button "Create" creates the graphical view of the chosen operation using default vectors, the two components
 * are black while the result is red.
 */


public class Mul_Div_Vec extends Application {
    public void start(Stage muldivVec) {

        muldivVec.setTitle("Group Category");
        muldivVec.setWidth(700);
        muldivVec.setHeight(500);

        VBox muldivVBox = new VBox();
        muldivVBox.getStyleClass().add("background");
        Scene muldivScene = new Scene(muldivVBox);
        muldivScene.getStylesheets().add("Login/Styles.css");
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
        Label operationLabel = new Label("     MOrphism:    ");
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
        xText.setPromptText("Vector's Y"); //to set the hint text
        xText.setMinHeight(25);
        TextField yText = new TextField();
        yText.setPromptText("Vector's Y"); //to set the hint text
        yText.setMinHeight(25);
        TextField kText = new TextField();
        kText.setPromptText("Scalar Integer"); //to set the hint text
        kText.setMinHeight(25);
        TextField idMulText = new TextField();
        idMulText.setPromptText("Type Identity"); //to set the hint text
        idMulText.setMinHeight(25);

        MenuButton operation = new MenuButton("Choose the operation");
        operation.getStyleClass().add("menu-create");
        operation.setStyle("-fx-font-size: 22 px");

        MenuItem mul = new MenuItem("*");
        mul.getStyleClass().add("menu-create");
        MenuItem div = new MenuItem("/");
        div.getStyleClass().add("menu-create");

        Button test = new Button("Test");
        test.getStyleClass().add("button-create");
        test.setStyle("-fx-font-size: 22 px");
        Label nul = new Label("     ");
        Button result = new Button("Result");
        result.getStyleClass().add("button-create");
        result.setStyle("-fx-font-size: 22 px");
        Label empty = new Label("    ");
        Button create = new Button("Create");
        create.getStyleClass().add("button-create");
        create.setStyle("-fx-font-size: 22 px");

        Alert alertidMul = new Alert(Alert.AlertType.INFORMATION);

        mul.setOnAction(e->{operation.setText("*");});
        div.setOnAction(e->{operation.setText("/");});

        test.setOnAction(e->{
            int x = Integer.parseInt(xText.getText());
            int y = Integer.parseInt(yText.getText());
            int id = Integer.parseInt(idMulText.getText());

            Vector_Category.Vectors<Integer> v = new Vectors<>();
            v.add(x);
            v.add(y);
            if (operation.getText().equals("*")) {
                if ((boolean) Vectors.IdMul(v, id)) {
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
                if ((boolean) Vectors.IdDiv(v, id)) {
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

            Vector_Category.Vectors<Integer> v = new Vectors<>();
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

        create.setOnAction(e->{

            if(operation.getText().equals("*")){
                Line lineMul = new Line();
                Line lineMul2 = new Line();

                lineMul.setStartX(300.0);
                lineMul.setStartY(400);
                lineMul.setEndX(400.0);
                lineMul.setEndY(300.0);
                lineMul2.setStartX(400.0);
                lineMul2.setStartY(300.0);
                lineMul2.setEndX(600.0);
                lineMul2.setEndY(100.0);
                lineMul2.setStroke(Color.RED);

                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(lineMul, lineMul2);
            }
            else{
                Line lineDiv = new Line();
                Line lineDiv2 = new Line();

                lineDiv.setStartX(300.0);
                lineDiv.setStartY(400);
                lineDiv.setEndX(400.0);
                lineDiv.setEndY(300.0);
                lineDiv2.setStartX(400.0);
                lineDiv2.setStartY(300.0);
                lineDiv2.setEndX(600.0);
                lineDiv2.setEndY(100.0);
                lineDiv.setStroke(Color.RED);

                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(lineDiv, lineDiv2);
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
