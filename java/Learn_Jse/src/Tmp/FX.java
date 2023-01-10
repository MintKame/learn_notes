package Tmp;/*
 * @Author: 闫昭
 * @Date: 2020-12-24- 10:00:00
 * @LastEditors:
 * @Description:
 */

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.Key;


public class FX extends Application {
    @Override
    public void start(Stage primaryStage){
        Button btn = new Button("start");
        Circle circle = new Circle(50);

        KeyFrame keyFrame = new KeyFrame(new Duration(1000), e -> {
            if (circle.getFill() == Color.BLACK)
                circle.setFill(Color.WHITE);
            else
                circle.setFill(Color.BLACK);
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        btn.setOnAction(e->{
            timeline.play();
        });


        StackPane root  = new StackPane();
        root.getChildren().addAll(circle, btn);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
