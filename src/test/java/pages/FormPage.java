package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    private WebDriver driver;

    //private WebDriverWait wait;
    public FormPage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private static final String FORM_URL = "https://practice-automation.com/form-fields/";

    public FormPage open() {
        driver.get(FORM_URL);
        return this;
    }

    public FormPage enterName(String name) {
        driver.findElement(By.xpath("//input[@data-testid='name-input']")).sendKeys(name);
        return this;
    }

    public FormPage enterPassword(String password) {
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        return this;
    }

    public FormPage selectMilk() {
        WebElement milkCheckbox = driver.findElement(
                By.xpath("//input[@type='checkbox' and @value='Milk']")
        );
        milkCheckbox.click();
        /*WebElement milk = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("drink2"))
        );
        milk.click();*/
        return this;
    }

    public FormPage selectCoffee() {
        WebElement coffeeCheckbox = driver.findElement(
                By.xpath("//input[@type='checkbox' and @value='Coffee']")
        );
        coffeeCheckbox.click();
        /*WebElement coffee = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("drink3"))
        );
        coffee.click();*/
        return this;
    }

    public FormPage selectYellowColor() {
        driver.findElement(By.cssSelector("input[value='Yellow']")).click();
        return this;
    }

    public FormPage selectAutomationYes() {
        WebElement automationSelect = driver.findElement(By.cssSelector("[data-testid='automation']"));
        Select select = new Select(automationSelect);
        select.selectByVisibleText("Yes");
        return this;
    }

    public FormPage enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
        //driver.findElement(By.xpath("//input[@data-testid='email']")).sendKeys(email);
        return this;
    }

}
