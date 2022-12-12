package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;
import web.pages.StovesPage;

public class StovesPageSteps {
    private StovesPage stovesPage;
    private static Logger logger = LogManager.getLogger(StovesPageSteps.class);

    @И("Открыта страница \"Плиты и печи\"")
    public void openStovesPage(){
        stovesPage = new StovesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Плиты и печи]: Открыта страница \"Плиты и печи\"");
    }
    @Когда("Выполнен переход на страницу \"Плиты электрические\"")
    public void goToElectricStovesPage(){
        stovesPage.electricStovesLink().click();
        logger.info("Перешли в раздел Плиты электрические");
    }

    public StovesPageSteps() {}
    public StovesPageSteps(WebDriver driver) {
        stovesPage = new StovesPage(driver);
    }

}
