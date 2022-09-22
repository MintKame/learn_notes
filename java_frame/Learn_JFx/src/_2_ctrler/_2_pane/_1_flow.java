package _2_ctrler._2_pane;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class  _1_flow extends Application{
  @Override
  public void start(Stage primaryStage) {
    Label l1 = new Label("First Name");
    Label l2 = new Label("Last  Name");
    TextField tf1 = new TextField();
    tf1.setPrefColumnCount(5);
    TextField tf2 = new TextField();
    tf2.setPrefColumnCount(5);
    
    //panes in pane to 
    
    //row-by-row / col-by-col
    FlowPane pane = new FlowPane();
    
    //1.  set common properties
    pane.setHgap(10);               //each children's distance
    pane.setVgap(15);
    pane.setPadding(new Insets(11, 12, 13, 14));    
    pane.setAlignment(Pos.BASELINE_RIGHT);  //always used align: Pos.XXX, V/HPos.XXX
    
    //2.  set special properties
    pane.setOrientation(Orientation.HORIZONTAL);
    
    //3.    
    pane.getChildren().addAll(l1, tf1, l2, tf2);
//    pane.getChildren().removeAll();
    
    Scene scene = new Scene(pane, 200, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }
}