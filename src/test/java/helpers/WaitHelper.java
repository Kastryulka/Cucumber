package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
    private static Logger logger = LogManager.getLogger(WaitHelper.class);
    protected static WebDriverWait webDriverWait;

    public static void init(WebDriver driver, Duration timeout, Duration sleep) {
        webDriverWait = new WebDriverWait(driver,timeout,sleep);
    }

    public static void clickabilityOfElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public static void stalenessOfElement(WebElement webElement){
        webDriverWait.until(ExpectedConditions.stalenessOf(webElement));
    }
    public static void presenceOfElementLocated(By webElement) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(webElement));
    }
    public static void presenceOfManyLocated(By webElement) {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(webElement));
    }
    public static void visibilityOfElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void visibilityOfManyElements(List<WebElement> webElements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}
