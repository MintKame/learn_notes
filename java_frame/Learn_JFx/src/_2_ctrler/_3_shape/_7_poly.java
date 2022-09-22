package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class  _7_poly extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    Pane pane = new StackPane();
    pane.setPadding(new Insets(100, 100, 100, 100));
    Scene scene = new Scene(pane, 500, 500);
    
    //polygon, polyline
    Polygon polygon = new Polygon();
    polygon.setFill(Color.WHITE);
    polygon.setStroke(Color.BLACK);
    
    // Add points to the polygon list
    ObservableList<Double> list = polygon.getPoints();
    double radius = Math.min(pane.getWidth(), pane.getHeight());
    for (int i = 0; i < 6; i++) {
      list.add(0.5 * (pane.getWidth() + radius * Math.cos(2 * i * Math.PI / 6))); 
      list.add(0.5 * (pane.getHeight() - radius * Math.sin(2 * i * Math.PI / 6)));
    }     
    System.out.println(list.toString());
    
    pane.getChildren().add(polygon);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}