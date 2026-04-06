package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        try {
            takeScreenshot();
        } catch (Exception e) {
            System.out.println("Не удалось сделать скриншот: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    @Attachment(value = "Скриншот после теста", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
