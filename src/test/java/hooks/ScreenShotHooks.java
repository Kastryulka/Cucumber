package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import loggers.WebDiverLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;

public class ScreenShotHooks {
    // Логгер
    private Logger logger = LogManager.getLogger(ScreenShotHooks.class);
    private WebDiverLogger listener = new WebDiverLogger(WebDriverFactory.getCurrentDriver());;

    // Действия совершаемые перед каждым шагом
    @BeforeStep
    public void takeScreenShotBeforeStep(Scenario scenario) {
        listener.getScreenshot("temp\\\\"+scenario.getName()+"\\\\","");
    }
    // Действия совершаемые после каждого шага
    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        listener.getScreenshotFull("temp\\\\"+scenario.getName()+"\\\\","");
        JavaScriptHelper.scrollToTop();
    }
}
