package SwagLabs;

import Pages.Scenario;
import Pages.WebDriverSet;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static DataObjects.CheckoutData.*;
import static DataObjects.LogInData.passwordInput;
import static DataObjects.LogInData.usernameInput;

public class FirstScenario extends WebDriverSet {

//    @Test(dataProvider = "LoginDataProvider", dataProviderClass = Pages.DataProviderSw.class)
//    public void loginTest(String username, String pwd)
//    {
//        System.out.println(username+"    "+pwd);
//    }

    @Test(priority = 2)
    @Description("Add First and Last item to cart")
    public void AddToCart() throws InterruptedException {
        Scenario home = new Scenario(driver);
        home
            .ClickToAdd()
            .ClickToAddLast();

    }
    @Test(priority = 3)
    @Description("Delete First Item and Add Previous one")
    public void DeleteFirst() throws InterruptedException {
        Scenario home = new Scenario(driver);
        home
                .ClickToDelete()
                .ClickToAddPrevious();
    }
    @Test(priority = 4)
    @Description("Finish Order And go to checkout")
    public void FinishOrder() throws InterruptedException {
        Scenario home = new Scenario(driver);
        home
                .GoToCart()
                .GoToCheckout()
                .Name(firstName)
                .Surname(lastName)
                .ZIP(zip)
                .ContinueOrder()
                .FinishOrder();
    }
    @Test(priority = 5)
    @Description("Verify that cart is empty and log out")
    public void SignOut() throws InterruptedException {
        Scenario home = new Scenario(driver);
        home

                .BurgerMenuDr()
                .LogOut();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}