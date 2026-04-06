package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    private WebDriver driver;

    //private WebDriverWait wait;
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
    @FindBy(css = "input[data-testid='automation']")
    private WebElement automationSelect;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id ="message")
    private WebElement messageField;
    /*@FindBy()
    private WebElement submitButton;*/

    public FormPage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public FormPage open() {
        driver.get(FORM_URL);
        return this;
    }

    public FormPage enterName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public FormPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public FormPage selectMilk() {
        milkCheckbox.click();
        return this;
    }

    public FormPage selectCoffee() {
        coffeeCheckbox.click();
        return this;
    }

    public FormPage selectYellowColor() {
        yellowRadio.click();
        return this;
    }

    public FormPage selectAutomationYes() {
        WebElement automationSelect = driver.findElement(By.cssSelector("[data-testid='automation']"));
        Select select = new Select(automationSelect);
        select.selectByVisibleText("Yes");
        return this;
    }

    public FormPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

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

}
