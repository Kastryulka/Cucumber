package pages;

import helpers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        ActionHelper.init(driver);
        WindowHelper.init(driver);
        WaitHelper.init(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        JavaScriptHelper.init(driver);
        NavigationHelper.init(driver);
        SwitchHelper.init(driver);
    }

    // Получение заголовка текущей страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }
}
