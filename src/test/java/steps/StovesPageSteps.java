package steps;

import org.openqa.selenium.WebDriver;
import pages.StovesPage;

public class StovesPageSteps {
    private StovesPage stovesPage;

    public StovesPageSteps(WebDriver driver) {
        stovesPage = new StovesPage(driver);
        //logger.info("Открыта страница Плиты");
    }

    public void goToElectricStovesPage(){
        stovesPage.electricStovesLink().click();
        //logger.info("Перешли в раздел Плиты электрические");
    }
}
