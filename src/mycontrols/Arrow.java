package mycontrols;

import javafx.scene.Group;
import javafx.beans.property.SimpleDoubleProperty;
import  javafx.scene.shape.Polyline;

/**
 * @author alessioborgi
 * @created 20 / 05 / 2021 - 15:47
 * @project CATEGORY_THEORY
 */
public class Arrow extends Group {
    private Polyline mainLine = new Polyline();
    private SimpleDoubleProperty x1 = new SimpleDoubleProperty();
    private SimpleDoubleProperty y1 = new SimpleDoubleProperty();
    private SimpleDoubleProperty x2 = new SimpleDoubleProperty();
    private SimpleDoubleProperty y2 = new SimpleDoubleProperty();
    private final double ARROW_SCALER = 20;

    public Arrow(double x1, double y1, double x2, double y2){
        this.x1.set(x1);
        this.y1.set(y1);
        this.x2.set(x2);
        this.y2.set(y2);

        getChildren().addAll(mainLine);

        for(SimpleDoubleProperty s : new SimpleDoubleProperty[]{this.x1, this.y1, this.x2, this.y2}){
            s.addListener((l, o, n ) -> update());
        }
        update();
    }

    private void update(){
        double[] start = scale(x1.get(), y1.get(), x2.get(), y2.get());
        double[] end = scale(x2.get(), y2.get(), x1.get(), y1.get());

        double x1 = start[0];
        double y1 = start[1];
        double x2 = end[0];
        double y2 = end[1];
        mainLine.getPoints().setAll(x1, y1, x2, y2);
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
    public SimpleDoubleProperty x1Property() {
        return x1;
    }
    public void setX1(double x1) {
        this.x1.set(x1);
    }
    public double getY1() {
        return y1.get();
    }
    public SimpleDoubleProperty y1Property() {
        return y1;
    }
    public void setY1(double y1) {
        this.y1.set(y1);
    }
    public double getX2() {
        return x2.get();
    }
    public SimpleDoubleProperty x2Property() {
        return x2;
    }
    public void setX2(double x2) {
        this.x2.set(x2);
    }
    public double getY2() {
        return y2.get();
    }
    public SimpleDoubleProperty y2Property() {
        return y2;
    }
    public void setY2(double y2) {
        this.y2.set(y2);
    }
}
