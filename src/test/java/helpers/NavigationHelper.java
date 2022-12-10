package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private static Logger logger = LogManager.getLogger(NavigationHelper.class);
    private static WebDriver navigation;

    public static void init(WebDriver driver) {
        navigation = driver;
    }

    public static void navigateTo(String URL) {
        navigation.navigate().to(URL);
    }
}
