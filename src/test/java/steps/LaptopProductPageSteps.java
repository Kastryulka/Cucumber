package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LaptopProductPage;

public class LaptopProductPageSteps {
    private static Logger logger = LogManager.getLogger(LaptopProductPageSteps.class);
    private LaptopProductPage laptopProductPage;

    public LaptopProductPageSteps(WebDriver driver) {
        laptopProductPage = new LaptopProductPage(driver);
        logger.info("");
    }

    public String getPageTitle() {
        logger.info("");
        return laptopProductPage.getPageTitle();
    }
    public String getcharacteristicsTitle(){
        return laptopProductPage.titleCharacteristicsTitle().getText();
    }
    public void showAllCharacteristics(){
        laptopProductPage.accordeonCharacteristics().show();
        logger.info("Развернули список характеристик");
    }
    public String getcharacteristicsRam(){
        showAllCharacteristics();
        return laptopProductPage.titleCharacteristicsRam().getText();
    }

}
