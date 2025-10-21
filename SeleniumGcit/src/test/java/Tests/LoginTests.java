package Tests;

import factory.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest() {
        try {
            test.info("Navigating to Login Page");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys(ConfigFactory.get("username"));
            test.info("Entered Username");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys(ConfigFactory.get("password"));
            test.info("Entered Password");

            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();
            test.info("Clicked on Login Button");

            WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span")));

            Assert.assertTrue(dashboard.isDisplayed(), "Dashboard not visible!");
            test.pass("Login successful and Dashboard displayed!");
        } catch (Exception e) {
            test.fail("Login test failed due to: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }
}
