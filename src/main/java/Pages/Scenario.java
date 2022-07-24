package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static DataObjects.CheckoutData.*;
import static org.testng.AssertJUnit.assertEquals;

public class Scenario {

    WebDriver driver;

    public Scenario(WebDriver driver) {
        this.driver = driver;
    }

    By UserNameInput = By.id("user-name");
    By PasswordInput = By.id("password");
    By LogInBtn = By.id("login-button");
    By FirstItem = By.id("add-to-cart-sauce-labs-backpack");
    By LastItem = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By DeleteItem = By.id("remove-sauce-labs-backpack");
    By AddPrevious = By.id("add-to-cart-sauce-labs-bike-light");
    By Cart = By.id("shopping_cart_container");
    By Checkout = By.id("checkout");
    By OrderName = By.id("first-name");
    By OrderSurname = By.id("last-name");
    By Zip = By.id("postal-code");
    By Continue = By.id("continue");
    By Finish = By.id("finish");
    By BurgerMenu = By.id("react-burger-menu-btn");
    By LogOutBTN = By.id("logout_sidebar_link");

    @Step("Fill Username: {0}")
    public Scenario Username(String usernameInput) {
        driver.findElement(UserNameInput).sendKeys(usernameInput);
        return this;
    }
    @Step("Fill Password: {0}")
    public Scenario Password(String passwordInput) {
        driver.findElement(PasswordInput).sendKeys(passwordInput);
        return this;
    }

    @Step("Click To Login")
    public Scenario ClickToLogIn() throws InterruptedException {
        driver.findElement(LogInBtn).click();
        Thread.sleep(2000);
        return this;
    }
    @Step("Click To Add to cart")
    public Scenario ClickToAdd() throws InterruptedException {
        driver.findElement(FirstItem).click();
        WebElement firstItem = driver.findElement(By.id("item_4_title_link"));
        assertEquals("Sauce Labs Backpack",firstItem.getText(),"Sauce Labs Backpack");
        return this;
    }
    @Step("Click To Add to cart")
    public Scenario ClickToAddLast() throws InterruptedException {
        driver.findElement(LastItem).click();
        WebElement lastItem = driver.findElement(By.id("item_3_title_link"));
        assertEquals("Test.allTheThings() T-Shirt (Red)",lastItem.getText(),"Test.allTheThings() T-Shirt (Red)");
        return this;
    }
    @Step("Delete First Item")
    public Scenario ClickToDelete() throws InterruptedException {
        driver.findElement(DeleteItem).click();
        return this;
    }
    @Step("Add Second Item")
    public Scenario ClickToAddPrevious() throws InterruptedException {
        driver.findElement(AddPrevious).click();
        WebElement Previous = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        assertEquals("Remove",Previous.getText(),"REMOVE");
        return this;
    }
    @Step("Go to my cart")
    public Scenario GoToCart() throws InterruptedException {
        driver.findElement(Cart).click();
        Thread.sleep(1000);
        return this;
    }
    @Step("Go to my Checkout")
    public Scenario GoToCheckout() throws InterruptedException {
        driver.findElement(Checkout).click();
        Thread.sleep(1000);
        return this;
    }
    @Step("Fill Name: {0}")
    public Scenario Name(String nameInput) {
        driver.findElement(OrderName).sendKeys(firstName);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public Scenario Surname(String lastNameInput) {
        driver.findElement(OrderSurname).sendKeys(lastName);
        return this;
    }
    @Step("Fill Zip Code: {0}")
    public Scenario ZIP(String postalCode) {
        driver.findElement(Zip).sendKeys(zip);
        return this;
    }
    @Step("Continue to order")
    public Scenario ContinueOrder() throws InterruptedException {
        driver.findElement(Continue).click();
        Thread.sleep(1000);
        return this;
    }
    @Step("Finish the order")
    public Scenario FinishOrder() throws InterruptedException {
        driver.findElement(Finish).click();
        Thread.sleep(1000);
        WebElement finishOrder = driver.findElement(By.className("complete-header"));
        assertEquals("THANK YOU FOR YOUR ORDER",finishOrder.getText(),"THANK YOU FOR YOUR ORDER");
        WebElement VerifyEmpty = driver.findElement(By.id("shopping_cart_container"));
        assertEquals("",VerifyEmpty.getText(),"");
        return this;
    }
    @Step("Continue to order")
    public Scenario BurgerMenuDr() throws InterruptedException {
        driver.findElement(BurgerMenu).click();
        Thread.sleep(1000);
        return this;
    }
    @Step("Continue to order")
    public Scenario LogOut() throws InterruptedException {
        driver.findElement(LogOutBTN).click();
        Thread.sleep(1000);
        return this;
    }
}
