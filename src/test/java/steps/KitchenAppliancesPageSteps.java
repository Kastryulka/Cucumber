package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import matchers.FirstCaseMatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.drivers.WebDriverFactory;
import web.elements.Link;
import web.pages.KitchenAppliancesPage;

import java.util.List;

public class KitchenAppliancesPageSteps {
    private static Logger logger = LogManager.getLogger(KitchenAppliancesPageSteps.class);
    private KitchenAppliancesPage kitchenAppliancesPage;

    @Когда("Открыта страница \"Техника для кухни\"")
    public void openKitchenAppliancesPage(){
        kitchenAppliancesPage = new KitchenAppliancesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Техника для кухни]: Открыта \"Техника для кухни\"");
    }
    @И("В логи выведены названия всех категорий")
    public void logSubcategories(){
        List<Link> subcategories= kitchenAppliancesPage.listSubcategories();
        for(Link elem : subcategories){
            logger.info("-" + elem.getText());
        }
    }
    @Тогда("Проверка: на странице отображается текст \"Техника для кухни\"")
    public void textIsDisplayed(){
        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(kitchenAppliancesPage);
        firstCaseMatcher.kitchenAppliancesTextIsDisplayed(kitchenAppliancesPage.titleSubcategoryPage().getWebElement());
        logger.info("Надпись \"Техника для кухни\" в заголовке отображена");
    }
    @Тогда("Проверка: на странице отображается ссылка \"Собрать свою кухню\"")
    public void confLinkDisplayed(){
        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(kitchenAppliancesPage);
        firstCaseMatcher.confLinkDisplayed(kitchenAppliancesPage.buttonConfiguration().getWebElement());
        logger.info("Ссылка \"Собрать свою кухню\" отображена");
    }
    @Тогда("Проверка: на странице отображается больше {int} категорий")
    public void subcategoriesCountIsCorrect(Integer expectedCount){
        FirstCaseMatcher firstCaseMatcher = new FirstCaseMatcher(kitchenAppliancesPage);
        firstCaseMatcher.subcategoriesCountIsCorrect(kitchenAppliancesPage.listSubcategories(), expectedCount);
        logger.info("Категорий больше пяти");
    }

}
