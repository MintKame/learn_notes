package _2_ctrler;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class _4_color extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    
    Pane p = new FlowPane();

    Circle[] c = new Circle[10];
    
    //Color (extends abs cls Paint)
    Color color = new Color(0, 0, 0, 1); //R G B A (0-1)
    //obj is immutable, but can create new obj
    
    for(int i = 0; i < 10; i++){
      
      c[i] = new Circle(10);
      c[i].setFill(color);      //set color
      color = color.brighter(); //update color: ref to new color obj
      p.getChildren().add(c[i]);        
    
    }
    //also can create by [objName].darker(), Color.rgb(r,g,b) (need 0-255) 
    //or use: 
    c[9].setFill(Color.BLACK);
    
    Scene sc = new Scene(p, 400, 400);
    primaryStage.setScene(sc);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}
