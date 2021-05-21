package sample;

import javafx.scene.control.Button;

/**
 * @author alessioborgi
 * @created 20 / 05 / 2021 - 17:56
 * @project CATEGORY_THEORY
 */
public class Vertex extends Button {

    public static int count = 0;
    public int ID;

    public Vertex(Double x, Double y){
        setLayoutX(x);
        setLayoutY(y);

        translateXProperty().bind(widthProperty().divide(2));
        translateYProperty().bind(heightProperty().divide(-2));

        ID = count++;
        setText(ID + "");
        getStyleClass().add("visNode");

    }
}
