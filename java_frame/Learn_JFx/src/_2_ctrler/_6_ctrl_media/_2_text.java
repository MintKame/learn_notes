package _2_ctrler._6_ctrl_media;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.*;


/*
TextInputCtrl - TextArea
              - TextField - PasswdField
* */

public class  _2_text extends Application{
  
  @Override
  public void start(Stage primaryStage) {
    
    //text field
    var tf = new TextField("hello");
    var lb = new Label("text-field:", tf);   //always
    lb.setContentDisplay(ContentDisplay.LEFT);
    
    tf.setEditable(false);   //inherit from TextInputCtrl
    
    tf.setAlignment(Pos.CENTER);    //self methods
    tf.setPrefColumnCount(20);
    tf.setOnAction(e->{ //fired when press ENTER
      System.out.println("tf:\n" + tf.getText());
    });
    
    //text area: for multi-lines
    var ta = new TextArea("text-area");
    ta.setPrefRowCount(50);
    ta.setWrapText(true);
    
    var spane = new ScrollPane(ta); //always
    
    VBox pane = new VBox();
    pane.getChildren().addAll(lb, tf, spane);
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }

}
