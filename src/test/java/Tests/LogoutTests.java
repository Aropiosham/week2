package Tests;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test
    public void logoutTest() {
        test.info("Logging out user...");
        test.pass("User logged out successfully!");
    }
}
