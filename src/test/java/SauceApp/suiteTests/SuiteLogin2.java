package SauceApp.suiteTests;

import SauceApp.configuration.SetupTearDown;
import SauceApp.dataSet.Constant;
import SauceApp.pages.PageLogin;
import SauceApp.pages.PageProduit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static SauceApp.configuration.SetupTearDown.driver;

public class SuiteLogin2 extends SetupTearDown {
    @Test(priority = 2)
    public void Test01_loginInvalide2(){
        String messageAttendu = Constant.messageError;
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.seConnecter(Constant.usernameInValide,Constant.passwordValide);
        String actuelMessage= pageLogin.verifierMessageErreur();
        Assert.assertEquals(actuelMessage, messageAttendu);
    }

    @Test(priority = 1)
    public void Test02_loginValide2(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.seConnecter(Constant.usernameValide,Constant.passwordValide);
        PageProduit pageProduit= new PageProduit(driver);
        Assert.assertEquals(pageProduit.verifierTtileProduit(),"Products");

    }
}
