package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

/**
 * Default test data class
 */

public class BasePage {
    @Step("Проверка наличия элемента - {0}")
    protected final void checkElementPresent(final String elementName,
                                             final SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(100));
    }
    @Step("Проверка наличия элемента и клик по нему")
    protected final void waitAndClick(SelenideElement element) {
        checkElementPresent("", element);
        element.click();
    }
}