package pages;

import elements.*;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

//начальная страница
public class StartPage extends BasePage {
    private Logger logger = LogManager.getLogger(StartPage.class);
    private final String URL = "https://www.dns-shop.ru/";

    @FindBy(xpath = "//button[contains(@class,'v-confirm-city__btn')]")
    private WebElement buttonConfirmCity;
    @FindBy(xpath="//body[1]")
    private WebElement blockBody;
    @FindBy(xpath="//*[contains(@class,'city-select__text')]")
    private WebElement buttonSelectedCity;
    @FindBy(xpath="//a[contains(@class ,'menu-desktop__root-title') and text()='Бытовая техника']")
    private WebElement linkHouseholdAppliances;
    @FindBy(xpath="//a[contains(@class ,'menu-desktop__root-title') and text()='Бытовая техника']//ancestor::div[@class='menu-desktop__root']//div[contains(@class ,'menu-desktop__submenu_top')]/a")
    private List<WebElement> sublistAppliances;
    @FindBy(xpath="//a[@class='ui-link menu-desktop__second-level' and text()='Плиты и печи']")
    private WebElement linkStoves;
    @FindBy(xpath="//a[@class='ui-link menu-desktop__second-level' and text()='Плиты и печи']/span[@class='menu-desktop__popup']/a")
    private List<WebElement> popupStoves;
    @FindBy(xpath="//a[contains(@class,'menu-desktop__root-title') and contains(text(),'периферия')]")
    private WebElement linkComputersPeripherals;
    @FindBy(xpath="//a[contains(@class,'menu-desktop__second-level') and contains(text(),'Ноутбуки')]")
    private WebElement linkLaptops;

    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return this.URL;
    }
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }
    public Button buttonConfirmCity() {
        return new Button(buttonConfirmCity);
    }
    public Button buttonSelectedCity() {
        return new Button(buttonSelectedCity);
    }
    public Link linkHouseholdAppliances() {
        return new Link(linkHouseholdAppliances);
    }
    public Link linkStoves() {
        return new Link(linkStoves);
    }
    public Link linkComputersPeripherals(){
        return new Link(linkComputersPeripherals);
    }
    public Link linkLaptops(){
        return new Link(linkLaptops);
    }
    public List<Link> sublistAppliances() {
        WaitHelper.visibilityOfManyElements(sublistAppliances);
        List<WebElement> elementsList = sublistAppliances;
        List<Link> linksList = new ArrayList<Link>();
        elementsList.forEach(webElement -> linksList.add(new Link(webElement)));
        return linksList;
    }
    public List<Link> popupStoves() {
        WaitHelper.visibilityOfManyElements(popupStoves);
        List<WebElement> elementsList = popupStoves;
        List<Link> linksList = new ArrayList<Link>();
        elementsList.forEach(webElement -> linksList.add(new Link(webElement)));
        return linksList;
    }
    public Block blockBody(){
        return new Block(blockBody);
    }
}
