package e2e.steps.Navigation;

import e2e.fixtures.TestBase;
import e2e.pages.Lau.LoginPage;
import org.junit.jupiter.api.*;

public class LauBurguerMenuTest extends TestBase {
    @BeforeEach
    public void precondition() {
        // todo: login before each TC
        web.get(BASE_URL);
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.Login("standard_user", "secret_sauce");
        then.shouldContain(web.getCurrentUrl(),"/inventory");
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
    public void allItemsOption() {
        // todo: go to another page
        // todo: select all items option
        // todo: validate actual location equal PLP endpoint
    }

    @Test
    @DisplayName("TC2:Validate selection of 'About' on the burguer menu")
    public void aboutOption() {
        // todo: select about option
        // todo: validate location equal to the new page
    }

    @Test
    @DisplayName("TC3:Validate selection of 'Logout' on the burguer menu")
    public void logoutOption() {
        // todo: select logout opcion
        // todo: validate go back to login page
    }

    @Test
    @DisplayName("TC4:Validate selection of 'Reset App State' on the burguer menu")
    public void resetAppStateOption() {
        // todo: add products
        // todo: validate products on SC icon and SC
        // todo: select Reset App State
        // todo: validate reestar SC
    }

}
