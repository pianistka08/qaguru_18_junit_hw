package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.ChefMarketStartPage;
import utils.TestBase;
import data.Locale;
import java.util.List;
import java.util.stream.Stream;

public class ChefMarketTest extends TestBase {

    ChefMarketStartPage chefMarketStartPage = new ChefMarketStartPage();

    @ValueSource(strings = {
            "Русский", "English"
    })
    @ParameterizedTest(name = "на сайте выбран язык: {0}")
    void selectLanguageTest(String testData) {
        chefMarketStartPage.openPage();
        chefMarketStartPage.setSiteLanguage(testData);
    }

    @CsvSource(value = {
            "Русский, Меню",
            "English, Menu",
    })
    @ParameterizedTest(name = "на сайте выбран язык: {0} и отобразился текст: {1}")
    void startPageWithCSV(String testData, String expectedText) {
        chefMarketStartPage.openPage();
        chefMarketStartPage.setSiteLanguage(testData);
        chefMarketStartPage.checkTabLanguage(expectedText);
    }

    @CsvFileSource(resources = "/testdata/startPageWithCSVFile.csv")
    @ParameterizedTest(name = "на сайте выбран язык: {0} и отобразился текст: {1}, использован csv")
    void startPageWithCSVFile(String testData, String expectedText) {
        chefMarketStartPage.openPage();
        chefMarketStartPage.setSiteLanguage(testData);
        chefMarketStartPage.checkTabLanguage(expectedText);
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(Locale.RU.name(), List.of("Меню", "Как это работает", "Блог о вкусном")),
                Arguments.of(Locale.EN.name(), List.of("Menu", "How it works", "Blog about delicious"))
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "на сайте выбран язык: {0} , используется MethodSource")
    void startPageTestMethodSource(Locale locale, List<String> expectedNames) {
        chefMarketStartPage.openPage();
        chefMarketStartPage.setSiteLanguage(locale.getLocale());
        chefMarketStartPage.checkNamesTranslate(expectedNames);
    }
}