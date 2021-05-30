package Free_Drawing;

/**
 * @author alessioborgi
 * @created 22 / 05 / 2021 - 14:38
 * @project CATEGORY_THEORY
 */

import Free_Drawing.menu.Define_ID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.Optional;

public class Controller {
    /*
        This class is the one where all the FXML process is implemented. Whilst in the fxml file
        all the skeleton of the Frame is implemented, here is it processed and all the events-actions
        are implemented.
     */

    //Declaration of the items of the FXML application
    @FXML
    public   AnchorPane graph;
    public  Vertex vertex1;
    public  Vertex vertex2;
    public  Vertex vertexDelete;
    public  Arrow arrow;
    public  Button button;
    public static int count = 0;
    public String ID;

    /*
        Graph Events
     */

    public void onGraphPressed(MouseEvent mouseEvent) {
        /*
            This method allows the fact that everytime I click with the left-click of the mouse,
            I create a new Node.
         */
        if(mouseEvent.isPrimaryButtonDown()){
            vertex1 = createAndAddVertex(mouseEvent.getX(), mouseEvent.getY());

        }
    }

    public void onGraphDragDetected(MouseEvent mouseEvent) {
        /*
            This method handles the fact that when a left click and a drag from the node is detected,
            it will create a new Node.
         */
        if(mouseEvent.isPrimaryButtonDown()){
            vertex2 = createAndAddVertex(mouseEvent.getX(), mouseEvent.getY());
            arrow = createAndAddArrow(vertex1, vertex2);
            vertex2.getStyleClass().add("dragged");
            arrow.getStyleClass().add("dragged");
        }
    }

    public void onGraphDragged(MouseEvent mouseEvent) {
        /*
            This Method allows the node to be moved, namely to change its position, by pressing it with
            the left click, and to drag it throughout the graph.
         */
        if(vertex2 != null){
            vertex2.setLayoutX(mouseEvent.getX());
            vertex2.setLayoutY(mouseEvent.getY());
        }
    }

    public void onGraphReleased(MouseEvent mouseEvent) {
        /*
            This method handles what happens after the node is released. The dragged option is "cancelled"
         */
        if(vertex2 != null){
            vertex2.getStyleClass().remove("dragged");
            arrow.getStyleClass().remove("dragged");
        }
        //Solves the problem that vertexTemp continues to point to the node after the drag and drop in complete
        vertex2 = null;
    }


    /*
        Vertex Events
     */

    private  void onRightClickOnVertex(MouseEvent mouseEvent, Vertex vertex) {
        /*
            This method handles the click on the vertex. If the click is done with the left click, the node is
            selected. If the click is done with the right one, the node is canceled.
         */
        if(mouseEvent.isPrimaryButtonDown()){
            vertex1 = vertex;

        }else if(mouseEvent.isSecondaryButtonDown()){
            //When I right click once on a vertex, I delete it.
            vertexDelete = vertex;
        }
    }

    private  void onVertexDragDetected(MouseEvent mouseEvent, Vertex vertex) {

        /*
            This method allows the fact that when I move one node, it should be in front of the others instead of
            moving behind them. In addition to this, it adds the fact also that if I start from a Vertex that is
            present on the graph, and then I click with the left button of the mouse, it creates a new vertex,
            connected directly with a morphism.
        */
        vertex.toFront();
        if(mouseEvent.isPrimaryButtonDown()){
            vertex2 = createAndAddVertex(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX(),
                    vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
            arrow = createAndAddArrow(vertex1, vertex2);
            vertex2.getStyleClass().add("dragged");
            arrow.getStyleClass().add("dragged");
        }else if(mouseEvent.isSecondaryButtonDown()){
            vertexDelete = null;
            vertex.getStyleClass().add("dragged");
            for(Arrow a : vertex.edges){
                a.getStyleClass().add("dragged");
            }
        }
    }

    private  void onVertexDragged(MouseEvent mouseEvent, Button vertex) {
        /*
            This method allows to drag a node throughout the graph, only with the left click.
         */
        if(vertex2 != null){
            vertex2.setLayoutX(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX());
            vertex2.setLayoutY(vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
        }
        if(mouseEvent.isSecondaryButtonDown()){
            vertex.setLayoutX(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX());
            vertex.setLayoutY(vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
        }

    }

    private  void onVertexReleased(MouseEvent mouseEvent, Vertex vertex) {
        /*
            This method handles what happens when the dragging is finished.
         */
        vertex.getStyleClass().remove("dragged");
        for(Arrow a : vertex.edges){
            a.getStyleClass().remove("dragged");
        }
        if(vertex2 != null){
            vertex2.getStyleClass().remove("dragged");
        }
        if(vertexDelete != null){
            graph.getChildren().remove(vertexDelete);
            for(Arrow a : vertexDelete.edges){
                graph.getChildren().remove(a);
            }
        }
        vertex2 = null;
        vertexDelete = null;
    }

    //Helper Methods
    public  Vertex createAndAddVertex(Double x, Double y) {
        /*
            Main method that handles all the new vertices creation and its action.
         */
        Vertex vertex = new Vertex(x, y);
        vertex.setOnAction(e -> {
            for(Arrow a : vertex.edges){
                //a.setHeadAVisible(!a.isHeadAVisible());
                a.setHeadBVisible(!a.isHeadBVisible());
            }
        });

        vertex.setOnMousePressed(mouseEvent -> onRightClickOnVertex(mouseEvent, vertex));
        vertex.setOnDragDetected(mouseEvent -> onVertexDragDetected(mouseEvent, vertex));
        vertex.setOnMouseDragged(mouseEvent -> onVertexDragged(mouseEvent, vertex));
        vertex.setOnMouseReleased(mouseEvent -> onVertexReleased(mouseEvent, vertex));

        graph.getChildren().add(vertex);
        return vertex;
    }

    private  Arrow createAndAddArrow(Vertex v1, Vertex v2){
        /*
            This method instead is the one that is the responsible for adding the morphism
            from one node to the other.
         */
        Arrow arrow = new Arrow(v1.getLayoutX(), v1.getLayoutY(), v2.getLayoutX(), v2.getLayoutY());
        //Now we bind the coordinates of the arrow to the coordinate of the vertices
        arrow.x1Property().bind(v1.layoutXProperty());
        arrow.y1Property().bind(v1.layoutYProperty());
        arrow.x2Property().bind(v2.layoutXProperty());
        arrow.y2Property().bind(v2.layoutYProperty());

        v1.edges.add(arrow);
        v2.edges.add(arrow);
        graph.getChildren().add(arrow);
        return arrow;
    }

    public void NewVertexClicked(ActionEvent actionEvent) {
        /*
            This method handles the creation of a new vertex from the insertion stage.
         */
        Stage new_vertex = new Stage();
        new Define_ID().start(new_vertex);

        Define_ID.create.setOnAction(e->{
            Double x = (Double) (Math.random()*(450-0+1)+0);
            Double y = (Double) (Math.random()*(450-50+1)+50);
            vertex1 = createAndAddVertex(x, y);

            Define_ID.idNode1Text.setText("");

        });
    }

    public void ClearAll(ActionEvent actionEvent) {
        /*
            Method responsible for the deletion of all the items from the graph.
         */
        graph.getChildren().clear();

    }

    public void ExitNow(ActionEvent actionEvent) {
        /*
            This method handles the Exit from the application, exiting definitively from it.
         */
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Confirm that you want to Exit :(");
        alert.setContentText("Anyway, Thank you so much for using our Category Theory's Application!");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            System.exit(0);
        }
    }
}
