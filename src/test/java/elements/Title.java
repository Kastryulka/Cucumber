package elements;

import org.openqa.selenium.WebElement;

public class Title extends BaseElement {
    public Title(WebElement webElement){super(webElement);}

    public String getText(){
        return webElement.getText();
    }
}
