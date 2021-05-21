package Login;

import javafx.embed.swing.JFXPanel;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;

import java.util.*;


/**
 * @author alessioborgi
 * @created 14 / 05 / 2021 - 18:27
 * @project CATEGORY_THEORY
 */
public class JavaFX {
    private static Group root  =  new  Group();
    //private static StackPane root  =  new StackPane();
    private static Scene  scene  =  new  Scene(root);

    private static MenuBar main_menu = new MenuBar();
    private static Menu Create = new Menu("Create");
    private static Menu Draw = new Menu("Draw");
    private static Menu Cancel = new Menu("Cancel");
    private static Menu Help = new Menu("Help");
    private static Menu New_Object = new Menu("New Object");

    private static Menu New_Category = new Menu("New Category");
    private static MenuItem Exit_now = new MenuItem("Exit");
    private static MenuItem Clear_all = new MenuItem("Clear All");
    private static MenuItem Back_now = new MenuItem("Back");
    private static MenuItem New_Integer_Category = new MenuItem("Integer Category");
    private static MenuItem New_Boolean_Category = new MenuItem("Boolean Category");
    private static MenuItem New_Vector_Category = new MenuItem("Vector Category");
    private static MenuItem New_Set_Category = new MenuItem("Set Category");
    private static MenuItem New_Morphism = new MenuItem("New Morphism");
    private static MenuItem New_Semigroup = new MenuItem("New Semigroup");
    private static MenuItem New_Monoid = new MenuItem("New Monoid");
    private static MenuItem New_Group = new MenuItem("New Group");
    private static MenuItem New_Ring = new MenuItem("New Ring");

    private static MenuItem About = new MenuItem("About");
    private static SeparatorMenuItem separator = new SeparatorMenuItem();

    private static Canvas canvas = new Canvas(800, 620);
    private static GraphicsContext gc = canvas.getGraphicsContext2D();
    private static Button exit = new Button("Exit");
    private static Button clear_all = new Button("Clear");
    private static Button back = new Button("Back");
    private static HBox box = new HBox(clear_all, exit, back);

    public static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);

    }

    public static Scene createScene() {
        Help.getItems().add(About);
        New_Category.getItems().addAll(New_Integer_Category, New_Boolean_Category, New_Set_Category, New_Vector_Category);
        Create.getItems().addAll(New_Object, New_Category, New_Morphism);
        New_Object.getItems().addAll(New_Semigroup, New_Monoid, New_Group, New_Ring);


        main_menu.getMenus().addAll(Create, Draw, Cancel, Help);
        Cancel.getItems().addAll(Clear_all, Back_now, separator, Exit_now);

        scene.setFill(new LinearGradient(0, 0, 1, 1, true,    //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.GOLD),            //colors
                new Stop(1, Color.ORANGE)
        ));

        addActions();
        setter();
        root.getChildren().addAll(canvas, box, main_menu);
        return (scene);
    }

    private static void setter(){
        New_Integer_Category.setAccelerator(KeyCombination.keyCombination("shortcut+I"));
        New_Boolean_Category.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        New_Vector_Category.setAccelerator(KeyCombination.keyCombination("shortcut+V"));
        New_Set_Category.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
        Exit_now.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
        Back_now.setAccelerator(KeyCombination.keyCombination("shortcut+B"));
        Clear_all.setAccelerator(KeyCombination.keyCombination("shortcut+C"));

        box.setSpacing(10);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(570, 0, 0, 340));
    }

    private static void addActions(){
        EventHandler exit_event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Exit");
                alert.setHeaderText("Confirm that you want to Exit :(");
                alert.setContentText("Anyway, Thank you so much for using our Category Theory's Application!");

                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    System.exit(0);
                }
            }
        };

        EventHandler form_event = new EventHandler<ActionEvent>() {
            private final String [] arrayData = {"First", "Second", "Third", "Fourth"};
            private List<String> dialogData;
            GridPane grid = new GridPane();

            @Override
            public void handle(ActionEvent actionEvent) {
                dialogData = Arrays.asList(arrayData);
                Label type = new Label("Type:");

                ChoiceDialog dialog = new ChoiceDialog(dialogData.get(0), dialogData);
                Label label1 = new Label("Name: ");
                Label label2 = new Label("Phone: ");
                TextField text1 = new TextField();
                TextField text2 = new TextField();


                grid.add(label1, 1, 1);
                grid.add(text1, 2, 1);
                grid.add(label2, 1, 2);
                grid.add(text2, 2, 2);
                dialog.getDialogPane().setContent(grid);
                dialog.setTitle("Creating New Semigroup");
                dialog.setWidth(600);
                dialog.setHeaderText("Complete your Semigroup");
                //dialog.setResizable(true);
                Optional<String> result = dialog.showAndWait();
                String selected = "cancelled.";
                if (result.isPresent()) {
                    selected = result.get();
                }
            }
            //actionStatus.setText("Selection: " + selected);
        };

        EventHandler go_back = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Back to Login");
                alert.setHeaderText("Confirm that you want to go Back to the Login :(");
                alert.setContentText("Anyway, Thank you for using this app!");

                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    Login.Menu.frame.dispose();
                    Login.Login_Start frame = new Login.Login_Start();
                    frame.setVisible(true);
                }
            }
        };


        EventHandler clear_event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gc.clearRect(0, 0, gc.getCanvas().getHeight(), gc.getCanvas().getWidth());
            }
        };


        EventHandler new_category_event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent ) {
                gc.setFill(Color.DARKGREEN);
                gc.setFill(Color.DARKGREEN);
                gc.fillOval(50, 50, 50, 50);
                gc.fillOval(200, 200, 50, 50);

            }
        };

        clear_all.setOnAction(clear_event);
        Clear_all.setOnAction(clear_event);
        Exit_now.setOnAction(exit_event);
        exit.setOnAction(exit_event);
        Back_now.setOnAction(go_back);
        back.setOnAction(go_back);

        New_Semigroup.setOnAction(form_event);
        New_Integer_Category.setOnAction(new_category_event);
        New_Boolean_Category.setOnAction(new_category_event);
        New_Set_Category.setOnAction(new_category_event);
        New_Vector_Category.setOnAction(new_category_event);
    }
}
