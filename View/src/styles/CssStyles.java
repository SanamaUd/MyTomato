package styles;

/**
 * Holds the CSS styles that will be applied.
 */
public enum CssStyles {

  MAIN_VIEW("/styles/root/RootCssStyle.css");

  private String cssValidatedPath;

  /**
   * Constructs the style.
   * @param path path to the css file
   */
  CssStyles(String path) {
    cssValidatedPath = getClass().getResource(path).toExternalForm();
  }

  public String getValidatedCssPath() {
    return cssValidatedPath;
  }
}
