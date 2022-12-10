package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.LaptopProductPageSteps;

import static org.apache.commons.lang3.StringUtils.contains;

public class ProductPageMatcher {
    protected static Logger logger = LogManager.getLogger(ProductPageMatcher.class);
    LaptopProductPageSteps page;

    public ProductPageMatcher(LaptopProductPageSteps page){
        this.page = page;
    }

    //Проверить, что заголовок страницы соответствует ожидаемому
    public void newWindowTitleIsCorrect(String expectedTitle){
        String actual = page.getPageTitle();
        logger.info("Заголовок новой страницы: " + actual);
        logger.info("Название продукта в списке: " + expectedTitle);
        Assertions.assertTrue(contains(actual,expectedTitle),"заголовок страницы не соответствует ожидаемому");
    }
    //Проверить, что в блоке Характеристики заголовок содержит ASUS
    public void characteristicsTitleIsCorrect(String expectedTitle){
        Assertions.assertTrue(contains(page.getcharacteristicsTitle().toUpperCase(),expectedTitle),"заголовок некорректный: не " + expectedTitle);
        logger.info("Заголовок в блоке Характеристики корректный: " + expectedTitle);
    }
    //Проверить, что в блоке Характеристики значение Объем оперативной памяти равно 32 ГБ
    public void characteristicsRamIsCorrect(String  expectedRamSize){
        Assertions.assertTrue(contains(page.getcharacteristicsRam().toUpperCase(),expectedRamSize), "Пункт ОЗУ в характеристиках некорректный: не " + expectedRamSize);
    }
}
