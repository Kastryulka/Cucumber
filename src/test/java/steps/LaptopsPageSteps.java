package steps;

import org.openqa.selenium.WebDriver;
import pages.LaptopsPage;

public class LaptopsPageSteps {
    LaptopsPage laptopsPage;

    public LaptopsPageSteps(WebDriver driver) {
        laptopsPage = new LaptopsPage(driver);
    }

    public void hideHeader(){
        laptopsPage.blockHeader().hide();
    }
    public void filterByCompany(String vendorName){
        laptopsPage.checkboxVendor(vendorName).setChecked(true);
    }
    public void filterByRam(String ramSize){
        laptopsPage.accordeonRAM().show();
        //logger.info("Развернули фильтр ОЗУ");
        laptopsPage.checkboxRAM(ramSize + " ГБ").setChecked(true);

    }
    //... применить фильтр
    public void applyFilters(){
        laptopsPage.buttonApply().click();
    }
    public void orderBy(String type){
        laptopsPage.accordeonSort().show();
        laptopsPage.radiobuttonSort(type).setSelected(true);
    }
    public void goToFirstProductPage(){
        laptopsPage.linkFirstProduct().openInNewWindow();
    }
    public String getFirstProductName(){
        return laptopsPage.linkFirstProduct().getText();
    }
}
