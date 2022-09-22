package _2_ctrler._3_shape;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.*;

public class  _6_arc extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    Arc[] arc = new Arc[4];
    for(int i = 0; i < arc.length; i++) {
      arc[i] = new Arc(150, 100, 80, 80, 30 + i * 90, 35);
      arc[i].setFill(Color.WHITE);
      arc[i].setStroke(Color.BLACK);
    }
    // 3 arc types
    arc[0].setType(ArcType.ROUND); 
    arc[1].setType(ArcType.OPEN);
    arc[2].setType(ArcType.CHORD);
    arc[3].setType(ArcType.CHORD);

    // Create a group and add nodes to the group
    Group group = new Group();
    group.getChildren().addAll(new Text(210, 40, "arc1: round"), 
      arc[0], new Text(20, 40, "arc2: open"), arc[1],
      new Text(20, 170, "arc3: chord"), arc[2], 
      new Text(210, 170, "arc4: chord"), arc[3]);      
    
    Scene scene = new Scene(new BorderPane(group), 300, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}