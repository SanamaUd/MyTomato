package styles;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.Scene;

/**
 * Applies the {@link CssStyles} to the given {@link Scene}.
 */
public class CssStyler {

  /**
   * Prevent instantiation.
   */
  private CssStyler() {
    //do nothing
  }

  /**
   * Styles the scene.
   *
   * @param scene the scene to style
   */
  public static void styleScene(Scene scene) {
    List<String> validatedCssPaths = Arrays.stream(CssStyles.values())
        .map(CssStyles::getValidatedCssPath)
        .collect(Collectors.toList());

    scene.getStylesheets().addAll(validatedCssPaths);
  }
}
