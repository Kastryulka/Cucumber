package steps;

import org.openqa.selenium.WebDriver;
import pages.ElectricStovesPage;

public class ElectricStovesPageSteps {
    private ElectricStovesPage electricStovesPage;

    public ElectricStovesPageSteps(WebDriver driver) {
        electricStovesPage = new ElectricStovesPage(driver);
        //logger.info("Открыта страница Плиты электрические");
    }

    public int getProductsCount(){
        return Integer.parseInt(electricStovesPage
                .productsCount()
                .getText()
                .replaceAll("[^0-9]", ""));
    }
}
