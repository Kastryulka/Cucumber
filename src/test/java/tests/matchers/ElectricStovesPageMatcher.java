package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import steps.ElectricStovesPageSteps;

public class ElectricStovesPageMatcher {
    protected static Logger logger = LogManager.getLogger(StartPageMatcher.class);
    ElectricStovesPageSteps page;


    public ElectricStovesPageMatcher(ElectricStovesPageSteps page){
        this.page = page;
    }

    //... проверить, что в заголовке количество товаров больше ста
    public void productsCountIsCorrect(int actualCount,int expectedCount){
        Assertions.assertTrue(actualCount>expectedCount, "товаров меньше " + expectedCount);
    }
}
