package elements;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Accordeon extends BaseElement{

    public Accordeon(WebElement webElement) {
        super(webElement);
    }

    public void show() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
