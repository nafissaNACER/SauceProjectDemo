package SauceApp.pages;

import SauceApp.utils.BaseTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageProduit extends BaseTools {

    @FindBy(xpath = "//span[@data-test=\"title\"]")
    private WebElement sousTitle;
    int default_time = 30;
    WebDriver driver;

    public PageProduit(WebDriver driver){
      this.driver=driver;
        PageFactory.initElements(driver,this);
        setWait(new WebDriverWait(driver,default_time));
    }

    public String verifierTtileProduit(){
        return waitElementToBeVisible(sousTitle,30).getText();
    }
}
