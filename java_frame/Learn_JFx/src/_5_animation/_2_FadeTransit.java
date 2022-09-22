package _5_animation;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.shape.*;

public class  _2_FadeTransit extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    var c = new Circle(50);
    c.setFill(Color.BLUE);
    
    var ft = new FadeTransition(Duration.millis(4000), c);  //duration & node
    ft.setByValue(0.1);
    ft.setFromValue(0);
    ft.setToValue(1);

    ft.setAutoReverse(true);
    ft.setCycleCount(Timeline.INDEFINITE);
    ft.play();
    
    
    Pane pane = new FlowPane();
    pane.getChildren().add(c);
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}