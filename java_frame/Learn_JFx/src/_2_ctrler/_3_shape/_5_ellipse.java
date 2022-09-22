package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class  _5_ellipse extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    Pane pane = new StackPane();
    Scene scene = new Scene(pane, 400, 200);
    System.out.println(pane.widthProperty());
    
    for (int i = 0; i < 16; i++) {
      // Create
      Ellipse e1 = new Ellipse(pane.getWidth() / 2, pane.getHeight() / 2, pane.getWidth() / 2 - 50, pane.getHeight() / 2 - 50);
      e1.setFill(null);
      e1.setStroke(Color.BLACK);
      e1.setRotate(i * 180 / 16);
      pane.getChildren().add(e1);
    }
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }

}