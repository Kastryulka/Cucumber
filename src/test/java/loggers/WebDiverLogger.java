package loggers;

import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverListener;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WebDiverLogger implements WebDriverListener {
    private String outputDir = "temp\\\\";
    private Logger logger = LogManager.getLogger(WebDiverLogger.class);
    WebDriver driver;

    public void setOutputDir(String outputDir){
        this.outputDir = outputDir;
    }

    public WebDiverLogger(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result){
        logger.info("Найден элемент");
        getScreenshotFull(driver,outputDir,"");
        JavaScriptHelper.scrollToTop();
    }
    @Override
    public void afterFindElements(WebDriver driver, By locator, List result){
        logger.info("Найдены элементы");
        getScreenshotFull(driver,outputDir,"");
        JavaScriptHelper.scrollToTop();
    }
    @Override
    public void afterGetText(WebElement element, String result){
        logger.info("Получен текст: " + result);
    }
    @Override
    public void beforeClick(WebElement element){
        logger.info("Предклик по элементу " + element.getText());
        getScreenshotElement(element,outputDir,element.getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
    @Override
    public void afterClick(WebElement element){
        logger.info("Клик по элементу " + element);
    }

    public void getScreenshotFull(WebDriver driver, String filePath, String fileName){
        try {
            if(new File(filePath).mkdirs()){
                logger.info("Создана директория " + filePath);
            }
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            if(fileName.isEmpty()) {
                fileName = System.currentTimeMillis() + driver.getTitle()
                        .trim()
                        .replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "");
            }
            ImageIO.write(screenshot.getImage(), "png", new File(filePath+fileName+".png"));
            logger.info("Скриншот сохранен в файле [" + filePath+fileName+".png]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getScreenshot(WebDriver driver, String filePath, String fileName){
        try {
            if(new File(filePath).mkdirs()){
                logger.info("Создана директория " + filePath);
            }
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            if(fileName.isEmpty()) {
                fileName = file.getName();
            }
            else {
                fileName = fileName+".png";
            }
            BufferedImage linkYesImage = ImageIO.read(file);
            ImageIO.write(linkYesImage, "png", new File(filePath+fileName));
            logger.info("Скриншот сохранен в файле [" + filePath+fileName+"]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getScreenshotElement(WebElement element, String filePath, String fileName){
        try {
            if(new File(filePath).mkdirs()){
                logger.info("Создана директория" + filePath);
            }
            File file = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
            if(fileName.isEmpty()) {
                fileName = file.getName();
            }
            else {
                fileName = fileName+".png";
            }
            BufferedImage linkYesImage = ImageIO.read(file);
            ImageIO.write(linkYesImage, "png", new File(filePath+fileName));
            logger.info("Скриншот сохранен в файле [" + filePath+fileName+"]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}