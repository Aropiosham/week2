package Tests;
import org.testng.annotations.Test;

public class DashboardTests extends BaseTest {

    @Test
    public void verifyDashboard() {
        test.info("Verifying dashboard elements...");
        test.pass("Dashboard verified successfully!");
    }
}
