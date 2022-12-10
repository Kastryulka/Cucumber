package elements;

import helpers.JavaScriptHelper;
import org.openqa.selenium.WebElement;

public class Block extends BaseElement {
    public Block(WebElement webElement) {
        super(webElement);
    }

    public void hide(){
        JavaScriptHelper.displayNone(webElement);
    }
}
