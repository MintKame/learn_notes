package _4_event_driven_programming;/*
 * @Author: 闫昭
 * @Date: 2020-12-15- 17:12:00
 * @LastEditors:
 * @Description:
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Tmp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var c = new Circle(50);
        var colorFrame = new KeyFrame(new Duration(200), e->{
            if (c.getFill().equals(Color.BLACK)){
                c.setFill(Color.BLUE);
            }else {
                c.setFill(Color.BLACK);
            }
        });
        var sizeFrame = new KeyFrame(new Duration(200), e->{
            double r = c.getRadius();
            if (r >= 50){
                c.setRadius(r - 10);
            }else {
                c.setRadius(r + 10);
            }
        });
        var timeline = new Timeline(colorFrame, sizeFrame);
        timeline.setCycleCount(-1);
        timeline.play();
        var pane = new StackPane();
        pane.getChildren().add(c);
        var scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
