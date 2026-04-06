package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormPage;

public class FormTest {

    @Test
    void positiveFormTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            FormPage form = new FormPage(driver);

            form.open()
                    .enterName("Anton")
                    .enterPassword("12345")
                    .selectMilk()
                    .selectCoffee()
                    .selectYellowColor()
                    .selectAutomationYes()
                    .enterEmail("test@example.com");

        } finally {
            driver.quit();
        }
    }

}
