package pages;


import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//страница Ноутбуки
public class LaptopsPage extends BasePage {
    @FindBy(xpath = "//header")
    private WebElement blockHeader;
    @FindBy(xpath = "//div[@data-id=\"brand\"]")
    private WebElement accordeonVendor;
    @FindBy(xpath = "//span[contains(text(),'Объем оперативной памяти')]")
    private WebElement accordeonRAM;
    @FindBy(xpath = "//div[contains(@class,'apply-filters-float-btn')]")
    private WebElement buttonApply;
    @FindBy(xpath = "//div[@class='top-filters']//div[@data-id='order']")
    private WebElement accordeonSort;
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]//span")
    private List<WebElement> radiobuttonSort;
    @FindBy(xpath = "//div[contains(@class,'catalog-products')][1]/div[contains(@class,'catalog-product')][1]/a[contains(@class,'catalog-product__name')]")
    private WebElement linkFirstProduct;

    public LaptopsPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    public Block blockHeader(){
        return new Block(blockHeader);
    }
    public CheckBox checkboxVendor(String vendorName){
        return new CheckBox(accordeonVendor.findElement(
                By.xpath("//div[@data-role='filters-container']" +
                        "//label[span[contains(text(), '" + vendorName + "')]]")));
    }
    public CheckBox checkboxRAM(String ramSize){
        return new CheckBox(driver.findElement(
                By.xpath("//label[span[contains(text(),'" + ramSize + "')]]")));
    }
    public Accordeon accordeonRAM(){
        return new Accordeon(accordeonRAM);
    }
    public Accordeon accordeonSort(){
        return new Accordeon(accordeonSort);
    }
    public RadioButton radiobuttonSort(String type){
        for (WebElement webElement : radiobuttonSort) {
            if(webElement.getText().contains(type)) {
                return new RadioButton(webElement);
            }
        }
        return null;
    }
    public Button buttonApply(){
        return new Button(buttonApply);
    }
    public Link linkFirstProduct() {
        return new Link(linkFirstProduct);
    }
}
