package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

class LinePane extends Pane{
  public LinePane() {
    Line line1 = new Line(30, 30, 30, 30);
    line1.endXProperty().bind(widthProperty().subtract(30));
    line1.endYProperty().bind(heightProperty().subtract(30));
    line1.setStroke(Color.BLACK);
    
    Line line2 = new Line(30, 30, 30, 30);
    line2.startXProperty().bind(widthProperty().subtract(30));
    line2.endYProperty().bind(heightProperty().subtract(30));
    line2.setStroke(Color.BLACK);
    getChildren().addAll(line1, line2);
  }
}
public class _2_line extends Application{
  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new LinePane(), 100, 100);
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }
}