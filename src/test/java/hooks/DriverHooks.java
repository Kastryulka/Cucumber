package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.drivers.WebDriverFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverHooks {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    @Before
    public void startDriverBeforeScenario() {
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

        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        actions = new Actions(driver);

        logger.info("Драйвер стартовал!");
    }
    @After
    public void stopDriverAfterScenario() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

}
