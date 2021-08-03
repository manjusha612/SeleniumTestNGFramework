package testscenarios;

import base.TestBaseClass;
import businesscomponents.Home;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.CustomListeners;

@Listeners(CustomListeners.class)
public class UploadFile extends TestBaseClass {
    @Test(priority = 1)
    public static void uploadFile() throws InterruptedException {
        Home.uploadFile();
    }
}
