package _4_cls_simplify;

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
import javafx.scene.shape.*;
public class _3_lambda extends Application{
  @Override
  //what is lambda ?
  //    simplify AIC.
  
  //when can use ?
  //  inner cls only use 1 time
  //  extend super / implement IF
  //  functional IF (funcional: have 1 abs func) (diff from AIC)
  //  not def other things in class

  public void start(Stage PrimaryStage) {
    Button btn = new Button("ha ha");

    // AIC (cmp with lambda):
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {System.out.println("Action"); }
    });
    
    // lambda (2-ways) ?
    //
    //1. pass an instance of the sub of [ functional IF / CLS ]
    btn.setOnAction((ActionEvent e) -> {System.out.println("Action");});
    //
    //2. create an instance of the sub of [ functional IF / CLS ]
    EventHandler<ActionEvent> handler = (ActionEvent e) -> {System.out.println("Action");};

    //how to omit sth ?
    //omit dataType 
    //omit {;}       only 1 statements
    btn.setOnMouseClicked( (e) -> System.out.println("Click") );
    //omit ()       only 1 para && must omit dataType
    btn.setOnKeyPressed( e -> System.out.println("Key") );

    StackPane pane = new StackPane();
    pane.getChildren().add(btn);
    Scene scene = new Scene(pane);
    PrimaryStage.setScene(scene);
    PrimaryStage.show();
  }
  public static void main(String[] args) {
    launch();
  }
}

