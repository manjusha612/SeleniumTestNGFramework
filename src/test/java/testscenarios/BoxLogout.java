package testscenarios;

import base.TestBaseClass;
import businesscomponents.Logout;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.CustomListeners;

@Listeners(CustomListeners.class)
public class BoxLogout extends TestBaseClass {
    @Test(priority = 1)
    public static void logout() throws InterruptedException {
        Logout.logout();
    }
}
