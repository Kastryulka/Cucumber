package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.LaptopsPage;

public class LaptopsPageSteps {
    private LaptopsPage laptopsPage;
    private static Logger logger = LogManager.getLogger(LaptopsPageSteps.class);

    @Когда("Открыта страница \"Ноутбуки\"")
    public void openLaptopsPage(){
        laptopsPage = new LaptopsPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Ноутбуки]: Открыта страница \"Ноутбуки\"");
    }
    @И("Скрыт блок страницы")
    public void hideHeader(){
        laptopsPage.blockHeader().hide();
        logger.info("Скрыт блок страницы");
    }
    @И("В фильтре \"Производитель\" выбрано значение {string}")
    public void filterByCompany(String vendorName){
        laptopsPage.checkboxVendor(vendorName).setChecked(true);
        logger.info("В фильтре \"Производитель\" выбрано значение " + vendorName);
    }
    @И("В фильтре \"Объем оперативной памяти\" выбрано значение {string}")
    public void filterByRam(String ramSize){
        laptopsPage.accordeonRAM().show();
        logger.info("Развернули фильтр ОЗУ");
        laptopsPage.checkboxRAM(ramSize).setChecked(true);
        logger.info("В фильтре \"Объем оперативной памяти\" выбрано значение " + ramSize);
    }
    @И("Применены фильтры")
    public void applyFilters(){
        laptopsPage.buttonApply().click();
        logger.info("Применены фильтры");
    }
    @И("Установлена сортировка {string}")
    public void orderBy(String type){
        laptopsPage.accordeonSort().show();
        laptopsPage.radiobuttonSort(type).setSelected(true);
        logger.info("Установлена сортировка " + type);
    }
    @И("Выполнен переход на страницу первого продукта в списке")
    public void goToFirstProductPage(){
        laptopsPage.linkFirstProduct().openInNewWindow();
    }

    public LaptopsPageSteps() {}
    public LaptopsPageSteps(WebDriver driver) {
        laptopsPage = new LaptopsPage(driver);
    }

    public String getFirstProductName(){
        return laptopsPage.linkFirstProduct().getText();
    }
}
