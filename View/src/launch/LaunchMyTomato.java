package launch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mainview.MyTomatoView;
import timermodel.TimerModel;

/**
 * Launches the application.
 */
public class LaunchMyTomato extends Application {

  private static final String MY_TOMATO = "My Tomato";

  private TimerModel timermodel;
  
  
  public void setTimermodel(TimerModel timermodel) {
	this.timermodel = timermodel;
}

@Override
  public void start(Stage primaryStage) {	  
    StackPane root = new StackPane();
    Scene scene = new Scene(root);
    root.getChildren().add(new MyTomatoView(scene, timermodel).getNode());
    primaryStage.setTitle(MY_TOMATO);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
	  LaunchMyTomato swethaTomato = new LaunchMyTomato();
	  TimerModel timermodel2 = new TimerModel();
	  timermodel2.start();
	  swethaTomato.setTimermodel(timermodel2);
	  
	  Platform.runLater(()-> swethaTomato.start(new Stage()));
	  
  }
}
