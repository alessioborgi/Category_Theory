package Login;

/**
 * @author alessioborgi
 * @created 14 / 05 / 2021 - 18:27
 * @project CATEGORY_THEORY
 */

import Login.stages.*;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.*;

public class JavaFX {
    public static Group root  =  new  Group();
    private static Scene  scene  =  new  Scene(root);
    public static Group draw = new Group();
    private static MenuBar main_menu = new MenuBar();
    private static Menu Create = new Menu("Create");
    private static Menu Draw = new Menu("Draw");
    private static Menu Cancel = new Menu("Cancel");
    private static Menu Help = new Menu("Help");
    private static Menu New_Vector = new Menu("New Vector");

    private static MenuItem Exit_now = new MenuItem("Exit");
    private static MenuItem Clear_all = new MenuItem("Clear All");
    private static MenuItem Back_now = new MenuItem("Logout");
    private static MenuItem New_Semigroup = new MenuItem("New Semigroup");
    private static MenuItem New_Monoid = new MenuItem("New Monoid");
    private static MenuItem New_Group = new MenuItem("New Group");
    private static MenuItem New_Ring = new MenuItem("New Ring");
    private static MenuItem New_Set = new MenuItem("New Set");
    private static MenuItem About = new MenuItem("About");
    private static MenuItem Free = new MenuItem("Free Drawing");
    private static SeparatorMenuItem separator = new SeparatorMenuItem();
    private static MenuItem Add_Sub_Vector = new MenuItem("Add/Sub Vectors");
    private static MenuItem Mul_Div_Vector = new MenuItem("Mul/Div Vectors");


    private static Button exit = new Button("Exit");
    private static Button clear_all = new Button("Clear");
    private static Button back = new Button("Logout");
    private static HBox box = new HBox(clear_all, exit, back);

    public static LinearGradient background = new LinearGradient(0, 0, 1, 1, true,    //sizing
            CycleMethod.NO_CYCLE,                  //cycling
            new Stop(0, Color.GOLD),            //colors
            new Stop(1, Color.ORANGE)
    );

    public static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    public static Scene createScene() {
        scene.setFill(background);
        addActions();
        setter();

        root.getChildren().addAll(box, main_menu, draw);//
        return (scene);
    }

    private static void setter(){
        scene.getStylesheets().add("Login/Styles.css");

        Help.getItems().add(About);
        Create.getItems().addAll(New_Semigroup, New_Monoid, New_Group, New_Ring, New_Set, New_Vector);
        New_Vector.getItems().addAll(Add_Sub_Vector, Mul_Div_Vector);
        main_menu.getMenus().addAll(Create, Draw, Cancel, Help);
        Cancel.getItems().addAll(Clear_all, Back_now, separator, Exit_now);
        Draw.getItems().add(Free);

        //Mnemonics used up to now: (a, c, d, e, f, g, k, l, m, r, s, v)
        About.setAccelerator(KeyCombination.keyCombination("shortcut+A"));
        Clear_all.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
        Mul_Div_Vector.setAccelerator(KeyCombination.keyCombination("shortcut+D"));
        Exit_now.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
        Free.setAccelerator(KeyCombination.keyCombination("shortcut+F"));
        New_Group.setAccelerator(KeyCombination.keyCombination("shortcut+G"));
        New_Semigroup.setAccelerator(KeyCombination.keyCombination("shortcut+K"));
        Back_now.setAccelerator(KeyCombination.keyCombination("shortcut+L"));
        New_Monoid.setAccelerator(KeyCombination.keyCombination("shortcut+M"));
        New_Ring.setAccelerator(KeyCombination.keyCombination("shortcut+R"));
        New_Set.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
        Add_Sub_Vector.setAccelerator(KeyCombination.keyCombination("shortcut+V"));

        exit.getStyleClass().add("button-red");
        clear_all.getStyleClass().add("button-green");
        back.getStyleClass().add("button-logout");

        box.setSpacing(10);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(570, 0, 0, 340));

    }

    private static void addActions(){
        EventHandler free_event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage vis = new Stage();
                try {
                    new Free_Drawing.Main().start(vis);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

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


        EventHandler new_monoid = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage monoid = new Stage();
                new New_Monoid().start(monoid);
            }
        };

        EventHandler new_set = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage set = new Stage();
                new New_Set().start(set);
            }
        };

        EventHandler new_group = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage group = new Stage();
                new New_Group().start(group);
            }
        };

        EventHandler new_semigroup = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage semigroup = new Stage();
                new New_SemiGroup().start(semigroup);
            }
        };

        EventHandler new_ring = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage ring = new Stage();
                new New_Ring().start(ring);
            }
        };

        EventHandler muldiv_vec = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage muldivVec = new Stage();
                new Mul_Div_Vec().start(muldivVec);
            }
        };

        EventHandler subadd_Vec = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage addsubVec = new Stage();
                new Add_Sub_Vec().start(addsubVec);
            }
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
                    Login_Start frame_1 = new Login_Start();
                    frame_1.setVisible(true);
                }
            }
        };


        EventHandler clear_event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                draw.getChildren().clear();
            }
        };




        clear_all.setOnAction(clear_event);
        Clear_all.setOnAction(clear_event);
        Exit_now.setOnAction(exit_event);
        exit.setOnAction(exit_event);
        Back_now.setOnAction(go_back);
        back.setOnAction(go_back);
        Draw.setOnAction(free_event);

        //****************************************************

        New_Semigroup.setOnAction(new_semigroup);
        New_Group.setOnAction(new_group);
        New_Set.setOnAction(new_set);
        New_Ring.setOnAction(new_ring);
        New_Monoid.setOnAction(new_monoid);
        Add_Sub_Vector.setOnAction(subadd_Vec);
        Mul_Div_Vector.setOnAction(muldiv_vec);
    }
}
