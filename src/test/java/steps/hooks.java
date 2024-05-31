package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.seleniumDriver;

public class hooks {


    public WebDriver driver;

    @Before
    public void setup(){
        seleniumDriver.setupDriver();
    }

    @After
    public void teardown(Scenario scenario) throws InterruptedException {
        //capture screenshot
        if(scenario.isFailed()){
            driver=seleniumDriver.getDriver();
            byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failedscreenshot");
        }
        Thread.sleep(2000);
        seleniumDriver.tearDown();
    }
}
