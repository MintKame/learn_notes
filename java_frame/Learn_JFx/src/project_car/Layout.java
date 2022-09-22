/**
 * Layout.java
 * */
package project_car;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.beans.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.*;

public class Layout extends Application{
  @Override
  public void start(Stage primaryStage){    
    
    //create a pane to contain header and cars and footer
    VBox pane = new VBox();

    //create controler which contains header and cars and footer
    Control controler = new Control();
    
    //add header to the pane
    pane.getChildren().add(controler.header);
    
    //add cars to the pane
    for(int i = 0; i < 4; i++) {      
      pane.getChildren().add(controler.car[i]);
    }

    //add footer to the pane
    pane.getChildren().add(controler.footer);
    
    //set scene and stage
    Scene scene = new Scene(pane, 600, 250);
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Racing cars");
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}