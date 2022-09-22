package _4_event_driven_programming;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.beans.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.shape.*;

public class  _3_mouse extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    // mouse
    var p = new Circle(50);
    p.setOnMouseDragged(e->{
      // special func for mouse
      p.setCenterX(e.getX());
      p.setCenterY(e.getY());
      e.getSceneX();
      e.getScreenX();
      e.getClickCount();
      e.getButton();    //MouseButton.XX (PRIMARY SECONDARY MIDDLE NONE
      //common func 
      e.isAltDown();
      e.isControlDown();
      e.isShiftDown();
    });
    
    Pane pane = new Pane();
    pane.getChildren().add(p);
    Scene scene = new Scene(pane, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}