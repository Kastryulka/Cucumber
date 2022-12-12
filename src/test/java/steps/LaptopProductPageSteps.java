package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import matchers.ProductPageMatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.pages.LaptopProductPage;
import web.pages.LaptopsPage;

import java.util.ArrayList;
import java.util.Set;

public class LaptopProductPageSteps {
    private static Logger logger = LogManager.getLogger(LaptopProductPageSteps.class);
    private LaptopProductPage laptopProductPage;

    @Когда("Открыта страница \"Продукт. Ноутбук\"")
    public void openLaptopsPage(){
        laptopProductPage = new LaptopProductPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Продукт. Ноутбук]: Открыта страница \"Продукт. Ноутбук\"");
    }
    @Тогда("Проверка: В блоке Характеристики заголовок содержит {string}")
    public void characteristicsTitleIsCorrect(String vendorName){
        ProductPageMatcher productPageMatcher = new ProductPageMatcher(new LaptopProductPageSteps(WebDriverFactory.getCurrentDriver()));
        productPageMatcher.characteristicsTitleIsCorrect(vendorName);
        logger.info("Заголовок корректный: " + vendorName);
    }
    @Тогда("Проверка: В блоке Характеристики значение Объем оперативной памяти равно {string}")
    public void characteristicsRamIsCorrect(String ramSize){
        ProductPageMatcher productPageMatcher = new ProductPageMatcher(new LaptopProductPageSteps(WebDriverFactory.getCurrentDriver()));
        productPageMatcher.characteristicsRamIsCorrect(ramSize);
        logger.info("Пункт ОЗУ в характеристиках корректный: " + ramSize);
    }
    @Тогда("Проверка: Заголовок страницы \"Продукт. Ноутбук\" соответствует названию продукта на предыдущей странице")
    public void newWindowTitleIsCorrect(){
        ArrayList tabs2 = new ArrayList<String>(WebDriverFactory.getCurrentDriver().getWindowHandles());
        WebDriverFactory.getCurrentDriver().switchTo().window((String) tabs2.get(0));
        LaptopsPageSteps laptopsPage = new LaptopsPageSteps(WebDriverFactory.getCurrentDriver());
        String firstLaptopText = laptopsPage.getFirstProductName();
        int indexEnd = firstLaptopText.indexOf("[");
        firstLaptopText = firstLaptopText.substring(0,indexEnd).trim();
        WebDriverFactory.getCurrentDriver().switchTo().window((String) tabs2.get(1));

        ProductPageMatcher productPageMatcher = new ProductPageMatcher(new LaptopProductPageSteps(WebDriverFactory.getCurrentDriver()));
        productPageMatcher.newWindowTitleIsCorrect(firstLaptopText);
        logger.info("Заголовок страницы соответствует ожидаемому");
    }

    public LaptopProductPageSteps() {}
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
    public String getCharacteristicsRam(){
        showAllCharacteristics();
        return laptopProductPage.titleCharacteristicsRam().getText();
    }

}
