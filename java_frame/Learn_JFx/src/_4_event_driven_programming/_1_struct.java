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

//how to change circle using btn && Handler ?
//sol    inner-cls
//2-way  cls def outer + pass source to ctor + change in handle

//1. obj with op:
class CirclePane extends StackPane{     

  // changed components 
  Circle c = new Circle(50);
  
  // methods (how to change)
  public void enlarge(){
    c.setRadius(c.getRadius() * 1.1);
  }

  CirclePane(){     //set & put on a pane
    c.setStroke(Color.BLACK);
    c.setFill(null);
    getChildren().add(c);
  }
}

//2. wrap cls: 
class ControlCirclePane extends BorderPane{
 
  //a. changed obj 
  CirclePane cPane = new CirclePane();  //changed obj

  //b. event source obj 
  Button cBtn = new Button(); //event source
   
  //c. (inner) handler cls (to change c) (in the cls of changed data & source)
  private class cHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e) {
      cPane.enlarge();
    }
  }

  public ControlCirclePane(){
    setTop(cBtn);   //put on the pane
    setCenter(cPane);
    cBtn.setOnAction(new cHandler());   //register
  }
}

public class  _1_struct extends Application{
    
  public void start(Stage primaryStage) {
    var pane = new StackPane();    
    pane.getChildren().add(new ControlCirclePane());
    Scene scene = new Scene(pane, 300, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }  
  public static void main(String[] args) {
    launch();
  }
}
