package Free_Drawing;

import Free_Drawing.menu.New_Vertex;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 * @author alessioborgi
 * @created 22 / 05 / 2021 - 15:03
 * @project CATEGORY_THEORY
 */
public class Vertex extends Button {

    //private static int count = 0;   //Variable that will determine the increasing of the node ID
    public static int count = 0;
    public String ID;
    public ObservableList<Arrow> edges = FXCollections.observableArrayList();

    public Vertex(Double x, Double y){
        setLayoutX(x);
        setLayoutY(y);

        //I have to obtain the fact that everytime i click, the new node has to spawn at the center on where i clicked
        translateXProperty().bind(widthProperty().divide(-2));
        translateYProperty().bind(heightProperty().divide(-2));

        if(New_Vertex.idNode1Text == (null)){
            ID = String.valueOf(count);
            setText(ID);
            count++;
        }
        else if(!New_Vertex.idNode1Text.getText().equals("")){
            ID = New_Vertex.idNode1Text.getText();
            setText(ID);}


        getStyleClass().add("visNode");

    }
}
