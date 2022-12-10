package pages;

import elements.Title;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//страница Плиты электрические
public class ElectricStovesPage extends BasePage
{
    @FindBy(xpath = "//span[@class='products-count']")
    private WebElement titleProductsCount;

    public ElectricStovesPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Title productsCount(){
        return new Title(titleProductsCount);
    }
}
