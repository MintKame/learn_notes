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

public class  _2_simple extends Application{
  @Override
  public void start(Stage primaryStage) { }

  //how to add event-handler ?
  //solve-1 IC (can reuse: class, obj)
  class Handler implements EventHandler<ActionEvent>{
    public void handle(ActionEvent event) {}
  }
  void f1() {
    var btn = new Button();
    var handler = new Handler();
    btn.setOnAction(handler);
  }

  //solve-2 AIC (can reuse: obj)
  void f2() {

    var btn = new Button();
    var handler = new EventHandler<ActionEvent>(){  // class def with create
      @Override
      public void handle(ActionEvent event){}
    };
    btn.setOnAction(handler);
  }

  //solve-3 Lambda expr (can't reuse)
  void f3(){
    var btn = new Button();
    btn.setOnAction(e->{});
  }
}