package tests.secondCase;

import elements.Link;
import org.junit.jupiter.api.Test;
import steps.ElectricStovesPageSteps;
import steps.StartPageSteps;
import steps.StovesPageSteps;
import tests.BaseTest;
import tests.matchers.ElectricStovesPageMatcher;
import tests.matchers.StartPageMatcher;

import java.util.ArrayList;
import java.util.List;

public class SecondCaseTest extends BaseTest {
    //ожидаемые результаты
    ArrayList<String> testRefs = new ArrayList<String>();
    int productsCountExpected = 100;
    int popupCookingCountExpected = 5;
    @Test
    public void firstStepTest(){
        outputDir = "temp\\\\SecondCase_firstStepTest\\\\";
        listener.setOutputDir(outputDir);
        testRefs.add("Техника для кухни");
        testRefs.add("Техника для дома");
        testRefs.add("Встраиваемая техника");

        logger.info("Кейс 2, тест 1");
        StartPageSteps startPage = getStartPage();

        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        startPageMatcher.sublistIsCorrect(startPage.getSublistAppliances(),testRefs);
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Бытовая техника");
        logger.info("Необходимые ссылки отображаются");
    }
    @Test
    public void secondStepTest(){
        outputDir = "temp\\\\SecondCase_secondStepTest\\\\";
        listener.setOutputDir(outputDir);

        logger.info("Кейс 2, тест 2");
        StartPageSteps startPage = getStartPage();
        List<Link> sublistCooking = getSublicstCooking(startPage);
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Плиты и печи");

        //... проверить, что ссылок больше пяти
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        startPageMatcher.popupCountIsCorrect(sublistCooking.size(),popupCookingCountExpected);
        listener.getScreenshotFull(driver,outputDir,"Элементы меню Бытовая техника");
        logger.info("Необходимые ссылки отображаются");
    }
    @Test
    public void thirdStepTest(){
        outputDir = "temp\\\\SecondCase_thirdStepTest\\\\";
        listener.setOutputDir(outputDir);

        logger.info("Кейс 2, тест 3");
        ElectricStovesPageSteps electricStovesPage = ThirdStep();
        int value = electricStovesPage.getProductsCount();
        logger.info("Количество товаров: " + value);

        //... проверить, что в заголовке количество товаров больше ста
        ElectricStovesPageMatcher electricStovesPageMatcher = new ElectricStovesPageMatcher(electricStovesPage);
        electricStovesPageMatcher.productsCountIsCorrect(value,productsCountExpected);
    }


    protected StartPageSteps getStartPage(){
        StartPageSteps startPage = new StartPageSteps(driver);
        startPage.confirmCity();
        listener.getScreenshotFull(driver,outputDir,"Начальная страница DNS");
        startPage.scrollToTop();
        //Навести курсор на ссылку Бытовая техника, проверить, что отображаются ссылки
        startPage.focusOnHouseholdAppliances();
        return startPage;
    }
    protected List<Link> getSublicstCooking(StartPageSteps startPage){
        //Навестись на приготовление пищи... проверить количество ссылок в подменю
        startPage.focusOnCooking();
        logger.info("Открыто подменю Плиты и печи");
        logger.info("Количество элементов подменю: " + startPage.getSublistCooking().size());
        return startPage.getSublistCooking();
    }
    protected ElectricStovesPageSteps ThirdStep(){
        StartPageSteps startPage = getStartPage();
        //Навестись и перейти в плиты, ...
        startPage.focusOnHouseholdAppliances();
        startPage.focusAndClickCooking();
        logger.info("Перешли в раздел Плиты");
        listener.getScreenshotFull(driver,outputDir,"Плиты");
        startPage.scrollToTop();
        //...перейти в электрические плиты...
        StovesPageSteps stovesPageSteps = new StovesPageSteps(driver);
        stovesPageSteps.goToElectricStovesPage();
        logger.info("Перешли в раздел Плиты электрические");
        ElectricStovesPageSteps electricStovesPage = new ElectricStovesPageSteps(driver);
        listener.getScreenshotFull(driver,outputDir,"Электрические плиты");
        return electricStovesPage;
    }
}
