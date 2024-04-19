package SauceApp.suiteTests;


import SauceApp.configuration.SetupTearDown;
import SauceApp.dataSet.Constant;
import SauceApp.pages.PageLogin;
import SauceApp.pages.PageProduit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static SauceApp.configuration.SetupTearDown.driver;

public class SuiteLogin extends SetupTearDown {


    @Test
    public void Test01_loginInvalide(){
        String messageAttendu = Constant.messageError;
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.seConnecter(Constant.usernameInValide,Constant.passwordValide);
        String actuelMessage= pageLogin.verifierMessageErreur();
        Assert.assertEquals(actuelMessage, messageAttendu);
    }

    @Test
    public void Test02_loginValide(){
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.seConnecter(Constant.usernameValide,Constant.passwordValide);
        PageProduit pageProduit= new PageProduit(driver);
        Assert.assertEquals(pageProduit.verifierTtileProduit(),"Products");

    }


}
