package project_circle;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.beans.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.shape.*;

public class Project2 extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    //draw a circle  
    var circle = new CirclePane();
    Scene scene = new Scene(circle, 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}

class CirclePane extends Pane{
  
  Circle circle = new Circle();
  
  /**
   * *构造 CirclePane，画出Circle，添加对鼠标事件的处理
   * */
  CirclePane(){
    super();
    paintCircle();
    //若左键点击mouse，当在圆内部输出out，否则输出in
    setOnMouseClicked(e->{
      if(e.getButton() == MouseButton.PRIMARY) {
        if(isInCircle(e.getX(), e.getY()))
          System.out.println("in");
        else
          System.out.println("out");
      }
    });
  }
  
  /**
   * @param 位置x，y
   * @return 是否在圆内部
   * */
  private boolean isInCircle(double x, double y) {
    double distSquare = Math.pow(x - circle.getCenterX(), 2) + Math.pow(y - circle.getCenterY(), 2);
    if(distSquare > Math.pow(circle.getRadius(), 2))
      return false;
    else
      return true;
  }
  
  //在Pane上画Circle。
   private void paintCircle() {
    getChildren().clear();
    //center of circle always in the center of pane
    circle.centerXProperty().bind(widthProperty().divide(2));
    circle.centerYProperty().bind(heightProperty().divide(2));
    
    //make radius = half of min of width and height of pane.
    circle.radiusProperty().bind(
        Bindings.min(this.widthProperty(), this.heightProperty()).divide(2));
    
    getChildren().add(circle);
  }
  
  @Override
  //为了调整后，半径仍为宽高中较小者的一半，每次重画。
  public void setWidth(double w) {
    super.setWidth(w);
    paintCircle();  //使得当调整pane大小时，circle的半径符合要求
  }
  
  @Override
  public void setHeight(double h) {
    super.setHeight(h);
    paintCircle();
  }
}