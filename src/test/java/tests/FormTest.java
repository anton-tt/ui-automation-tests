package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.FormPage;


@Epic("UI тесты")
@Feature("Форма")
public class FormTest extends BaseTest {

    @Test
    @Story("Позитивное заполнение формы")
    void positiveFormTest() {
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
                .submitForm()
                .handleAlert();
    }

    @Test
    @Story("Негативное заполнение формы")
    void negativeFormTest() {
        FormPage form = new FormPage(driver);
        form.open()
                .handleNoAlert();
    }

}
