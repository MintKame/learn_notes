package _2_ctrler;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class _6_image extends Application{
  @Override
  public void start(Stage primaryStage) {
    //Image to load (from filename / URL)
    //can share 
    Image image = new Image("image/black.jpg"); //should in bin dircetory
    //ImageView to display (2-way)
    //can't share
    var iv_1 = new ImageView(image);
    var iv_2 = new ImageView("image/green.jpg");
    
    iv_1.setFitHeight(100);//percentage
    
    Pane pane = new FlowPane();
    pane.getChildren().addAll(iv_1, iv_2);
    Scene scene = new Scene(pane, 100, 100);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch();
  }
}