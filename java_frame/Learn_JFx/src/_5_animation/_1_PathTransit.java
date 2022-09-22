package _5_animation;

import javafx.animation.PathTransition;
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
import javafx.scene.text.Text;
import javafx.scene.shape.*;

public class  _1_PathTransit extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    var circle = new Circle(200, 200, 50);
    var text = new Text("yz");
    var stopBtn = new Button("stop");
    var pauseBtn = new Button("pause");
    var playBtn = new Button("play");
    var pT = new PathTransition();

    //set common property: 
    pT.setAutoReverse(true);
    pT.setCycleCount(Timeline.INDEFINITE);
    //also have:rate (neg -> reverse) 
    //          status (Animation.Status.PAUSED / RUNNING / STOPPED, read-only)
    
    //set special property:
    pT.setPath(circle); //need a shape as path
    pT.setNode(text);    
    pT.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    pT.setDuration(Duration.millis(4000));  //immutable
    
    //about play
    pauseBtn.setOnAction(e->{
      pT.pause();
    });
    stopBtn.setOnAction(e->{
      pT.stop();
    });
    playBtn.setOnAction(e->{
      pT.play();
    });
    
    //duration
    var d = new Duration(1.0);
    d = Duration.INDEFINITE;    //ONE UNKNOWN ZERO
    d.add(d);
    d.toHours();
    
    BorderPane pane = new BorderPane();
    pane.setTop(text);
    pane.setLeft(stopBtn);
    pane.setRight(pauseBtn);
    pane.setCenter(playBtn);
    //can not add the circle
    Scene scene = new Scene(pane, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}