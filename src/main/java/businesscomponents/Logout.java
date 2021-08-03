package businesscomponents;

import base.TestBaseClass;
import com.aventstack.extentreports.Status;
import objects.ObjectsHome;
import objects.ObjectsLogin;
import util.Action;
import util.Reporting;

public class Logout extends TestBaseClass {

    //method to logout of box.com and verify whether it is successfully logged out
    public static void logout() {
        try {
            Thread.sleep(10000);
            Action.click(ObjectsHome.btn_avatar);
            Action.click(ObjectsHome.lnk_logout);
            Thread.sleep(3000);
            if (Action.isElementDisplayed(ObjectsLogin.lbl_signIn))
                Reporting.report("Logged out of box.com", Status.PASS);
            else
                Reporting.report("Could not log out from box.com", Status.FAIL);
        } catch (InterruptedException e) {
            Reporting.report("Could not log out from box.com", Status.FAIL);
        }
    }

}
