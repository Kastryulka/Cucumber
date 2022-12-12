package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import matchers.ElectricStovesPageMatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.ElectricStovesPage;

public class ElectricStovesPageSteps {
    private ElectricStovesPage electricStovesPage;
    private static Logger logger = LogManager.getLogger(ElectricStovesPage.class);

    @Когда("Открыта страница \"Плиты электрические\"")
    public void openElectricStovesPage(){
        electricStovesPage = new ElectricStovesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Плиты и печи]: Открыта страница \"Плиты и печи\"");
    }
    @Тогда("Проверка: в тексте заголовка отображается количество товаров больше {int}")
    public void CountIsCorrect(Integer expectedCount){
        ElectricStovesPageMatcher electricStovesPageMatcher = new ElectricStovesPageMatcher(new ElectricStovesPageSteps(WebDriverFactory.getCurrentDriver()));
        electricStovesPageMatcher.productsCountIsCorrect(getProductsCount(),expectedCount);
    }

    public ElectricStovesPageSteps() {}
    public ElectricStovesPageSteps(WebDriver driver) {
        electricStovesPage = new ElectricStovesPage(driver);
    }

    public int getProductsCount(){
        return Integer.parseInt(electricStovesPage
                .productsCount()
                .getText()
                .replaceAll("[^0-9]", ""));
    }
}
