package _1_basic;

import javafx.application.*;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class _2_Bind extends Application{
  @Override
  public void start(Stage primaryStage) {
    
    Circle circle = new Circle(50);
    
    FlowPane pane = new FlowPane(20, 20);
    pane.getChildren().add(circle);
    
    //what's bind ?
    //  para change -> obj change
    //  bindBidirectional: <->    (some can't)

    //what's need to bind ?
    //  diff: get value / property
    circle.radiusProperty().bind(pane.widthProperty().divide(2));
    circle.getRadius(); //a value, can't bind!
    
    //to bind cls      : implements ObservableValue(IF)
    //to bind primitive: wrap the var as XXXProperty (abs cls)
    DoubleProperty d1 = new SimpleDoubleProperty(1.0);  
    DoubleProperty d2 = new SimpleDoubleProperty(10.0);
    System.out.println("d1: " + d1.getValue() + "\t\td2: " + d2.getValue());
    d1.bindBidirectional(d2);
    System.out.println("d1: " + d1.getValue() + "\td2: " + d2.getValue());
    
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }  
  public static void main(String[]args) {
    launch(args);
  }
} 