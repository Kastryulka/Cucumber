package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class SwitchHelper {
    private static Logger logger = LogManager.getLogger(SwitchHelper.class);
    private static WebDriver switcher;

    public static void init(WebDriver driver) {
        switcher = driver;
    }

    public static void switchToExistWindow(String window) {
        switcher.switchTo().window(window);
    }
    public static void switchToNewWindow() {
        switcher.switchTo().newWindow(WindowType.WINDOW);
    }
}
