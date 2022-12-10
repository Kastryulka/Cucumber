package pages;

import elements.Accordeon;
import elements.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//страница продукта Ноутбук
public class LaptopProductPage extends BasePage {
    @FindBy(xpath="//div[contains(@class,'product-card-description__title')]")
    private WebElement titleCharacteristicsTitle;
    @FindBy(xpath="//div[contains(@class,'product-characteristics__ovh') " +
            "and div[contains(text(),'Объем оперативной памяти')]]" +
            "/*[contains(@class,'product-characteristics__spec-value')]")
    private WebElement titleCharacteristicsRam;
    @FindBy(xpath = "//button[contains(@class,'product-characteristics__expand')]")
    private WebElement accordeonCharacteristics;

    public LaptopProductPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Title titleCharacteristicsTitle(){
        return new Title(titleCharacteristicsTitle);
    }
    public Title titleCharacteristicsRam(){
        return new Title(titleCharacteristicsRam);
    }
    public Accordeon accordeonCharacteristics(){
        return new Accordeon(accordeonCharacteristics);
    }
}
