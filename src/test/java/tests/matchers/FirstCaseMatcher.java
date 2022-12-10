package tests.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class FirstCaseMatcher {
    BasePage page;
    //ожидаемые результаты
    String householdAppliancesText = "Бытовая техника";
    String kitchenAppliancesText = "Техника для кухни";
    int subcategoriesCount =5;

    public FirstCaseMatcher(BasePage page){
        this.page = page;
    }

    //проверить, что в заголовке отображается текст "Бытовая техника"
    public void householdAppliancesTextIsDisplayed(WebElement element){
        textEquals(element,householdAppliancesText);
        Assertions.assertTrue(element.isDisplayed(), "Надпись \""+ householdAppliancesText +"\" в заголовке не отображена");
    }
    //проверить, что в заголовке отображается текст "Техника для кухни"
    public void kitchenAppliancesTextIsDisplayed(WebElement element){
        textEquals(element,kitchenAppliancesText);
        Assertions.assertTrue(element.isDisplayed(), "Надпись \""+ kitchenAppliancesText +"\" в заголовке не отображена");
    }
    //... проверить, что отображается ссылка Собрать свою кухню,...
    public void confLinkDisplayed(WebElement confBtn){
        Assertions.assertTrue(confBtn.isDisplayed(), "ссылка \"Собрать свою кухню\" не отображена");
    }
    //...проверить, что категорий больше пяти
    public void subcategoriesCountIsCorrect(List<Link> subcategories){
        Assertions.assertTrue(subcategories.size()>subcategoriesCount, "категорий меньше пяти");
    }

    public void textEquals(WebElement element, String expected){
        Assertions.assertEquals(expected, element.getText(), "В заголовке не " + expected);
    }
}
