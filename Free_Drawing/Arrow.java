package Free_Drawing;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.Group;
import javafx.scene.shape.Polyline;

/**
 * @author alessioborgi
 * @created 22 / 05 / 2021 - 16:25
 * @project CATEGORY_THEORY
 */
public class Arrow extends Group {

    private Polyline mainLine = new Polyline();     //Line of the arrow
    private Polyline headA = new Polyline();
    private Polyline headB = new Polyline();
    private SimpleDoubleProperty x1 = new SimpleDoubleProperty();
    private SimpleDoubleProperty y1 = new SimpleDoubleProperty();
    private SimpleDoubleProperty x2 = new SimpleDoubleProperty();
    private SimpleDoubleProperty y2 = new SimpleDoubleProperty();
    private SimpleBooleanProperty headAVisible = new SimpleBooleanProperty(true);
    private SimpleBooleanProperty headBVisible = new SimpleBooleanProperty(true);
    private final double ARROW_SCALER = 20;
    private final double ARROWHEAD_ANGLE= Math.toRadians(20);
    private final double ARROWHEAD_LENGTH = 10;


    public Arrow(double x1, double y1, double x2, double y2){
        this.x1.set(x1);
        this.y1.set(y1);
        this.x2.set(x2);
        this.y2.set(y2);

        //getChildren().addAll(mainLine, headA, headB);
        getChildren().addAll(mainLine, headB);


        //We add listeners to all the coordinate variable so that whenever they are updated, we can update the mainline too
        for(SimpleDoubleProperty s : new SimpleDoubleProperty[]{this.x1, this.y1, this.x2, this.y2}){
            s.addListener((l, o, n) -> update());
        }

        setUpStyleClassStructure();

        //headA.visibleProperty().bind(headAVisible);
        headB.visibleProperty().bind(headBVisible);
        update();

    }

    private void setUpStyleClassStructure() {
        mainLine.getStyleClass().setAll("arrow");
        //headA.getStyleClass().setAll("arrow");
        headB.getStyleClass().setAll("arrow");

        //headA.getStyleClass().add("arrowhead");
        headB.getStyleClass().add("arrowhead");

        //Since we set up the style for the arrow(that is a group), we have to set up a settings so that whenever
        //the Group's style changes, it update directly also the "mainLine", "headA", and "headB".
        getStyleClass().addListener((ListChangeListener<? super String>) c ->{
            c.next();
            //for(Polyline p : new Polyline[]{mainLine, headA, headB}){
            for(Polyline p : new Polyline[]{mainLine, headB}){
                p.getStyleClass().addAll(c.getAddedSubList());
                p.getStyleClass().removeAll((c.getRemoved()));
            }
        });
    }

    private void update() {
        double[] start = scale(x1.get(), y1.get(), x2.get(), y2.get());
        double[] end = scale(x2.get(), y2.get(), x1.get(), y1.get());
        //It will just set the mainLine coordinate to the coordinate variables
        mainLine.getPoints().setAll();

        double x1 = start[0];
        double y1 = start[1];
        double x2 = end[0];
        double y2 = end[1];

        mainLine.getPoints().setAll(x1, y1, x2, y2);

        double theta = Math.atan2(y2-y1, x2-x1);
        //Arrow head1
        double x = x1 + Math.cos(theta + ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        double y = y1 + Math.sin(theta + ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        //headA.getPoints().setAll(x, y, x1, y1);
        x = x1 + Math.cos(theta - ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        y = y1 + Math.sin(theta - ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        //headA.getPoints().addAll(x, y);
        //Arrow head2
        x = x2 - Math.cos(theta + ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        y = y2 - Math.sin(theta + ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        headB.getPoints().setAll(x, y, x2, y2);
        x = x2 - Math.cos(theta - ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        y = y2 - Math.sin(theta - ARROWHEAD_ANGLE) * ARROWHEAD_LENGTH;
        headB.getPoints().addAll(x, y);
    }

    private double[] scale(double x1, double y1, double x2, double y2){
        double theta = Math.atan2(y2-y1, x2-x1);
        return new double[]{
                x1 + Math.cos(theta) * ARROW_SCALER,
                y1 + Math.sin(theta) * ARROW_SCALER
        };
    }

    //Getters and Setters
    public double getX1() {
        return x1.get();
    }
    public double getY1() {
        return y1.get();
    }
    public double getX2() {
        return x2.get();
    }
    public double getY2() {
        return y2.get();
    }

    public void setX1(double x1) {
        this.x1.set(x1);
    }
    public void setY1(double y1) {
        this.y1.set(y1);
    }
    public void setX2(double x2) {
        this.x2.set(x2);
    }
    public void setY2(double y2) {
        this.y2.set(y2);
    }

    public SimpleDoubleProperty x1Property() {
        return x1;
    }
    public SimpleDoubleProperty y1Property() {
        return y1;
    }
    public SimpleDoubleProperty x2Property() {
        return x2;
    }
    public SimpleDoubleProperty y2Property() {
        return y2;
    }

    public boolean isHeadAVisible() {
        return headAVisible.get();
    }

    public SimpleBooleanProperty headAVisibleProperty() {
        return headAVisible;
    }

    public void setHeadAVisible(boolean headAVisible) {
        this.headAVisible.set(headAVisible);
    }

    public boolean isHeadBVisible() {
        return headBVisible.get();
    }

    public SimpleBooleanProperty headBVisibleProperty() {
        return headBVisible;
    }

    public void setHeadBVisible(boolean headBVisible) {
        this.headBVisible.set(headBVisible);
    }
}
