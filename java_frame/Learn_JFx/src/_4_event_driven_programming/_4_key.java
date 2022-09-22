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
import javafx.scene.text.Text;
import javafx.scene.shape.*;

public class  _4_key extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    var c = new Text(20, 20, "A");
    Pane pane = new Pane();
    pane.getChildren().add(c);
    
    //press / release: char
    //      getCharacter() return ""
    //typed: String
    //      getCode()      return UNDEFINED
    c.setOnKeyPressed(e->{
      System.out.println(e.getText() + e.getCharacter());   
      //getText: describe the code
      switch(e.getCode()) { //keyCode - enum type  
        case W:
        c.setY(c.getY() - 10); break;
        case S:
        c.setY(c.getY() + 10); break;
        case A:
        c.setX(c.getX() - 10); break;
        case D:
        c.setX(c.getX() + 10); break;
        default:;
      }
    });
    Scene scene = new Scene(pane, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
    
    c.requestFocus();   
    //MUST after .show()
    //if nodes change, add requestFocus in handler
  }
  public static void main(String[] args) {
    launch();
  }
}