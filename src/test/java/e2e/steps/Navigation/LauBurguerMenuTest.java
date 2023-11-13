package e2e.steps.Navigation;

import e2e.fixtures.TestBase;
import e2e.pages.Lau.LoginPage;
import e2e.pages.Lau.NavigationBar;
import e2e.pages.Lau.ProductListPage;
import e2e.pages.Lau.ShoppinCart;

import java.io.IOException;

import org.junit.jupiter.api.*;

public class LauBurguerMenuTest extends TestBase {
    private NavigationBar navBar;

    @BeforeEach
    public void precondition() throws InterruptedException, IOException {
        navBar = new NavigationBar(web, get, Do);
        LoginPage loginPage = new LoginPage(web, get, Do);
        // todo: login before each TC
        web.get(BASE_URL);

        loginPage.Login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        then.shouldContain(web.getCurrentUrl(), "/inventory");

    }

    // ?Suite
    // * TC1:Validate selection of All items option on the burguer menu
    // * TC2:Validate selection of About on the burguer menu
    // * TC3:Validate selection of Logout on the burguer menu
    // * TC4:Validate selection of Reset App State on the burguer menu

    // ?Required POMs
    // * login
    // * PLP -> Add products
    // * navigation bar -> burguer menu and SP icon
    // * SP (optional) -> validate added products
    @Test
    @DisplayName("TC1: Validate selection of 'All items' option on the burguer menu")
    public void allItemsOption() throws InterruptedException {
        Thread.sleep(1000);
        // todo: go to another page
        navBar.clickSCIcon();
        then.shouldContain(web.getCurrentUrl(), "/cart");
        // todo: select all items option
        navBar.selectMenuOption(0);
        // todo: validate actual location equal PLP endpoint
        then.shouldContain(web.getCurrentUrl(), "/inventory");
    }

    @Test
    @DisplayName("TC2:Validate selection of 'About' on the burguer menu")
    public void aboutOption() throws InterruptedException {
        // todo: select about option
        navBar.selectMenuOption(1);
        // todo: validate location equal to the new page
        then.shouldContain(web.getCurrentUrl(), "saucelabs.com");
    }

    @Test
    @DisplayName("TC3:Validate selection of 'Logout' on the burguer menu")
    public void logoutOption() throws InterruptedException {
        // todo: select logout opcion
        navBar.selectMenuOption(2);
        // todo: validate go back to login page
        then.shouldBeDifferent(web.getCurrentUrl(), "/inventory");
    }

    @Test
    @DisplayName("TC4:Validate selection of 'Reset App State' on the burguer menu")
    public void resetAppStateOption() throws InterruptedException {
        ProductListPage plp = new ProductListPage(get, Do);
        ShoppinCart sc = new ShoppinCart(get, Do);
        // todo: add products
        plp.AddRandomProducts();
        navBar.clickSCIcon();
        // todo: validate products on SC icon and SC
        // then.shouldBeEqualInt(qty, Integer.valueOf(navBar.getQtyItemsSC()));
        // todo: select Reset App State
        navBar.selectMenuOption(3);
        Thread.sleep(1000);
        // todo: validate reestar SC
        web.navigate().refresh();
        then.shouldBeEqualInt(sc.getQtyProducts(), 0);
        then.textShouldNotExist("class =\'shopping_cart_badge\'", web);
    }
}
