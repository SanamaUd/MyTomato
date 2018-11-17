package mainview;

import java.time.Duration;

import javafx.scene.Node;
import javafx.scene.Scene;
import styles.CssStyler;
import timerdisplay.TimerDisplay;
import timermodel.TimerModel;

/**
 * Starts of the view.
 */
public class MyTomatoView {

  private Node view;
  private TimerDisplay timerDisplay;

  /**
   * Constructor.
   * @param scene the scene on which the content will be displayed
   * @param timerModel the {@link TimerModel} to observe to update the display
   */
  public MyTomatoView(Scene scene, TimerModel timerModel) {
    this.timerDisplay = new TimerDisplay();
    timerModel.getObservableManager().addObservers(TimerModel.DURATION_MODIFIED, this::updateDisplayMessage);

    CssStyler.styleScene(scene);

    this.view = timerDisplay.getNode();
  }

  private void updateDisplayMessage(Duration duration) {
	  String minuteString = Long.toString(duration.toMinutes());
	  long secondLeft = duration.toMillis()/1000;
	  long secondToDisplay = secondLeft%60;
	  String secondString = Long.toString(secondToDisplay);
	  timerDisplay.updateDisplayMessage(minuteString+" : "+secondString);
  }
  
  /**
   * Returns the view.
   * @return the view
   */
  public Node getNode() {
    return view;
  }
}
