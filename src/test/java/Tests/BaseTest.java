package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import factory.ConfigFactory;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentManager;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        // ✅ Proper initialization of ExtentReports
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup(Method method) {
        String browser = ConfigFactory.get("browser");
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        driver.get(ConfigFactory.get("url"));

        // ✅ Now extent is properly initialized
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "✅ Test Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "❌ Test Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
        }

        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void tearDownReport() {
        // ✅ Flush the report safely
        if (extent != null) {
            extent.flush();
        }
    }
}
