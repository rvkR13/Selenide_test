package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        open("https://www.wildberries.ru/");
    }

    @AfterEach
    public void after() {
        closeWebDriver();
    }
}
