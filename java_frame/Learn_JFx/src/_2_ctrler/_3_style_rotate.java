package _2_ctrler;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

//pane / controls (both are child of Node abs-cls)
//common property: style, rotate

public class _3_style_rotate extends Application{

  @Override
  public void start(Stage primaryStage) throws Exception {
     
    Button btn = new Button();
    
    Pane p = new StackPane();
    p.getChildren().add(btn);

    p.setStyle("-fx-border-color: blue;");
    //css, if incorrect, compile & ignore
    
    p.setRotate(45);    //positive - clkwise
    //pane rotate, all children rotate
    
    Scene sc = new Scene(p, 400, 400);
    
    primaryStage.setScene(sc);
    primaryStage.show();
  }

  
  
  
  
  
  public static void main(String[] args) {
    launch();
  }
}
