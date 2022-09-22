package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class _1_text extends Application{
  @Override
  public void start(Stage primaryStage) {

    //SHAPE:
    //1. to bind custmized shape:
    //      make it extends pane.
    //      a paint func (refresh pane's all child)
    //      override setter of Width, Heigth, then call paint() 
    //2. common properties: fill, stroke, strokeWidth
    
    //text: always place in a pane
    Text text = new Text("hello");  
    Pane textPane = new StackPane();
    textPane.getChildren().add(text);        
    
    //set 
    text.setUnderline(true);
    text.setStrikethrough(true);
    text.setStrikethrough(true);
    
    Pane pane = new FlowPane();
    pane.getChildren().add(text);
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }
}