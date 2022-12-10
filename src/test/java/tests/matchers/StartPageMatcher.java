package tests.matchers;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.StartPageSteps;

import java.util.List;

public class StartPageMatcher {
    protected static Logger logger = LogManager.getLogger(StartPageMatcher.class);
    StartPageSteps page;


    public StartPageMatcher(StartPageSteps page){
        this.page = page;
    }

    //проверить, что отображаются ссылки, если навестись на Бытовая техника
    public void sublistIsCorrect(List<Link> actualSublict, List<String> expectedList){
        Assertions.assertEquals(expectedList.size(), actualSublict.size(), "количество ссылок не соответствует ожидаемому");
        for(Link elem : actualSublict){
            Assertions.assertTrue(expectedList.contains(elem.getText()), "элемент отсутствует среди ссылок");
            Assertions.assertTrue(elem.getWebElement().isDisplayed(), "не отображается элемент в разделе Бытовая техника");
        }}
    //... проверить, что ссылок больше пяти
    public void popupCountIsCorrect(int actualCount,int expectedCount){
        Assertions.assertTrue(actualCount>expectedCount, "Плиты и печи меньше " + expectedCount);
    }
}
