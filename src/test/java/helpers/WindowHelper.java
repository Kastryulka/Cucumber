package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
    private static Logger logger = LogManager.getLogger(WindowHelper.class);
    private static WebDriver window;

    public static void init(WebDriver driver) {
        window = driver;
    }

    public static Dimension getWindowSize() {
        return window.manage().window().getSize();
    }
    public static void maximizeWindow(){
        window.manage().window().maximize();
    }
    public static String getWindowTitle(){
        return window.getTitle();
    }
}
