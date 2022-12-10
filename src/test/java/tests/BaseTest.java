package tests;

import drivers.WebDriverFactory;
import loggers.WebDiverLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDiverLogger listener;
    protected static Logger logger = LogManager.getLogger(BaseTest.class);
    protected static Actions actions;
    protected static WebDriverWait wait;
    protected static WebDriver decoratedDriver;
    protected String outputDir = "temp\\\\";

    @BeforeEach
    public void setUp() {
        String env = System.getProperty("browser", "chrome");
        String loadStrategy = System.getProperty("loadstrategy", "normal");
        String parameters = System.getProperty("params", "");
        if(parameters.startsWith("\"")&parameters.endsWith("\"")){
            parameters = parameters.substring(1,parameters.length()-1);
        }

        logger.info("env = " + env);
        logger.info("loadStrategy = " + loadStrategy);
        logger.info("params = " + parameters);

        Map<String, Object> prefs = new HashMap<String, Object>();
        //TODO конфигурирование prefs из параметров командной строки

        driver = WebDriverFactory.getDriver(env.toLowerCase(),loadStrategy.toUpperCase(),parameters.toLowerCase(),prefs);

        listener = new WebDiverLogger(driver);
        decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        actions = new Actions(decoratedDriver);

        logger.info("Драйвер стартовал!");
    }
    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

}
