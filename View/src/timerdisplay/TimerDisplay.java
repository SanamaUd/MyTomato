package timerdisplay;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Displays the time value.
 */
public class TimerDisplay {

  private HBox displayBox;
  private Text displayText;
  private MenuBar menubar;
  private BorderPane pane;

  /**
   * Constructor for creating the display.
   */
  public TimerDisplay() {
    displayBox = new HBox();
    displayText = new Text();
    
    displayBox.setSpacing(5.);
    displayBox.getChildren().add(displayText);
    
    menubar = new MenuBar();
    menubar.getMenus().add(new Menu("Fancy menu"));
    pane = new BorderPane(displayBox);
   
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
    return pane;
  }
}
