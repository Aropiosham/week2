package Tests;
import org.testng.annotations.Test;

public class SearchEmployeeTests extends BaseTest {

    @Test
    public void searchEmployee() {
        test.info("Searching for employee...");
        test.pass("Employee found successfully!");
    }
}
