package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    private static Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    private static JavascriptExecutor javascriptExecutor;

    public static void init(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public static void displayNone(WebElement webElement){
        String script = "arguments[0].style.display='none';";
        javascriptExecutor.executeScript(script, webElement);}
    public static void scrollToTop(){
        String script = "window.scrollTo(0, 0);";
        javascriptExecutor.executeScript(script);
    }
}
