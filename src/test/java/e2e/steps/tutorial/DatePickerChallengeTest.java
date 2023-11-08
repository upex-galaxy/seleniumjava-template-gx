package e2e.steps.tutorial;

import java.io.IOException;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;

public class DatePickerChallengeTest extends TestBase {

    @BeforeEach
    public void gotodatePickerPage() {
        web.get("https://demo.testim.io");
    }

    private String getMonthTitle() {
        String monthHeader = get.Selector("span[class*=title]").getText();
        return monthHeader;
    }

    @Test
    @DisplayName("Take a Departing Date and Returning Date")
    public void datePicker() throws InterruptedException, IOException {
        WebElement departingDate = get.FilterByText("Departing", 2);
        WebElement departingDateInput = get.WithinElement(departingDate, "input");
        // Abrir DatePicker:
        Do.click(departingDateInput);

        // Seleccionar el Día:
        WebElement outDay = get.WithinTextElement("data-react-toolbox=\"day\"", "15");
        outDay.click();

        // Confirmar con OK:
        WebElement OkButton = get.WithinTextElement("data-react-toolbox=\"dialog\"", "Ok");
        Do.click(OkButton);

        Thread.sleep(1000);

        WebElement returningDate = get.FilterByText("Returning", 2);
        WebElement returningDateInput = get.WithinElement(returningDate, "input");
        // Abrir DatePicker:
        Do.click(returningDateInput);

        WebElement datePicker = get.ReactTool("dialog");
        WebElement nextMonthBtn = get.WithinElement(datePicker, "[id=right]");

        // Given ; When ITERATIVO; Then; .......... When BREAK
        String actualMonth;
        for (int i = 0; i < 12; i++) {

            Do.click(nextMonthBtn);
            Thread.sleep(500);
            actualMonth = getMonthTitle();

            if (actualMonth.contains("February")) {
                Do.screenshot();
                break;
            }
        }
        // Seleccionar el Día del mes Febrero:
        WebElement finalDay = get.WithinTextElement("data-react-toolbox=\"day\"", "21");
        Do.click(finalDay);

        // Confirmar con OK:
        WebElement OkButton2 = get.WithinTextElement("data-react-toolbox=\"dialog\"", "Ok");
        Do.click(OkButton2);
    }

}
