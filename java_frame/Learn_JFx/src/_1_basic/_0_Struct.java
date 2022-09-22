package _1_basic;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//app - stage - scene - pane - pane / controls (both are child of Node -> Parent abs-cls)
public class _0_Struct extends Application{
  
  @Override
  public void start(Stage primaryStage){
    
    Button btn = new Button("a");    //1 control only used once    
    Circle circle = new Circle(50); 
    btn.setLayoutX(0);   
    circle.setCenterX(0);
    circle.setStroke(Color.PINK);
    circle.setFill(Color.gray(1));
    
    //pane: to lay out nodes in desired location & size
    FlowPane pane = new FlowPane();
    //diff types: Stack, Tile, Flow, Anchor, Border, Grid, HBox, VBox
    pane.setPadding(new Insets(5, 5, 5, 5));
    
    //how to add child to a pane
    //pane.add();   //err
    pane.getChildren().add(circle);
    pane.getChildren().addAll(btn, new Button("b"));
    
    Scene scene = new Scene(pane, 200, 200); //set size && root of the scene
    
    primaryStage.setTitle("hello javaFX");
    primaryStage.setScene(scene); //1 stage <-> 1 scene, but can multi-stages     
    primaryStage.show();    
    
    var s = new Stage();
    s.setScene(new Scene(new Pane(), 10, 10));
    s.show();
  }
  
  //main(): not needed for CLI, only needed for IDE (with limit JFX support)
  public static void main(String[]args) {
    launch(args);
  }
}
