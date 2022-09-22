/**
 * Car.java
 * */
package project_car;

import java.util.Scanner;

import javafx.animation.PathTransition;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.beans.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.shape.*;

public class Car extends Pane{
  
  //speed of the car: 1 - the highest speed, 100 - the lowest
  private int speed = 100;
  
  //pane contains the car
  Pane pane = new Pane();
  
  //PathTransition which make the car run
  PathTransition pt = new PathTransition();
  
  /** put the car & line on the pane, set the speed & animation
   * @param the size of the car
   * @param the speed of the car
   * */
  Car(){
    var ground = new Line(0, 50, 600, 50);
    ground.setFill(Color.BLACK);
    
    //put car & ground line on the pane
    getChildren().addAll(pane, ground);
    
    //set the path-transition
    pt.setCycleCount(1);
    pt.setNode(pane);
    pt.setPath(new Line(0, 25, 600, 25));
    pt.setDuration(Duration.INDEFINITE);
    drawCar();
  }
  
  //draw a car on pane
  void drawCar() {
    var bg = new Rectangle(70, 50, Color.ALICEBLUE);
    pane.getChildren().addAll(bg);
    var c1 = new Circle(10, 40, 10, Color.ORANGE);
    var c2 = new Circle(60, 40, 10, Color.ORANGE);
    var r = new Rectangle(0, 10, 70 , 30);
    r.setFill(Color.ORANGE.darker());
    pane.getChildren().addAll(r, c1, c2);
  }

  //some actions to control the car:
  //set the speed of the car
  void setSpeed(String speed_) {
    speed = new Scanner(speed_).nextInt() ;
    pt.setDuration(Duration.millis(speed * 800));
  }
  
  //make the car start to run
  void run() {
    pt.setDuration(Duration.millis(speed * 800));
    pt.play();    
  }
  
  //make the car pause
  void pause() {
    pt.pause();    
  }
}
