package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    private WebDriver driver;

    private WebDriverWait wait;
    private static final String FORM_URL = "https://practice-automation.com/form-fields/";
    @FindBy(css = "input[data-testid='name-input']")
    private WebElement nameField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='checkbox' and @value='Milk']")
    private WebElement milkCheckbox;
    @FindBy(xpath = "//input[@type='checkbox' and @value='Coffee']")
    private WebElement coffeeCheckbox;
    @FindBy(css = "input[type='radio'][value='Yellow']")
    private WebElement yellowRadio;
    @FindBy(css = "select[data-testid='automation']")
    private WebElement automationSelect;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "message")
    private WebElement messageField;
    @FindBy(id = "submit-btn")
    private WebElement submitButton;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        ;
        PageFactory.initElements(driver, this);
    }

    @Step("Открываем форму")
    public FormPage open() {
        driver.get(FORM_URL);
        return this;
    }

    @Step("Вводим имя: {name}")
    public FormPage enterName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    @Step("Вводим пароль: {password}")
    public FormPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Выбираем Молоко")
    public FormPage selectMilk() {
        milkCheckbox.click();
        return this;
    }

    @Step("Выбираем Кофе")
    public FormPage selectCoffee() {
        coffeeCheckbox.click();
        return this;
    }

    @Step("Выбираем цвет: Yellow")
    public FormPage selectYellowColor() {
        yellowRadio.click();
        return this;
    }

    @Step("Выбираем Automation: Yes")
    public FormPage selectAutomationYes() {
        Select select = new Select(automationSelect);
        select.selectByVisibleText("Yes");
        return this;
    }

    @Step("Вводим Email: {email}")
    public FormPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Вводим сообщение с инструментами: {tools}")
    public FormPage enterMessageWithTools(String[] tools) {
        String longestTool = "";
        for (String tool : tools) {
            if (tool.length() > longestTool.length()) {
                longestTool = tool;
            }
        }
        String messageText = tools.length + " " + longestTool;
        messageField.sendKeys(messageText);
        return this;
    }

    @Step("Отправляем форму")
    public FormPage submitForm() {
        //wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        //submitButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        return this;
    }

    @Step("Обрабатываем алерт с текстом")
    public FormPage handleAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals("Message received!", alert.getText());
        alert.accept();
        return this;
    }

    @Step("Проверяем, что алерт не появился при незаполненной форме")
    public FormPage handleNoAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            Assertions.fail("Алерт появился, хотя форма была пустой. Текст: " + alert.getText());
        } catch (TimeoutException e) {

        }
        return this;
    }

}
