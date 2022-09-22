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

//what model JFX use ?
//  delegate:
//  obj not have methods to deal with event
//  delegate to a handler obj
//  setXX 只执行一次

//程序结构：事件驱动相关元素 几个类 ？
public class  _0_struct extends Application{  
  public void start(Stage primaryStage) {
    // 3-objs
    //1. Event Source       
    Button OKBtn = new Button("OK");
    
    //2. Event  [method to reg]     "click the btn"
    
    //    java.util.EventObject 
    //        -- javafx.event.Event
    //            --a.ActionEvent:          [setOnAction()]                            
    //
    //            --b.InputEvent
    //                  --MouseEvent:     [setOnMouseXXX] eg. Pressed..
    //                  --KeyEvent        [setOnKeyXXX]   eg. Typed
    //
    //            --d.WindowEvent

    // can get msg from event obj
        
    //3. Event Handler
    OKBtn.setOnAction(new OKhandler()); // obj register with event source obj
    //      1.sub of EventHandler<XXXEvent>

    Pane pane = new FlowPane();
    pane.getChildren().add(OKBtn);
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }
}
class OKhandler implements EventHandler<ActionEvent>{
  @Override
  public void handle(ActionEvent event) {
    System.out.println("OK");
  }
}