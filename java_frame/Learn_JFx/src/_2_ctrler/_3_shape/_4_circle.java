package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class  _4_circle extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    
    Image img = new Image("image/green.jpg");
    Circle circle = new Circle(50);
    
    circle.setFill(new ImagePattern(img, 20, 20, 40, 40, true));;
    //can fill: Color, ImagePattern, LinearGradient, RadialGradient
    
    Pane pane = new Pane();
    pane.getChildren().add(circle);
    Scene scene = new Scene(pane, 100, 100);
    
    circle.centerXProperty().bind(pane.widthProperty().divide(2));
    circle.centerYProperty().bind(pane.heightProperty().divide(2));
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}