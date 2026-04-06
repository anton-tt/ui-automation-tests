package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;

import java.time.Duration;

public class FormTest extends BaseTest {

    @Test
    void positiveFormTest() {
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
    }

}
