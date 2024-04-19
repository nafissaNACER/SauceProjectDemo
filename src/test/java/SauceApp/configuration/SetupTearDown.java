package SauceApp.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class SetupTearDown {
    public static WebDriver driver;

    @BeforeMethod
    public void lunchBrowser() {
        String browser = System.getenv("Browser");
        System.out.println("lunch browser");
        //System.setProperty("webdriver.edge.driver", "C:\\toolsDev\\edgedriver_win64\\msedgedriver.exe");
        if(browser.contentEquals("chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("close browser");
        driver.quit();
        System.out.println("end test");
        System.out.println("end test");
    }
}
