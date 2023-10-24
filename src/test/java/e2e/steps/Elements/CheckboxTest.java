package e2e.steps.Elements;

import e2e.fixtures.TestBase;
import e2e.page.ExampleCheckboxPage;
import java.util.List;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

@Disabled("Flaky Test, needs review")
public class CheckboxTest extends TestBase {
    public ExampleCheckboxPage checkboxPage;

    @BeforeEach
    public void setup1() {
        web.get(BASE_URL + "/checkbox");
        checkboxPage = new ExampleCheckboxPage(web);
        String url = web.getCurrentUrl();
        then.shouldBeEqual(url, "https://demoqa.com/checkbox");
    }

    @DisplayName("4920 |TC1: Validar Funcionalidad de 'Expand All'")
    @Test
    public void TC01() throws InterruptedException {

        checkboxPage.ClickButtonExpandAll();

        boolean isDisplayed = checkboxPage.get.ElementDisplayCheckbox().isDisplayed();
        then.shouldBeTrue(isDisplayed);

    }

    @DisplayName("4920 |TC2: Validar Funcionalidad de 'Collapse All'")
    @Test
    public void TC02() throws InterruptedException {

        checkboxPage.ClickButtonColapseAll();

        boolean isDisplayed = checkboxPage.get.ElementNoDisplayCheckbox().isDisplayed();
        then.shouldBeTrue(isDisplayed);

    }

    @DisplayName("4920 |TC3: Validar Al clickear Home todas las carpetas y archivos sean iguales a los del resultado de mensaje")
    @Test
    public void TC03() throws InterruptedException {
        checkboxPage.ClickButtonExpandAll();
        checkboxPage.ClickButtonCheckedHome();
        List<String> Titles = checkboxPage.GetTextAllTitles();

        Thread.sleep(1000);
        String TxtResult = checkboxPage.GetMsjResultText();

        boolean checked = checkboxPage.ValidateListTitles_And_ListResult(TxtResult, Titles);
        then.shouldBeTrue(checked);
    }

    @DisplayName("4920 |TC4: Validar que al clickear en cualquier carpeta su checkbox cambie a 'checked'")
    @Test
    public void TC04() throws InterruptedException {
        WebElement ToElement = checkboxPage.get.ButtonCheckedHome();
        checkboxPage.ScrollTolink(ToElement);
        Thread.sleep(1000);
        checkboxPage.ClickButtonExpandAll();
        checkboxPage.ClickRandomPrincipalsubFolders();
        List<WebElement> allFolderAndFiles = checkboxPage.get.ElementValidateAllChecked();
        boolean checked = checkboxPage.ValidateAllCheckedButton(allFolderAndFiles);
        then.shouldBeTrue(checked);
    }
}
