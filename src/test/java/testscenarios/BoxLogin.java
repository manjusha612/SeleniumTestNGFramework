package testscenarios;

import base.TestBaseClass;
import businesscomponents.Login;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.Action;
import util.CustomListeners;
import util.TestUtil;

@Listeners(CustomListeners.class)
public class BoxLogin extends TestBaseClass {

    @Test(priority = 1)
    public static void login() throws InterruptedException {
        Action.navigateToURL(TestUtil.getProperty("URL"));
        Login.login();
    }
}