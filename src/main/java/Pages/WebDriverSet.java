package Pages;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static DataObjects.LogInData.passwordInput;
import static DataObjects.LogInData.usernameInput;

public class WebDriverSet {
   public   WebDriver driver;


    @Parameters("browser")
    @BeforeTest(description = "Configure browsers before tests")
    public void setUp(String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Desktop\\geckodriver.exe");
            System.out.println("Executing on FireFox");
            driver = new FirefoxDriver();
            driver.get("https://www.saucedemo.com/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }
    @Test(priority = 1)
    @Description("Log In with valid credentials")
    public void SignIn() throws InterruptedException {
        Scenario home = new Scenario(driver);
        home
                .Username(usernameInput)
                .Password(passwordInput)
                .ClickToLogIn();
    }
}
