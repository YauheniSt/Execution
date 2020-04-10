package Test;

import java.io.IOException;

import org.testng.annotations.Test;
import Base.Base;

public class HomePageTest extends Base {
	@Test(groups= {"Regression"})
	public void loginTC() throws IOException {
		browserInit();
		launchApp();
		driver.quit();
	}
}
