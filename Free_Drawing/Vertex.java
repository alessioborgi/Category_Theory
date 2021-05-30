package Free_Drawing;

/**
 * @author alessioborgi
 * @created 22 / 05 / 2021 - 15:03
 * @project CATEGORY_THEORY
 */

import Free_Drawing.menu.Define_ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class Vertex extends Button {
    /*
        This class handles the creation of Vertices.
     */

    //Declaration of the main items of the Vertex.
    public static int count = 0;
    public String ID;
    public ObservableList<Arrow> edges = FXCollections.observableArrayList();

    public Vertex(Double x, Double y){
        /*
            Constructor for the creation of a new Vertex.
         */
        setLayoutX(x);
        setLayoutY(y);

        //I have to obtain the fact that everytime i click, the new node has to spawn at the center on where i clicked
        translateXProperty().bind(widthProperty().divide(-2));
        translateYProperty().bind(heightProperty().divide(-2));

        //I have to distinguish the case from which I create a Vertex directly "by hand" or by the stage insertion.
        //In the former case I have to increment the ID automatically, whereas in the latter one, I have to set it
        //depending on what the user has typed.
        if(Define_ID.idNode1Text == (null)){
            ID = String.valueOf(count);
            setText(ID);
            count++;
        }
        else if(!Define_ID.idNode1Text.getText().equals("")){
            ID = Define_ID.idNode1Text.getText();
            setText(ID);
        }
        else if (Define_ID.idNode1Text.getText().equals("")){
            ID = String.valueOf(count);
            setText(ID);
            count++;
        }
        getStyleClass().add("visNode");
    }
}
