package timerdisplay;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Displays the time value.
 */
public class TimerDisplay {

  private HBox displayBox;
  private Text displayText;

  /**
   * Constructor for creating the display.
   */
  public TimerDisplay() {
    displayBox = new HBox();
    displayText = new Text();
    displayBox.getChildren().add(displayText);
  }

  /**
   * Updates the display message.
   * @param displayMessage the new display message
   */
  public void updateDisplayMessage(String displayMessage) {
    displayText.setText(displayMessage);
  }

  /**
   * Returns the display node.
   * @return the display node
   */
  public Node getNode() {
    return displayBox;
  }


}
