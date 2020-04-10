package Test;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Base;

public class RegistrationTest extends Base {
	@Test(groups= {"Acceptance"})
	public void registrationTC() throws IOException {
		browserInit();
		launchApp();
		driver.quit();
	}
}
