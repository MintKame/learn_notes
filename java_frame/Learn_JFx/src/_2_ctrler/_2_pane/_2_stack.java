package _2_ctrler._2_pane;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class  _2_stack extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    Circle c = new Circle(50);
    c.setFill(null);
    c.setStroke(Color.BLACK);
    Label l = new Label("hello");
    
    //auto place node in center, each om top of each other
    StackPane pane = new StackPane();
    
    pane.getChildren().addAll(c, l);
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}