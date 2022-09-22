package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class _3_rectangle extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    Group group = new Group();
    
    for (int i = 0; i < 4; i++) {
      Rectangle r = new Rectangle(100, 50, 100, 30);
      r.setRotate(i * 360 / 8);
      
      //arc
      r.setArcWidth(15);    
      r.setArcHeight(25);    
      
      r.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
      r.setFill(Color.WHITE);   
      //r.setFill(null);
      group.getChildren().add(r);
    }
    
    primaryStage.setScene(new Scene(new BorderPane(group), 250, 150));
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}