package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.seleniumDriver;

public class Basepage {

    public static WebDriver driver;
    private WebElement mouseoverElement;

    public Basepage() {
        driver = seleniumDriver.getDriver();
    }

    public void mouseover(String locator) {
        if (locator.endsWith("_Xpath")) {
            mouseoverElement = driver.findElement(By.xpath(seleniumDriver.OR.getProperty(locator)));
        } else if (locator.endsWith("_ID")) {
            mouseoverElement = driver.findElement(By.id(seleniumDriver.OR.getProperty(locator)));
        } else if (locator.endsWith("_LINK")) {
            mouseoverElement = driver.findElement(By.linkText(seleniumDriver.OR.getProperty(locator)));
        }

        new Actions(driver).moveToElement(mouseoverElement).perform();
    }

    public void click(String locator) {
        if (locator.endsWith("_Xpath")) {
            driver.findElement(By.xpath(seleniumDriver.OR.getProperty(locator))).click();
        } else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(seleniumDriver.OR.getProperty(locator))).click();
        } else if (locator.endsWith("_LINK")) {
            driver.findElement(By.linkText(seleniumDriver.OR.getProperty(locator))).click();
        }

    }

    public boolean isElementPresent(String locator) {
        try {
            if (locator.endsWith("_Xpath")) {
                driver.findElement(By.xpath(seleniumDriver.OR.getProperty(locator)));
            } else if (locator.endsWith("_ID")) {
                driver.findElement(By.id(seleniumDriver.OR.getProperty(locator)));
            } else if (locator.endsWith("_LINK")) {
                driver.findElement(By.linkText(seleniumDriver.OR.getProperty(locator)));
            }

            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public void type(String locator,String value) {
        if (locator.endsWith("_Xpath")) {
            driver.findElement(By.xpath(seleniumDriver.OR.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(seleniumDriver.OR.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_LINK")) {
            driver.findElement(By.linkText(seleniumDriver.OR.getProperty(locator))).sendKeys(value);
        }

    }

    public static String getText(String locator) {
        if (locator.endsWith("_Xpath")) {
            locator=  driver.findElement(By.xpath(seleniumDriver.OR.getProperty(locator))).getText();
        } else if (locator.endsWith("_ID")) {
            locator= driver.findElement(By.id(seleniumDriver.OR.getProperty(locator))).getText();
        } else if (locator.endsWith("_LINK")) {
            locator= driver.findElement(By.linkText(seleniumDriver.OR.getProperty(locator))).getText();
        }

        return locator;
    }

}

