package _2_ctrler._2_pane;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class  _4_border extends Application{
  @Override
  public void start(Stage primaryStage) {
    
    var t = new FlowPane(); 
    var b = new FlowPane();
    t.getChildren().addAll(new Label("First Name"), new TextField());
    b.getChildren().addAll(new Label("Last Name"), new TextField());
    
    //5 regions: top, bootom, l, r, center
    BorderPane pane = new BorderPane();
    //to add child
    pane.setTop(t);
    pane.setBottom(b);
    //to remove node
    pane.setLeft(null);
    
    Scene scene = new Scene(pane, 400, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}