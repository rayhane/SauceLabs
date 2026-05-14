package StepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class login extends Basetest{
    WebDriver driver=new ChromeDriver();

    @Given("I have entered a valid email and password")
    public void i_have_entered_a_valid_email_and_password() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement Email ;
        Email= driver.findElement(By.id("user-name"));
        Email.sendKeys("standard_user");
        WebElement Password ;
        Password=driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
    }
    @When("I click  on the Login Button")
    public void i_click_on_the_login_button() {

        WebElement LoginButton ;
        LoginButton=driver.findElement(By.id("login-button"));
        LoginButton.click();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String expectedUrl ;
        expectedUrl=driver.getCurrentUrl();
        String Url ;
        Url="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl,Url);


    }

    @Given("I have entered a invalid {string} and {string}")
    public void i_have_entered_a_invalid_and(String name, String passi) {

        driver.get("https://www.saucedemo.com/");
        WebElement nom;
        nom=driver.findElement(By.id("user-name"));
        nom.sendKeys(name);

        WebElement pass;
        pass=driver.findElement(By.id("password"));
        pass.sendKeys(passi);


    }
    @Then("I should see an error message indicating error_message")
    public void i_should_see_an_error_message_indicating_error_message() {
        String expectedUrl;
        expectedUrl="https://www.saucedemo.com/";

        String acctualUrl;
        acctualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,acctualUrl);





    }

    @When("I click on the menu Button")
    public void i_click_on_the_menu_button() throws InterruptedException {
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement menu;
        menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();
        Thread.sleep(3000);
    }

        @When("I click on logout")
        public void i_click_on() {

        WebElement logout;
       logout=driver.findElement(By.id("logout_sidebar_link"));
       logout.click();

    }

    @Then("I should be logged out successfuly")
    public void i_should_be_logged_out_successfuly() {
        String expectedUrl ;
        expectedUrl=driver.getCurrentUrl();
        String Url ;
        Url="https://www.saucedemo.com/";
        Assert.assertEquals(expectedUrl,Url);


    }




}
