package pages;

import elements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//страница Плиты и печи
public class StovesPage extends BasePage {
    @FindBy(xpath="//a[contains(@class,'subcategory__item')]//span[text()='Плиты электрические']")
    private WebElement electricStovesLink;

    public StovesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Link electricStovesLink(){
        return new Link(electricStovesLink);
    }
}
