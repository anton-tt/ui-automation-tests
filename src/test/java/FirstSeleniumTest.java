import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstSeleniumTest {
    @Test
    void openBrowserTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://practice-automation.com/form-fields/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement nameField = driver.findElement(By.xpath("//input[@data-testid='name-input']"));
            nameField.sendKeys("Anton");

            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.sendKeys("12345");

            WebElement milkCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("drink2")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", milkCheckbox);
            milkCheckbox.click();
            WebElement coffeeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("drink3")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", coffeeCheckbox);
            coffeeCheckbox.click();

            WebElement greenRadio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Green']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", greenRadio);
            greenRadio.click();

            WebElement automationSelect = driver.findElement(By.cssSelector("[data-testid='automation']"));
            Select select = new Select(automationSelect);
            select.selectByVisibleText("Yes");

            WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
            emailField.sendKeys("anton@mail.ru");

            String[] tools = {"Selenium", "WebDriverManager", "JUnit", "Maven"};
            String longestTool = "";
            for (String tool : tools) {
                if (tool.length() > longestTool.length()) {
                    longestTool = tool;
                }
            }
            String messageText = tools.length + " " + longestTool;

            WebElement messageField = driver.findElement(By.id("message"));
            messageField.sendKeys(messageText);
        } finally {
            driver.quit();
        }
    }

}
