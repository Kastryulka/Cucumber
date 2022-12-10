package tests.thirdCase;

import org.junit.jupiter.api.Test;
import steps.*;
import tests.BaseTest;
import tests.matchers.ProductPageMatcher;

public class ThirdCaseTest extends BaseTest {
    //ожидаемые результаты
    String vendorName = "ASUS";
    String ramSize = "32";

    @Test
    public void firstStepTest(){
        outputDir = "temp\\\\ThirdCase_firstStepTest\\\\";
        listener.setOutputDir(outputDir);

        logger.info("Кейс 3, тест 1");
        LaptopsPageSteps laptopsPage = getLaptopsPage();
        String firstLaptopText = getFirstLaptopText(laptopsPage);
        LaptopProductPageSteps laptopProductPage = getLaptopProductPage(laptopsPage);

        ProductPageMatcher productPageMatcher = new ProductPageMatcher(laptopProductPage);
        productPageMatcher.newWindowTitleIsCorrect(firstLaptopText);
        logger.info("Заголовок страницы соответствует ожидаемому");
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        listener.getScreenshotFull(driver,outputDir,"Страница выбранного товара");
    }
    @Test
    public void secondStepTest(){
        outputDir = "temp\\\\ThirdCase_secondStepTest\\\\";
        listener.setOutputDir(outputDir);

        logger.info("Кейс 3, тест 2");
        LaptopsPageSteps laptopsPage = getLaptopsPage();
        LaptopProductPageSteps laptopProductPage = getLaptopProductPage(laptopsPage);


        //Проверить, что в блоке Характеристики заголовок содержит ASUS
        ProductPageMatcher productPageMatcher = new ProductPageMatcher(laptopProductPage);
        productPageMatcher.characteristicsTitleIsCorrect(vendorName);
        logger.info("Заголовок корректный: " + vendorName);
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        listener.getScreenshotFull(driver,outputDir,"Страница выбранного товара");
    }
    @Test
    public void thirdStepTest(){
        outputDir = "temp\\\\ThirdCase_thirdStepTest\\\\";
        listener.setOutputDir(outputDir);

        logger.info("Кейс 3, тест 3");
        LaptopsPageSteps laptopsPage = getLaptopsPage();
        LaptopProductPageSteps laptopProductPage = getLaptopProductPage(laptopsPage);

        //Проверить, что в блоке Характеристики заголовок содержит ASUS
        ProductPageMatcher productPageMatcher = new ProductPageMatcher(laptopProductPage);
        productPageMatcher.characteristicsRamIsCorrect(ramSize);
        logger.info("Пункт ОЗУ в характеристиках корректный: " + ramSize);
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        listener.getScreenshotFull(driver,outputDir,"Страница выбранного товара");
    }

    protected LaptopsPageSteps getLaptopsPage(){
        StartPageSteps startPage = new StartPageSteps(driver);
        startPage.confirmCity();
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        listener.getScreenshotFull(driver,outputDir,"Начальная страница DNS");
        startPage.scrollToTop();
        //Навестись на Компьютеры и периферия (пк, ноутбуки и периферия)
        startPage.focusOnComputersPeripherals();
        logger.info("Навелись на Пк,ноутбуки и периферия");
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        listener.getScreenshotFull(driver,outputDir,"Пк ноутбуки и периферия");
        startPage.scrollToTop();

        //Перейти по ссылке Ноутбуки
        startPage.focusOnComputersPeripherals();
        logger.info("Навелись на Пк,ноутбуки и периферия повторно");
        startPage.goToLaptopsPage();
        logger.info("Перешли по ссылке Ноутбуки");
        LaptopsPageSteps laptopsPage = new LaptopsPageSteps(driver);
        //Сделать скриншот всей страницы (с прокруткой) после загрузки страницы
        listener.getScreenshotFull(driver,outputDir,"Ноутбуки");

        //Скрыть блок страницы (заголовок)
        laptopsPage.hideHeader();
        logger.info("Заголовок страницы скрыт");
        //Сделать скриншот всей страницы (с прокруткой) после скрытия блока
        listener.getScreenshotFull(driver,outputDir,"Скрыт заголовок");

        //Выбрать в фильтре Производитель ASUS
        laptopsPage.filterByCompany(vendorName);
        logger.info("Выбрали вендора в фильтрах: " + vendorName);
        //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
        laptopsPage.filterByRam(ramSize);
        logger.info("Выбрали объем ОЗУ в фильтрах: " + ramSize + " Гб");
        laptopsPage.applyFilters();
        logger.info("Применили фильтры");
        //Сделать скриншот всей страницы (с прокруткой) после применения фильтров
        listener.getScreenshotFull(driver,outputDir,"Фильтры");
        //Применить сортировку Сначала дорогие
        String type = "Сначала дорогие";
        laptopsPage.orderBy(type);
        logger.info("Применили сортировку Сначала дорогие");
        //Сделать скриншот всей страницы (с прокруткой) после применения сортировки
        listener.getScreenshotFull(driver,outputDir,"Сортировка");
        return laptopsPage;
    }
    protected String getFirstLaptopText(LaptopsPageSteps laptopsPage){
        //готовим строки для сравнения...
        String firstLaptopText = laptopsPage.getFirstProductName();
        int indexEnd = firstLaptopText.indexOf("[");
        firstLaptopText = firstLaptopText.substring(0,indexEnd).trim();
        logger.info("Название первого продукта в списке: " + firstLaptopText);

        return firstLaptopText;
    }
    protected LaptopProductPageSteps getLaptopProductPage(LaptopsPageSteps laptopsPage){
        //Перейти на страницу первого продукта в списке в новом максимизированном окне
        //...переходим на следующую страницу
        laptopsPage.goToFirstProductPage();
        LaptopProductPageSteps laptopProductPageSteps = new LaptopProductPageSteps(driver);
        return laptopProductPageSteps;
    }
}
