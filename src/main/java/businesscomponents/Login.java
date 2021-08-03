package businesscomponents;

import base.TestBaseClass;
import com.aventstack.extentreports.Status;
import objects.ObjectsHome;
import objects.ObjectsLogin;
import util.Action;
import util.Reporting;
import util.TestUtil;

public class Login extends TestBaseClass {

    //method to login to box.com and verify login
    public static void login() {
        try {
            Action.navigateToURL(TestUtil.getProperty("URL"));
            Thread.sleep(1500);
            String userName = TestUtil.getProperty("UName");
            String password = TestUtil.getProperty("Password");
            Action.click(ObjectsLogin.lnk_login);
            Action.sendKeys(ObjectsLogin.txt_email, userName);
            Action.click(ObjectsLogin.btn_submit);
            Action.sendKeys(ObjectsLogin.txt_password, password);
            Action.click(ObjectsLogin.btn_submit);
            Thread.sleep(3000);
            if (Action.isElementDisplayed(ObjectsHome.lbl_allFiles))
                Reporting.report("Logged into box.com", Status.PASS);
            else
                Reporting.report("Could not log into box.com", Status.FAIL);
        } catch (InterruptedException e) {
            Reporting.report("Could not log into box.com", Status.FAIL);
        }
    }

}
