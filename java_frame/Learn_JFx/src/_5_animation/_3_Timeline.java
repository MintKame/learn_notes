package _5_animation;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
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

public class  _3_Timeline extends Application{
  public void start(Stage primaryStage) {

    var c = new Circle(50);
    //how animation ?
    //  timeline using (>= 1) KeyFrame (animation.timeline)
    //  each KF exe sequentially at specified time interval
    
    EventHandler<ActionEvent> handler_size = e->{
      if(c.getRadius() > 50)
        c.setRadius(c.getRadius() - 10);
      else
        c.setRadius(c.getRadius() + 10);
    };
    
    var kf_size = new KeyFrame(Duration.millis(200), handler_size);
    
    var tl = new Timeline(kf_size);  //add all keyFrames
    tl.setCycleCount(Animation.INDEFINITE);
    tl.play();
    
    Pane pane = new StackPane();
    pane.getChildren().add(c);
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}