import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    public AppiumDriver driver;

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","Users/evgeniamargieva/Downloads/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstTest(){

        waitForElementAndClick(
                "//*[contains(@text, 'Search Wikipedia')]",
                "Cannot find Search Wikipedia input",
                5
        );

        waitForElementAndSendKeys(
                "org.wikipedia:id/search_src_text",
                "Java",
                "Cannot find search input",
                5
        );

        driver.hideKeyboard(); // я подумала, что мешает открытая клавиатура, поэтому добавила метод

        waitForElementPresentByXPath(
                "//*[@resource-id='org.wikipedia:id/page_list_item_description']//*[@text='Object-oriented programming language']",
                "Cannot find 'Object-oriented programming language'",
                15
        );
    }

    /*@Test
    public void testCancelSearch(){
        waitForElementAndClick(
                "//*[contains(@text, 'Search Wikipedia')]",
                "Cannot find Search Wikipedia input",
                5
        );
    }*/

    private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresentById(String id, String error_message){
        return waitForElementPresentById(id, error_message, 5);
    }

    private WebElement waitForElementPresentByXPath(String xpath, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresentByXPath(String xpath, String error_message) {
        return waitForElementPresentByXPath(xpath, error_message, 5);
    }

    private WebElement waitForElementAndClick(String xpath, String error_message, long timeout){
        WebElement element = waitForElementPresentByXPath(xpath, error_message, 5);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(String id, String value, String error_message, long timeout){
        WebElement element = waitForElementPresentById(id, error_message, 5);
        element.sendKeys(value);
        return element;
    }
}
