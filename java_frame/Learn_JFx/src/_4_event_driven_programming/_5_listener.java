package _4_event_driven_programming;

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

public class  _5_listener extends Application{
  
  //compare:
  //1. Source              - event  -> event handler  call  handle(XXEvent e)
  //2. Observable property - change -> listener       call  invalidated(Observable o)

  //1.
  class Handler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event) { System.out.println("handle"); }
  }
  //2.
  class Listener implements InvalidationListener{
    @Override
    public void invalidated(Observable observable) { System.out.println("invalidated"); }
  }

  public void start(Stage primaryStage) {
    //src
    //1.
    var btn = new Button("btn");
    btn.setOnAction(new Handler());
    //2.
    var dp = new SimpleDoubleProperty(10.0); //all binding property is observable
    dp.addListener(new Listener());

    //event
    //1. click the btn
    //2.
    dp.setValue(11);    //change val to trigger listener call invalidated
  }
}