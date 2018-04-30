package launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mainview.MyTomatoView;

/**
 * Launches the application.
 */
public class LaunchMyTomato extends Application {

  private static final String MY_TOMATO = "My Tomato";

  @Override
  public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    Scene scene = new Scene(root);
    root.getChildren().add(new MyTomatoView(scene).getNode());

    primaryStage.setTitle(MY_TOMATO);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
