/**
 * Control.java
 * */
package project_car;

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

public class Control{
    
  //racing car
  Car[] car = new Car[4];
  
  //textfields to set speed 
  TextField[] tf = new TextField[4];

  //header contains textfields 
  HBox header = new HBox();
  
  //footer contains buttons to start and pause
  HBox footer = new HBox();
  
  
  Control(){
    initHeader();
    initFooter();
    //create cars 
    for(int i = 0; i < 4; i++) {
      car[i] = new Car();
    }
  }
  
  //init header 
  private void initHeader() {
    for(int  i = 0; i < 4; i++) {
      tf[i] = new TextField();
      tf[i].setText("100");     //set initial speed the lowest
      var t = new Text("Car " + (i + 1));
      //add text and text field
      header.getChildren().addAll(t, tf[i]);
    }
  }
  
  //init footer 
  private void initFooter() {
   
    //create and add buttons to start and pause
    var btnRun = new Button("Run");
    var btnPause = new Button("Pause");
    footer.getChildren().addAll(btnRun, btnPause);
    
    //set ActionHandler for buttons 
    btnRun.setOnAction(e->{
      for(int i = 0; i < 4; i++) {
        String input = tf[i].getText(); 
        if(input != null && !input.isEmpty())
          car[i].setSpeed(input);
        car[i].run();
      }      
    });
    
    btnPause.setOnAction(e->{
      for(int i = 0; i < 4; i++) {
        car[i].pause();
      }
    });
  }
}