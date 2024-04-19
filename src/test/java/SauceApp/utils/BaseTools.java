package SauceApp.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static SauceApp.configuration.SetupTearDown.driver;

public class BaseTools {

    private WebDriverWait wait;

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public void waitAndClick(WebElement element, int default_time){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitAndSendKeys(WebElement element, String text, int default_time){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }

    public WebElement waitElementToBeVisible(WebElement element, int default_time) {
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }
}
