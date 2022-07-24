package SwagLabs;

import Pages.Scenario;
import Pages.WebDriverSet;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static DataObjects.LogInData.passwordInput;
import static DataObjects.LogInData.usernameInput;


public class ScenarioTwo extends WebDriverSet{

    @Test(priority = 2)
    public  void VerifyPrice() {


        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> beforeFilterPriceList = new ArrayList<>();

        for (WebElement p : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));

        }


        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");

        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> afterFilterPriceList = new ArrayList<>();

        for (WebElement p : afterFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));


        }

        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);


        driver.quit();

    }
}
