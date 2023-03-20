import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.MainPage;

@Epic("example testsSuites")
public class WbTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("searchGoods")
    public void searchGoods() {
        mainPage.searchInput("джинсы")
                .openFilterSorter();
    }

    @Test
    @DisplayName("sortingByPriceAscending")
    public void sortingGoods() {
        mainPage.searchInput("джинсы")
                .openFilterSorter()
                .sortingByPriceAscending();
    }

    @Test
    @DisplayName("openProfile")
    public void openProfilePage() {
        mainPage.openProfile();
    }

    @Test
    @DisplayName("checkDisableButton 'get code'")
    public void checkDisableButton() {
        mainPage.openProfile()
                .checkDisableButton();
    }

    @Test
    @DisplayName("openOnlineChat")
    public void openOnlineChat() {
        mainPage.openOnlineChat();
    }

    @Test
    @DisplayName("Show notification after addItemsToBasket")
    public void addToBasket() {
        mainPage.searchInput("джинсы")
                .addItemsToBasket();
    }
}