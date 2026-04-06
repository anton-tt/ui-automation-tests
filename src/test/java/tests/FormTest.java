package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;

import java.time.Duration;

public class FormTest {

    @Test
    void positiveFormTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            FormPage form = new FormPage(driver);
            String[] tools = {"Selenium", "WebDriverManager", "JUnit", "Maven"};
            form.open()
                    .enterName("Anton")
                    .enterPassword("12345")
                    .selectMilk()
                    .selectCoffee()
                    .selectYellowColor()
                    .selectAutomationYes()
                    .enterEmail("test@example.com")
                    .enterMessageWithTools(tools)
                    .submitForm();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            Assertions.assertEquals("Message received!", alert.getText());
            alert.accept();

        } finally {
            driver.quit();
        }
    }

}
