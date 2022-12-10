package steps;

import helpers.ActionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HouseholdAppliancesPage;

public class HouseholdAppliancesPageSteps {
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private HouseholdAppliancesPage householdAppliancesPage;

    // Конструктор
    public HouseholdAppliancesPageSteps(WebDriver driver) {
        householdAppliancesPage = new HouseholdAppliancesPage(driver);
    }

    public void goToKitchenAppliances(){
        householdAppliancesPage.linkKitchenAppliances().click();
    }
    public void scrollToTop(){
        ActionHelper.scrollToElement(householdAppliancesPage.selectedCity().getWebElement());
    }
}
