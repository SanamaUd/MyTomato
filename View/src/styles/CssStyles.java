package styles;

import java.io.File;
import java.net.MalformedURLException;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

/**
 * Holds the CSS styles that will be applied.
 */
public enum CssStyles {

  MAIN_VIEW("/styles/root/RootCssStyle.css");

  private static final String STYLE_SHEET_ROOT = "View/Resources";
  private static final Logger LOGGER = LoggerFactory.getLogger(CssStyles.class);
private String simplepath;

  /**
   * Constructs the style.
   * @param simplePath path to the css file
   */
  private CssStyles(String simplePath) {
	  this.simplepath = simplePath;
  }

  public String getValidatedCssPath() {
     try {
		return new File(STYLE_SHEET_ROOT+simplepath).toURI().toURL().toExternalForm();
	} catch (MalformedURLException e) {
	   LOGGER.error(()->"No Css style found for "+STYLE_SHEET_ROOT+simplepath);
	}
     return null;
  }
}
