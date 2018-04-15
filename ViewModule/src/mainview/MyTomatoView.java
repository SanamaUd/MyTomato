package mainview;

import javafx.scene.Node;
import javafx.scene.Scene;
import styles.CssStyler;
import timerdisplay.TimerDisplay;

/**
 * Starts of the view.
 */
public class MyTomatoView {

  private static final String TEST = "TEST";
  private Node view;

  /**
   * Constructor.
   * @param scene the scene on which the content will be displayed
   */
  public MyTomatoView(Scene scene) {
    TimerDisplay timerDisplay = new TimerDisplay();
    timerDisplay.updateDisplayMessage(TEST);

    CssStyler.styleScene(scene);

    this.view = timerDisplay.getNode();
  }

  /**
   * Returns the view.
   * @return the view
   */
  public Node getNode() {
    return view;
  }
}
