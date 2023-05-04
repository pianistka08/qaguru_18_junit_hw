package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ChefMarketStartPage {

    private SelenideElement languageMenu = $(".notranslate");
    private ElementsCollection startPageTabs = $$(".menu-item");

    public ChefMarketStartPage openPage() {
        open("/");

        return this;
    }

    public ChefMarketStartPage setSiteLanguage(String siteLanguage) {
        $(languageMenu).click();
        $(byText(siteLanguage)).click();

        return this;
    }

    public ChefMarketStartPage checkTabLanguage(String expectadText) {
        $$(".first-capital").filter(visible).shouldHave(CollectionCondition.itemWithText(expectadText));
        return this;
    }

    public ChefMarketStartPage checkNamesTranslate(List<String> expectedNames) {
        startPageTabs.shouldHave(texts(expectedNames));

        return this;
    }
}