package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {


    /**
     * Элементы страницы
     */
    private final SelenideElement searchInput
            = $("#searchInput");
    private final SelenideElement searchValue
            = $(".searching-results__title");
    private final SelenideElement generalPreloader
            = $(".general-preloader");
    private final SelenideElement iconProfile
            = $(".j-main-login");
    private final SelenideElement buttonSupport
            = $(".j-btn-chat-open");
    private final SelenideElement modalWindowsChat
            = $(".j-chat-body");

    /**
     * Метод для ввода в поисковую строку значения и его поиска
     * @param value -значение которое неодходимо ввести в поисковую строку
     * @return ProductSearchResultsPage()
     */
    @Step
    public final ProductSearchResultsPage searchInput(String value) {
        generalPreloader.shouldBe(Condition.hidden, Duration.ofSeconds(10));
        waitAndClick(searchInput);
        searchInput.setValue(value).pressEnter();
        checkElementPresent("Строка с результатом поиска", searchValue);
        //searchValue.shouldBe(visible);
        searchValue.shouldHave(text("По запросу «" + value + "» найдено"));
        return new ProductSearchResultsPage();
    }

    /**
     *  Метод открытия профиля и проверки что на странице присутсвует форма авторизации
     * @return ProfilePage
     */
    @Step
    public final ProfilePage openProfile() {
        waitAndClick(iconProfile);
        checkElementPresent("форма авторизации", $("#spaAuthForm"));
        return new ProfilePage();
    }

    /**
     * Метод открытия openOnlineChat
     * @return MainPage
     */
    @Step
    public final MainPage openOnlineChat() {
        checkElementPresent("кнопка Онлайн чат", buttonSupport);
        waitAndClick(buttonSupport);
        checkElementPresent("модальное окно Онлайн чат", modalWindowsChat);
        return this;
    }
}