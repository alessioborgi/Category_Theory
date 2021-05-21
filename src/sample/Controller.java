package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mycontrols.Arrow;

/**
 * @author alessioborgi
 * @created 20 / 05 / 2021 - 15:57
 * @project CATEGORY_THEORY
 */
public class Controller {

    @FXML
    AnchorPane graph;
    Vertex vertex1;
    Vertex vertex2;
    Vertex vertexDelete;
    Arrow arrow;

    //Graph Events
    public void onGraphPressed(MouseEvent mouseEvent) {
        if(mouseEvent.isPrimaryButtonDown()){
            vertex1 = createAndAddVertex(mouseEvent.getX(), mouseEvent.getY());
        }
        //graph.getChildren().add(createVertex(mouseEvent));
    }

    public void onGraphDragDetected(MouseEvent mouseEvent) {
        if(mouseEvent.isPrimaryButtonDown()) {
            vertex2 = createAndAddVertex(mouseEvent.getX(), mouseEvent.getY());
            arrow = createAndAddArrow(vertex1, vertex2);
        }
    }

    public void onGraphDragged(MouseEvent mouseEvent) {
        if(vertex2 != null){
            vertex2.setLayoutX(mouseEvent.getX());
            vertex2.setLayoutY(mouseEvent.getY());
        }
    }

    public void onGraphReleased(MouseEvent mouseEvent) {
        vertex2 = null;
    }


    //Vertex Events
    private void onVertexPressed(MouseEvent mouseEvent, Vertex vertex) {
        if(mouseEvent.isPrimaryButtonDown()){
            vertex1 = vertex;
        }else if(mouseEvent.isSecondaryButtonDown()){
            vertexDelete = vertex;
        }
    }
    private void onVertexDragDetected(MouseEvent mouseEvent, Button vertex){
        vertex.toFront();
        if(mouseEvent.isPrimaryButtonDown()){
            vertex2 = createAndAddVertex(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX(),
                                            vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
            arrow = createAndAddArrow(vertex1, vertex2);
        }else if(mouseEvent.isSecondaryButtonDown()){
            vertexDelete = null;
        }
    }

    private void onVertexDragged(MouseEvent mouseEvent, Button vertex){
        if(vertex2 != null){
            vertex2.setLayoutX(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX());
            vertex2.setLayoutY(vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
        }
        if(mouseEvent.isSecondaryButtonDown()){
            vertex.setLayoutX(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX());
            vertex.setLayoutY(vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
        }
    }

    private void onVertexReleases(MouseEvent mouseEvent, Vertex vertex) {
        vertex1 = null;
        if(vertexDelete != null){
            graph.getChildren().remove(vertexDelete);
        }
        vertex2 = null;
        vertexDelete = null;
    }

    //Helper Methods
    private Vertex createAndAddVertex(Double x, Double y){
        Vertex vertex = new Vertex(x, y);

        vertex.setOnMousePressed(mouseEvent -> onVertexPressed(mouseEvent, vertex));
        vertex.setOnDragDetected(mouseEvent -> onVertexDragDetected(mouseEvent, vertex));
        vertex.setOnMouseDragged(mouseEvent -> onVertexDragged(mouseEvent, vertex));
        vertex.setOnMouseReleased(mouseEvent -> onVertexReleases(mouseEvent, vertex));

        graph.getChildren().add(vertex);
        return vertex;
    }

    private Arrow createAndAddArrow(Vertex v1, Vertex v2){
        Arrow arrow = new Arrow(v1.getLayoutX(), v1.getLayoutY(), v2.getLayoutX(), v2.getLayoutY());
        arrow.x1Property().bind(v1.layoutXProperty());
        arrow.y1Property().bind(v1.layoutYProperty());
        arrow.x2Property().bind(v2.layoutXProperty());
        arrow.y2Property().bind(v2.layoutYProperty());

        graph.getChildren().add(arrow);
        return arrow;
    }
}
