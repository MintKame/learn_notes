package _2_ctrler;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class  _5_font extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    Label[] label = new Label[100];
    VBox pane = new VBox();
    
    //print using all fonts
    int cnt = 0;
    for(String i : Font.getFamilies()) {    //get all families
      
      label[cnt] = new Label("JavaFX"); //use label to show words
      
      label[cnt].setFont(new Font(i, 20)); //create & set new font objset
      
      pane.getChildren().add(label[cnt]);
    }
    Scene scene = new Scene(pane,10, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}
