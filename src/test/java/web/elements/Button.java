package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement{
    public Button(WebElement webElement){super(webElement);}

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
