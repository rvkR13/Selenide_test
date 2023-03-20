package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductSearchResultsPage extends BasePage {
    /**
     * Элементы страницы
     */
    private final SelenideElement filterSorter
            = $(".dropdown-filter__btn--sorter");
    private final SelenideElement windowsFilterSorter
            = $(".filter__list");
    private final ElementsCollection advertCardItem
            = $$(".advert-card-item");
    private final SelenideElement buttonAddToBasket
            = $(".j-add-to-basket");
    private final SelenideElement popUp
            = $(".popup__content");
    private final ElementsCollection sizesList
            = $$(".sizes-list__size");
    private final SelenideElement notification
            = $(".action-notification__text");


    @Step
    public final ProductSearchResultsPage openFilterSorter() {
        filterSorter.shouldBe(visible, Duration.ofSeconds(2)).click();
        checkElementPresent("windowsFilterSorter",windowsFilterSorter);
        return this;
    }

    @Step
    public final ProductSearchResultsPage sortingByPriceAscending() {
        windowsFilterSorter.$(byText("По возрастанию цены")).click();
        return this;
    }

    @Step
    public final ProductSearchResultsPage addItemsToBasket() {
        advertCardItem.get(0).hover();
        waitAndClick(buttonAddToBasket);
        checkElementPresent("popUp",popUp);
        sizesList.get(0).click();
        notification
                .shouldHave(Condition.text("Товар добавлен в корзину"));
        return this;
    }
}