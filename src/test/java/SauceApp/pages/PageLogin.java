package SauceApp.pages;

import SauceApp.utils.BaseTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin extends BaseTools {

    // la declaration des elements Web

    @FindBy(id = "user-name")
    private WebElement champsUserName;

    @FindBy(name = "password")
    private WebElement champsPassword;

    @FindBy(id = "login-button")
    private WebElement boutonLogin;

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    private WebElement textErreur;

    int default_time = 30;

    // Constructeur pour intialiser les elements
    WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        setWait(new WebDriverWait(driver,default_time));
    }

    // définition les methodes pour interagir avec les elements login

    public void seConnecter(String userName, String password) {
        System.out.println("saisir non"+ userName);
        waitAndSendKeys(champsUserName, userName, default_time);
        System.out.println("saisir non"+ password);
        waitAndSendKeys(champsPassword, password, default_time);
        System.out.println("cliquer login");
        waitAndClick(boutonLogin, 40);
    }

    public String verifierMessageErreur() {
        System.out.println(" verifier message d'erreur");
        WebElement textMessageElement= waitElementToBeVisible(textErreur,default_time);
        return textMessageElement.getText();
    }
}
