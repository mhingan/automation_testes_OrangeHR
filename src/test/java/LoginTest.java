import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.LoginPage;

import java.time.Duration;

public class LoginTest {

    WebDriver driver = new ChromeDriver();
    LoginPage login = new LoginPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // maxim 10 secunde



    @Test
    public void testLogin_invalid_username_and_password() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        login.enterUsername("aefgahg");
        login.enterPassword("wrongpass");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

        driver.quit();
    }


    @Test
    public void testLogin_invalid_username_password_ok() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));


        login.enterUsername("invalidusername");
        login.enterPassword("admin123");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

        driver.quit();
    }

    @Test
    public void testLogin_invalid_password_username_ok() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));


        login.enterUsername("Admin");
        login.enterPassword("wrong");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));

        driver.quit();
    }




    @Test
    public void testLogin_valid() {

        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        driver.quit();

    }


    @Test
    public void test_emplty_login_fields() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        login.enterUsername("");
        login.enterPassword("");
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().matches("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        driver.quit();
    }
}
