package utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.chefmarket.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
    }
}