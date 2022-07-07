import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstTest {
    waitForElements waitById = new waitForElements();
    waitForElements waitByXPath = new waitForElements();

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

        waitById.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown(){
        waitById.driver.quit();
    }

    @Test
    public void firstTest(){

        WebElement element_to_init_search = waitById.driver.findElementByXPath(
                "//*[contains(@text, 'Search Wikipedia')]"
        );
        element_to_init_search.click();

        WebElement element_to_enter_search_line = waitById.waitForElementPresentById(
                "org.wikipedia:id/search_src_text",
                "Cannot find search input"
        );
        element_to_enter_search_line.sendKeys("Java");

        waitByXPath.waitForElementPresentByXPath(
                "//*[@resource-id='org.wikipedia:id/page_list_item_description']//*[@text='Object-oriented programming language']",
                "Cannot find 'Object-oriented programming language'",
                15
        );
    }
}
