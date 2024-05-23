package extendreporttest;

import org.testng.annotations.Test;

public class SampleTest {
	@Test
	public void createContactTest() {
		System.out.println("Login to application");
		System.out.println("Navigate to contat page");
		System.out.println("Create contact");
		if("HDFC".equals("HDFC"))
		{
			System.out.println("Contact is created");
		}else {
		System.out.println("Contact is not created");
		}
		System.out.println("Login to application");
	}

}
