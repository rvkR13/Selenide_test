package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage {

    private final SelenideElement buttonGetCode
            = $("#requestCode");

    @Step
    public final ProfilePage checkDisableButton() {
        checkElementPresent("кнопка 'Получить код'", buttonGetCode);
        buttonGetCode.getAttribute("data-link").contains("toggle='disabled'");
        return this;
    }
}