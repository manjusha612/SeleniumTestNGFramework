package objects;

import businesscomponents.Home;
import org.openqa.selenium.By;

// Home page objects
public class ObjectsHome {
    public static final By lbl_allFiles = By.xpath("(//h1[text()='All Files'])[1]");
    public static final By btn_avatar = By.xpath("//span[@class='avatar-initials ']");
    public static final By lnk_logout = By.xpath("//span[text()='Log Out']");
    //public static final By lnk_arrowDown = By.xpath("//div//*[@class='arrow-down-illustration ']");
    // this locators has changed
    public static final By lnk_arrowDown = By.xpath("//div[@class='OnboardingTrackerActions-header-svgWrap']");
    public static final By btn_new = By.xpath("//span[text()='New']");
    public static final By lnk_folder = By.xpath("//span[text()='Folder']");
    public static final By txt_folderName = By.xpath("//input[@name='folder-name']");
    public static final By btn_create = By.xpath("//span[text()='Create']");
    public static final By lnk_folderName = By.xpath("//a[text()='" + Home.folderName + "']");
    public static final By lbl_folderName = By.xpath("//span[text()='\"" + Home.folderName + "\" was created successfully.']");
    public static final By btn_upload = By.xpath("//span[text()='Upload']");
    public static final By btn_file = By.xpath("//span[text()='File']");
    public static final By lnk_uploadedFile = By.xpath("//a[@data-resin-target='openfile']");
    public static final By lnk_allFiles = By.xpath("//span[text()='All Files']");
    public static final By btn_clearSelection = By.xpath("//button[@aria-label='Clear selection']");
    public static final By btn_moreOptions = By.xpath("(//button[@aria-label='More Options'])[1]");
    public static final By lnk_trash = By.xpath("(//span[text()='Trash'])[2]");
    public static final By btn_okay = By.xpath("//span[text()='Okay']");
    public static final By lbl_trashed = By.xpath("//span[text()='Item successfully moved to trash.']");
}
