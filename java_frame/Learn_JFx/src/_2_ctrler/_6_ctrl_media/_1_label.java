package _2_ctrler._6_ctrl_media;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.*;

/*
Labeled(IF) - ButtonBase (have onAction) 
                         - Button
                         - CheckBox             (choose or not)
                         - ToggleBtn - RadioBtn (n choose 1)
            - Label
*/
class LabelsPane extends BorderPane{
  Pane top = new Pane();
  HBox bottom = new HBox();
  Pane center = new Pane();
  VBox left = new VBox();
  VBox right = new VBox();
  Circle c  = new Circle(20);
  
  LabelsPane(){
    super();
    initTop();
    initBottom();
    initLeft();
    initRight();
    center.getChildren().add(c);
    this.setCenter(center);
    this.setBottom(bottom);
    this.setTop(top);
    this.setLeft(left);
    this.setRight(right);
  }

  void initBottom() {
    //label
    var lb = new Label("circle", new Circle(50, 50, 10));   //add text to discribe the graphic
    lb.setContentDisplay(ContentDisplay.BOTTOM);    //set relative position
    
    //btn
    var lbtn = new Button("left", new Rectangle(10, 10));
    var rbtn = new Button("right");
    lbtn.setOnAction(e -> {
      c.setCenterX(c.getCenterX() - 20);
    });
    rbtn.setOnAction(e -> {
      c.setCenterX(c.getCenterX() + 20);
    });
    bottom.getChildren().addAll(lbtn, rbtn, lb);
  }

  void initLeft() {
    //check Box: add selection property
    //can't add node like label, btn
    var cbR = new CheckBox("R");
    var cbY = new CheckBox("Y"); 
    
    EventHandler<ActionEvent> handler = e -> {
     if(cbR.isSelected() && cbY.isSelected()) {
       c.setFill(Color.ORANGE);
     }else if(cbR.isSelected()){
       c.setFill(Color.RED);
     }else if(cbY.isSelected()) {
       c.setFill(Color.YELLOW);
     }else {
       c.setFill(Color.BLACK);
     }
    };

    cbY.setOnAction(handler);
    cbR.setOnAction(handler); 
    
    left.setPadding(new Insets(10, 10, 10, 10));
    left.getChildren().addAll(cbY, cbR);
  }
  
  void initRight() {
    //radio btn
    RadioButton[] rb = new RadioButton[3];
    var group = new ToggleGroup();
    
    for(int i = 0; i < 3; i++) {
      rb[i] = new RadioButton("" + (i * 10));      
      rb[i].setToggleGroup(group);  //otherwise each is independent
      right.getChildren().add(rb[i]);
    }
      var tmp0 = rb[0];
      var tmp1 = rb[1];
      var tmp2 = rb[2];
      rb[0].setOnAction(e->{
        if(tmp0.isSelected()) {
          c.setRadius(10);
        }
      });
      rb[1].setOnAction(e->{
        if(tmp1.isSelected()) {
          c.setRadius(20);
        }
      }); 
      rb[2].setOnAction(e->{
        if(tmp2.isSelected()) {
          c.setRadius(40);
        }
      });   
    }
  
  
  
  void initTop() {
    
  }
  
}


public class  _1_label extends Application{
  @Override
  public void start(Stage primaryStage) {
    Scene scene = new Scene(new LabelsPane(), 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}