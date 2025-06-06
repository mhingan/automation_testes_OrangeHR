import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.LoginPage;

import java.time.Duration;

public class LoginTest {

    ChromeOptions options;
    WebDriver driver;
    LoginPage login;
    WebDriverWait wait;

    @Before
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        login = new LoginPage(driver);
    }

    @Test
    public void testLogin_invalid_username_and_password() {

        login.enterUsername("aefgahg");
        login.enterPassword("wrongpass");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @Test
    public void testLogin_invalid_username_password_ok() {

        login.enterUsername("invalidusername");
        login.enterPassword("admin123");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @Test
    public void testLogin_invalid_password_username_ok() {

        login.enterUsername("Admin");
        login.enterPassword("wrong");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }

    @Test
    public void testLogin_valid() {

        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
    }

    @Test
    public void test_empty_login_fields() {

        login.enterUsername("");
        login.enterPassword("");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


}
