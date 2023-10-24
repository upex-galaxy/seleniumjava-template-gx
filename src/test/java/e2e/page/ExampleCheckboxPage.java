package e2e.page;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExampleCheckboxPage {
    public Get get;
    private WebDriver driver;

    public ExampleCheckboxPage(WebDriver driver) {
        this.get = new Get();
        this.driver = driver;
    }

    public class Get {
        public WebElement ButtonExpandAll() {
            return driver.findElement(By.cssSelector("[class$='icon-expand-all']"));
        }

        public WebElement ButtonCollapseAll() {
            return driver.findElement(By.cssSelector("[title='Collapse all']"));
        }

        public WebElement ElementDisplayCheckbox() {
            return driver.findElement(By.cssSelector("[class*='rct-node-expanded'] [for$='home']"));
        }

        public WebElement ElementNoDisplayCheckbox() {
            return driver.findElement(By.cssSelector("[class*='rct-node-collapsed']"));
        }

        public WebElement MsjElementResult() {
            return driver.findElement(By.cssSelector("[id='result']"));
        }

        public List<WebElement> AllTitles() {
            return driver.findElements(By.cssSelector("[class='rct-title']"));
        }

        public WebElement ButtonCheckedHome() {
            return driver.findElement(By.cssSelector("[for='tree-node-home']"));
        }

        public List<WebElement> ElementValidateAllChecked() {
            return driver.findElements(
                    By.cssSelector("[class='rct-text'] [class='rct-checkbox'] svg.rct-icon.rct-icon-check"));
        }

        public List<WebElement> HomeChildrenFolders() {
            return driver.findElements(By.cssSelector(
                    "[class$='fa4'] > ol > [class$='expanded'] > ol >[class*='rct-node-parent'] > [class='rct-text'] [class='rct-checkbox']"));
        }

    }

    public void ClickButtonExpandAll() {
        get.ButtonExpandAll().click();
    }

    public void ClickButtonColapseAll() {
        get.ButtonCollapseAll().click();
    }

    public List<String> GetTextAllTitles() {
        List<WebElement> titles = get.AllTitles();
        List<String> TextTiltes = new ArrayList<>();
        for (WebElement title : titles) {
            TextTiltes.add(title.getText().toLowerCase());
        }
        return TextTiltes;
    }

    public String GetMsjResultText() {
        return get.MsjElementResult().getText();
    }

    public void ClickButtonCheckedHome() {
        get.ButtonCheckedHome().click();
    }

    public boolean ValidateAllCheckedButton(List<WebElement> checkboxes) {
        for (int i = 0; i < checkboxes.size(); i++) {
            List<WebElement> refreshedCheckboxes = get.ElementValidateAllChecked();
            WebElement checkbox = refreshedCheckboxes.get(i);
            if (checkbox.getAttribute("class").equals("rct-icon rct-icon-check")) {
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean ValidateListTitles_And_ListResult(String TxtResult, List<String> Titles) {
        boolean titlesMatch = false;

        String selectedText = TxtResult.substring("You have selected :".length());
        String[] selectedTitles = selectedText.trim().split("\n");

        List<String> sanitizedTitles = new ArrayList<>();
        for (String title : Titles) {
            sanitizedTitles.add(title.replace(" ", "").replace(".", "").replace("filedoc", "File"));
        }
        List<String> sanitizedSelectedTitles = new ArrayList<>();
        for (String selectedTitle : selectedTitles) {
            sanitizedSelectedTitles.add(selectedTitle);
        }
        titlesMatch = sanitizedSelectedTitles.containsAll(sanitizedTitles);

        return titlesMatch;
    }

    public void ClickRandomPrincipalsubFolders() {
        List<WebElement> foldersChildren = get.HomeChildrenFolders();
        Random random = new Random();
        int indexRandom = random.nextInt(foldersChildren.size());
        foldersChildren.get(indexRandom).click();
    }

    public void ScrollTolink(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
