package _1_basic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

//how to separate main with the cls which extends Application ?

//1. both public class, same pkg
//2. in main, call ?
public class _1_app_cls extends Application{
  @Override
  public void start(Stage primaryStage) throws Exception {
    System.out.println("success");
  }
}
