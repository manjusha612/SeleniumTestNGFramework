package businesscomponents;

import base.TestBaseClass;
import com.aventstack.extentreports.Status;
import objects.ObjectsHome;
import util.Action;
import util.Reporting;
import util.TestUtil;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Home extends TestBaseClass {
    public static String folderName = "Test";

    //method to create a folder and verify whether the folder has been created successfully
    public static void createFolder() {
        try {
            Action.click(ObjectsHome.lnk_arrowDown);
            Thread.sleep(2000);
            Action.click(ObjectsHome.btn_new);
            Action.click(ObjectsHome.lnk_folder);
            Thread.sleep(2000);
            Action.sendKeys(ObjectsHome.txt_folderName, folderName);
            Action.click(ObjectsHome.btn_create);
            Thread.sleep(3000);
            if (Action.isElementDisplayed(ObjectsHome.lbl_folderName)
                    && Action.isElementDisplayed(ObjectsHome.lnk_folderName))
                Reporting.report("Created Folder named: " + folderName, Status.PASS);
            else
                Reporting.report("Could not create the folder", Status.FAIL);
        } catch (InterruptedException e) {
            Reporting.report("Could not create the folder", Status.FAIL);
        }
    }

    //method to upload a file into the created folder and verify whether the file has been uploaded successfully
    public static void uploadFile() {
        try {
            //file named "test.txt" is placed within the project in the folder named "UploadFile"
            String fileName = System.getProperty("user.dir") + TestUtil.getProperty("FileToUpload");
            Thread.sleep(2000);
            Action.click(ObjectsHome.lnk_folderName);
            Action.pressEnter();
            Thread.sleep(2000);
            Action.click(ObjectsHome.btn_upload);
            Thread.sleep(1000);
            Action.click(ObjectsHome.btn_file);
            Thread.sleep(2000);
            Robot robot = new Robot();
            StringSelection selection = new StringSelection(fileName);
            //filename is copied in the system clipboard below
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            //Using Robot class file is uploaded into box.com
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(10000);
            System.out.println("code is here");
            if (Action.isElementDisplayed(ObjectsHome.lnk_uploadedFile))
                Reporting.report("Successfully uploaded the file", Status.PASS);
            else
                Reporting.report("Could not upload the file", Status.FAIL);
        } catch (InterruptedException | AWTException e) {
            Reporting.report("Could not upload the file", Status.FAIL);
        }
    }

/*    This method deletes the folder which was created to test the application.
    Thus the test data created is deleted through automated script itself*/
    public static void deleteCreatedFolder() {
        try {
            Thread.sleep(2000);
            Action.click(ObjectsHome.lnk_allFiles);
            Thread.sleep(1000);
            Action.click(ObjectsHome.lnk_folderName);
            Thread.sleep(3000);
            Action.click(ObjectsHome.btn_clearSelection);
            Thread.sleep(2000);
            Action.click(ObjectsHome.btn_moreOptions);
            Thread.sleep(1000);
            Action.click(ObjectsHome.lnk_trash);
            Thread.sleep(1000);
            Action.click(ObjectsHome.btn_okay);
            Thread.sleep(2500);
            if (Action.isElementDisplayed(ObjectsHome.lbl_trashed))
                Reporting.report("Deleted created Folder", Status.PASS);
            else
                Reporting.report("Could not delete the created folder", Status.FAIL);
        } catch (InterruptedException e) {
            Reporting.report("Could not delete the created folder", Status.FAIL);
        }
    }

}
