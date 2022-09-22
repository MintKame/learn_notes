package _2_ctrler._2_pane;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class  _5_Box extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    Button btn1 = new Button("1"); 
    Button btn2 = new Button("2"); 
    
    //single row ( col - VBox )
    HBox pane = new HBox();
    
    //set special 
    pane.setSpacing(10);    // == setHGAP or VGAP
    pane.setFillHeight(true); //if fill full height

    pane.getChildren().addAll(btn1, btn2);
    VBox.setMargin(btn1, new Insets(50, 50, 50, 500));
    
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}