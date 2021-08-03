package objects;

import org.openqa.selenium.By;

// Login page objects
public class ObjectsLogin {
    public static final By lnk_login = By.xpath("//a[text()='Log in']");
    public static final By txt_email = By.xpath("//input[@title='Enter Your Email']");
    public static final By btn_submit = By.xpath("//button[@type='submit']");
    public static final By txt_password = By.xpath("//input[@title='Enter Your Password']");
    public static final By lbl_signIn = By.xpath("//h1[text()='Sign In to Your Account']");
}
