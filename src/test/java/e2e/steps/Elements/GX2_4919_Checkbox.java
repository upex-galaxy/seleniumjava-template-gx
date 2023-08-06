package e2e.steps.Elements;

import e2e.fixtures.TestBase;
import e2e.page.GX2_4919_Checkbox_Page;
import java.util.List;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;

@RunWith(JUnit4.class)
public class GX2_4919_Checkbox extends TestBase {
    public GX2_4919_Checkbox_Page checkbox;

    @BeforeEach
    public void setup1() {
        web.get(baseUrl + "checkbox");
        checkbox = new GX2_4919_Checkbox_Page(web);
        String url = web.getCurrentUrl();
        then.shouldBeEqual(url, "https://demoqa.com/checkbox");
    }

    @DisplayName("4920 |TC1: Validar Funcionalidad de 'Expand All'")
    @Test
    public void TC01() throws InterruptedException {

        checkbox.ClickButtonExpandAll();

        boolean isDisplayed = checkbox.get.ElementDisplayCheckbox().isDisplayed();
        then.shouldBeTrue(isDisplayed);

    }

    @DisplayName("4920 |TC2: Validar Funcionalidad de 'Collapse All'")
    @Test
    public void TC02() throws InterruptedException {

        checkbox.ClickButtonColapseAll();

        boolean isDisplayed = checkbox.get.ElementNoDisplayCheckbox().isDisplayed();
        then.shouldBeTrue(isDisplayed);

    }

    @DisplayName("4920 |TC3: Validar Al clickear Home todas las carpetas y archivos sean iguales a los del resultado de mensaje")
    @Test
    public void TC03() throws InterruptedException {
        checkbox.ClickButtonExpandAll();
        checkbox.ClickButtonCheckedHome();
        List<String> Titles = checkbox.GetTextAllTitles();

        Thread.sleep(1000);
        String TxtResult = checkbox.GetMsjResultText();

        boolean checked = checkbox.ValidateListTitles_And_ListResult(TxtResult, Titles);
        then.shouldBeTrue(checked);
    }

    @DisplayName("4920 |TC4: Validar que al clickear en cualquier carpeta su checkbox cambie a 'checked'")
    @Test
    public void TC04() throws InterruptedException {
        WebElement ToElement = checkbox.get.ButtonCheckedHome();
        checkbox.ScrollTolink(ToElement);
        Thread.sleep(1000);
        checkbox.ClickButtonExpandAll();
        checkbox.ClickRandomPrincipalsubFolders();
        List<WebElement> allFolderAndFiles = checkbox.get.ElementValidateAllChecked();
        boolean checked = checkbox.ValidateAllCheckedButton(allFolderAndFiles);
        then.shouldBeTrue(checked);
    }
}
