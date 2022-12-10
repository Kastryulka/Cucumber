package steps;

import elements.Link;
import helpers.ActionHelper;
import helpers.WindowHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import pages.StartPage;

import java.util.List;

public class StartPageSteps {
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPage startPage;

    // Конструктор
    public StartPageSteps(WebDriver driver) {
        startPage = new StartPage(driver);
        // Открыть сайт https://www.dns-shop.ru/
        startPage.openPage();
        logger.info("Открыта страница DNS - " + "https://www.dns-shop.ru/");
        logger.info("Заголовок страницы - " + startPage.getPageTitle());
        logger.info("Текущий URL - " + startPage.getURL());
        logger.info(String.format("Ширина окна: %d", WindowHelper.getWindowSize().getWidth()));
        logger.info(String.format("Высота окна: %d", WindowHelper.getWindowSize().getHeight()));
    }

    public List<Link> getSublistAppliances(){
        return startPage.sublistAppliances();
    }
    public List<Link> getSublistCooking(){
        return startPage.popupStoves();
    }
    //если появляется окно выбора города (может скрывать Бытовую технику), нажимаем на кнопку согласия
    public void confirmCity(){
        try{
            WebElement body = startPage.blockBody().getWebElement();
            startPage.buttonConfirmCity().click();
            logger.info("Согласились с выбором города");
            //WaitHelper.stalenessOfElement(body);
            //logger.info("Страница обновлена");
            //listener.getScreenshotFull(driver,outputDir,"Обновленная начальная страница");
            ActionHelper.scrollToElement(startPage.buttonSelectedCity().getWebElement());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
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
    }
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
    }
    public void focusOnCooking(){
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
    }
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
    }
    public void focusAndClickCooking(){
        focusOnCooking();
        startPage.linkStoves().click();
    }
    public void scrollToTop(){
        ActionHelper.scrollToElement(startPage.buttonSelectedCity().getWebElement());
    }
}
