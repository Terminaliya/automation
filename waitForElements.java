import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitForElements {
    public AppiumDriver driver;
    public WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresentById(String id, String error_message){
        return waitForElementPresentById(id, error_message, 5);
    }

    public WebElement waitForElementPresentByXPath(String xpath, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresentByXPath(String xpath, String error_message) {
        return waitForElementPresentByXPath(xpath, error_message, 5);
    }
}