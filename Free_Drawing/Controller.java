package Free_Drawing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Free_Drawing.menu.New_Vertex;

import java.util.Optional;

/**
 * @author alessioborgi
 * @created 22 / 05 / 2021 - 14:38
 * @project CATEGORY_THEORY
 */
public class Controller {
    @FXML
    public AnchorPane graph;
    public Vertex vertex1;
    public Vertex vertex2;
    public Vertex vertexDelete;
    public Arrow arrow;
    public Button button;
    public Label label1;



    //Graph Events
    public void onGraphPressed(MouseEvent mouseEvent) {
        //Everytime I click with the left-click of the mouse, I create a new Node
        if(mouseEvent.isPrimaryButtonDown()){
            vertex1 = createAndAddVertex(mouseEvent.getX(), mouseEvent.getY());
        }
    }

    public void onGraphDragDetected(MouseEvent mouseEvent) {
        //When a left click and a drag from the node is detected, it will create a new node
        if(mouseEvent.isPrimaryButtonDown()){
            vertex2 = createAndAddVertex(mouseEvent.getX(), mouseEvent.getY());
            arrow = createAndAddArrow(vertex1, vertex2);
            vertex2.getStyleClass().add("dragged");
            arrow.getStyleClass().add("dragged");
        }
    }

    public void onGraphDragged(MouseEvent mouseEvent) {
        if(vertex2 != null){
            vertex2.setLayoutX(mouseEvent.getX());
            vertex2.setLayoutY(mouseEvent.getY());
        }
    }

    public void onGraphReleased(MouseEvent mouseEvent) {
        //When the node is released the dragged option cancels
        if(vertex2 != null){
            vertex2.getStyleClass().remove("dragged");
            arrow.getStyleClass().remove("dragged");
        }
        //Solves the problem that vertexTemp continues to point to the node after the drag and drop in complete
        vertex2 = null;
    }

    //Vertex Events
    private void onRightClickOnVertex(MouseEvent mouseEvent, Vertex vertex) {
        if(mouseEvent.isPrimaryButtonDown()){
            vertex1 = vertex;
        }else if(mouseEvent.isSecondaryButtonDown()){
            //When I right click once on a vertex, I delete it.
            vertexDelete = vertex;
        }
    }

    private void onVertexDragDetected(MouseEvent mouseEvent, Vertex vertex) {
        //This method allows the fact that when I move one node, it should be in front of the others instead of moving behind them
        //It adds the fact also that if I start from a Vertex that is present on the graph, and then I click with the left button
        //of the mouse, it creates a new vertex, connected directly with an arrow
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

    private void onVertexDragged(MouseEvent mouseEvent, Button vertex) {
        //This method allows me to move a node, only with the left click
        if(vertex2 != null){
            vertex2.setLayoutX(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX());
            vertex2.setLayoutY(vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
        }
        if(mouseEvent.isSecondaryButtonDown()){
            vertex.setLayoutX(vertex.getLayoutX() + mouseEvent.getX() + vertex.getTranslateX());
            vertex.setLayoutY(vertex.getLayoutY() + mouseEvent.getY() + vertex.getTranslateY());
        }

    }

    private void onVertexReleased(MouseEvent mouseEvent, Vertex vertex) {
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
    private Vertex createAndAddVertex(Double x, Double y) {
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

    private Arrow createAndAddArrow(Vertex v1, Vertex v2){
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


    //To implement
    public void handleAboutAction(ActionEvent actionEvent) {
    }

    public void handleKeyInput(KeyEvent keyEvent) {
    }

    public void SubmitPressed(ActionEvent actionEvent) {
        button.setText("Stop");
    }

    public void NewVertexClicked(ActionEvent actionEvent) {
        Stage group = new Stage();
        new New_Vertex().start(group);
    }

    public void NewComposition(ActionEvent actionEvent) {
    }

    public void NewMorphism(ActionEvent actionEvent) {
    }

    public void CancelVertex(ActionEvent actionEvent) {
    }

    public void ClearAll(ActionEvent actionEvent) {
    }

    public void Logout(ActionEvent actionEvent) {
    }

    public void ExitNow(ActionEvent actionEvent) {
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
