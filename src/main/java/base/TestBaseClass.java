package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import util.Reporting;
import util.TestUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBaseClass implements ITestListener {

    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static String url;

    @BeforeSuite
    public static void ReportInitialization() {
        Reporting.startReport();
    }

    @BeforeTest
    public static void initialisation() throws InterruptedException {
        String log4j = System.getProperty("user.dir") + "/log4j.properties";
        PropertyConfigurator.configure(log4j);
        System.setProperty(TestUtil.getProperty("CHROME_KEY"), TestUtil.getProperty("CHROME_VALUE"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--test-type");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        String browserName = TestUtil.getProperty("browserName");
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver(chromeOptions);
        }
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_Timeout, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    @AfterSuite
    public static void flush() {
        Reporting.flushReport();
    }

}
