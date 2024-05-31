package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class seleniumDriver {


    private static seleniumDriver seleniumDriver;

    private static WebDriver driver;

    private static WebDriverWait waitDriver;

    public static Properties config=new Properties();
    public static Properties OR=new Properties();

    private FileInputStream fis;

    private seleniumDriver() {
        try {
            fis = new FileInputStream("src/test/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            OR.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            fis = new FileInputStream("src/test/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if(config.getProperty("browser").equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }

        driver.manage().window().maximize();
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
    }


    public static WebDriver getDriver(){
        return driver;
    }
    public static void setupDriver(){
        if(seleniumDriver==null)
            seleniumDriver=new seleniumDriver();
    }

    public static void openpage(String url){
        driver.get(url);
    }
    public static void tearDown(){
        if(driver !=null){
            driver.close();
            driver.quit();
        }
          seleniumDriver=null;
    }
}
