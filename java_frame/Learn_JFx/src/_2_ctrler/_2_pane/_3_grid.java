package _2_ctrler._2_pane;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class  _3_grid extends Application{
  @Override
  public void start(Stage primaryStage) {
    var l1 = new Label("First Name"); 
    var l2 = new Label("Last  Name"); 
    var tf1 = new TextField();
    var tf2 = new TextField();
    tf1.setPrefColumnCount(5);
    tf2.setPrefColumnCount(5);
    
    //specific col & row, 2-dimension cell 
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);  //not change when resize
    
    //set special property
    pane.setGridLinesVisible(true); //can see the cell's border
    
    //need to add & set position
    pane.add(l1, 0, 0);
    pane.add(tf1, 0, 1);
    pane.add(l2, 1, 0);
    pane.add(tf2, 1, 1);
    //not each cell need to be filled 
    
    //can change the itme's pos in the cell
    GridPane.setHalignment(l1,HPos.RIGHT);
    GridPane.setHalignment(l2,HPos.RIGHT);

    //can get index
    System.out.println(GridPane.getRowIndex(l1) + ", " + GridPane.getColumnIndex(l1));
    
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }

}