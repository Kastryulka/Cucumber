package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import matchers.StartPageMatcher;
import web.drivers.WebDriverFactory;
import web.elements.Link;
import web.helpers.ActionHelper;
import web.helpers.WindowHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import web.pages.StartPage;

import java.util.List;

public class StartPageSteps {
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPage startPage;
    private List<Link> sublistCooking;

    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
        confirmCity();
    }
    @И ("Выведен в логи заголовок страницы, URL, размер окна")
    public void logPageInfo(){
        logger.info("Заголовок страницы - " + startPage.getPageTitle());
        logger.info("Текущий URL - " + startPage.getURL());
        logger.info(String.format("Ширина окна: %d", WindowHelper.getWindowSize().getWidth()));
        logger.info(String.format("Высота окна: %d", WindowHelper.getWindowSize().getHeight()));
    }
    @И ("Выполнен переход на страницу \"Бытовая техника\"")
    public void goToHouseholdAppliancesPage(){
        try{
            startPage.linkHouseholdAppliances().click();
        }
        catch (ElementClickInterceptedException e){
            confirmCity();
            startPage.linkHouseholdAppliances().click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Выполнен переход на страницу \"Бытовая техника\"");
    }
    @Когда ("Курсор наведен на ссылку \"Бытовая техника\"")
    public void focusOnHouseholdAppliances(){
        try{
            startPage.linkHouseholdAppliances().focusOnLink();
        }
        catch (ElementNotInteractableException e){
            confirmCity();
            startPage.linkHouseholdAppliances().focusOnLink();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Курсор наведен на ссылку \"Бытовая техника\"");
    }
    @Когда ("Курсор наведен на ссылку \"Плиты и печи\"")
    public void focusOnStoves(){
        try{
            startPage.linkStoves().focusOnLink();
        }
        catch (ElementNotInteractableException e){
            confirmCity();
            startPage.linkStoves().focusOnLink();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        sublistCooking = getSublistStoves();
        logger.info("Курсор наведен на ссылку \"Плиты и печи\"");
        logger.info(sublistCooking);
    }
    @Когда ("Курсор наведен на ссылку \"Компьютеры и периферия\"")
    public void focusOnComputersPeripherals(){
        try{
            startPage.linkComputersPeripherals().focusOnLink();
        }
        catch (ElementNotInteractableException e){
            confirmCity();
            startPage.linkComputersPeripherals().focusOnLink();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("Курсор наведен на ссылку \"Компьютеры и периферия\"");
    }
    @И ("Выполнен переход на страницу \"Плиты и печи\"")
    public void focusAndClickStoves(){
        focusOnStoves();
        startPage.linkStoves().click();
    }
    @И ("Выполнен переход на страницу \"Ноутбуки\"")
    public void goToLaptopsPage(){
        try{
            startPage.linkLaptops().click();
        }
        catch (ElementClickInterceptedException e){
            confirmCity();
            startPage.linkLaptops().click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Тогда ("Проверка: отображаются ссылки")
    public void sublistIsCorrect(List<String> testRefs){
        StartPageMatcher startPageMatcher = new StartPageMatcher(new StartPageSteps(WebDriverFactory.getCurrentDriver())); ///////@!!!!!!
        startPageMatcher.sublistIsCorrect(getSublistAppliances(),testRefs);
        logger.info("Необходимые ссылки отображаются");
    }
    @Тогда ("Проверка: в подменю отображается больше {int} ссылок")
    public void popupCountIsCorrect(Integer expectedCount){
        StartPageMatcher startPageMatcher = new StartPageMatcher(new StartPageSteps(WebDriverFactory.getCurrentDriver())); ///////@!!!!!!
        startPageMatcher.popupCountIsCorrect(sublistCooking.size(),expectedCount);
        logger.info("Необходимые ссылки отображаются");
    }

    // Конструктор
    public StartPageSteps() {}
    public StartPageSteps(WebDriver driver) {
        startPage = new StartPage(driver);
    }

    public List<Link> getSublistAppliances(){
        return startPage.sublistAppliances();
    }
    public List<Link> getSublistStoves(){
        return startPage.popupStoves();
    }
    //если появляется окно выбора города (может скрывать Бытовую технику), нажимаем на кнопку согласия
    public void confirmCity(){
        try{
            WebElement body = startPage.blockBody().getWebElement();
            startPage.buttonConfirmCity().click();
            logger.info("Согласились с выбором города");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void scrollToTop(){
        ActionHelper.scrollToElement(startPage.buttonSelectedCity().getWebElement());
    }
}
