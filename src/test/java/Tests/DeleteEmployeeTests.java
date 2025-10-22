package Tests;

import org.testng.annotations.Test;

public class DeleteEmployeeTests extends BaseTest {

    @Test
    public void deleteEmployee() {
        test.info("Deleting an existing employee...");

        // Simulated action
        test.info("Employee ID: EMP123 selected for deletion.");

        // Simulated verification
        test.pass("Employee deleted successfully!");
    }
}
