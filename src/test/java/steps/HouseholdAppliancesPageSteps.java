package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import matchers.FirstCaseMatcher;
import web.drivers.WebDriverFactory;
import web.helpers.ActionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.pages.HouseholdAppliancesPage;

public class HouseholdAppliancesPageSteps {
    private static Logger logger = LogManager.getLogger(HouseholdAppliancesPageSteps.class);
    private HouseholdAppliancesPage householdAppliancesPage;

    @Когда("Открыта страница \"Бытовая техника\"")
    public void openHouseholdAppliancesPage(){
        householdAppliancesPage = new HouseholdAppliancesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Перешли в раздел Бытовая техника");
    }
    @И("Выполнен переход на страницу \"Техника для кухни\"")
    public void goToKitchenAppliances(){
        householdAppliancesPage.linkKitchenAppliances().click();
    }
    @Тогда("Проверка: на странице отображается текст \"Бытовая техника\"")
    public void textIsDisplayed(){
        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(householdAppliancesPage);
        firstCaseMatcher.householdAppliancesTextIsDisplayed(householdAppliancesPage.titleSubcategoryPage().getWebElement());
        logger.info("Надпись \"Бытовая техника\" в заголовке отображена");
    }

    // Конструктор
    public HouseholdAppliancesPageSteps() {}
    public HouseholdAppliancesPageSteps(WebDriver driver) {
        householdAppliancesPage = new HouseholdAppliancesPage(driver);
    }

    public void scrollToTop(){
        ActionHelper.scrollToElement(householdAppliancesPage.selectedCity().getWebElement());
    }
}
