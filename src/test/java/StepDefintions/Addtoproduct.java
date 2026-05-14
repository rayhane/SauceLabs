package StepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Addtoproduct extends Basetest {

    WebDriver driver=new ChromeDriver();

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement Email ;
        Email= driver.findElement(By.id("user-name"));
        Email.sendKeys("standard_user");
        WebElement Password ;
        Password=driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
    }
    @And("I click  on the Loginn Button")
    public void i_click_on_the_loginn_button() {

        WebElement LoginButton ;
        LoginButton=driver.findElement(By.id("login-button"));
        LoginButton.click();

    }

    @When("I click on Add button")
    public void i_click_on_Add_button() {

       WebElement Addtocart;
       Addtocart=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

       Addtocart.click();
    }
    @And("click to chart")
    public void click_to_chart() {

        WebElement chart;
        chart=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        chart.click();
    }

    @Then("check product")
    public void check_product() {

        String pagecontent = driver.findElement(By.tagName("html")).getText();
        List<String> motrechrche = new ArrayList<>();
        motrechrche.add("Sauce Labs Backpack");
        for (String mot : motrechrche) {
            if (pagecontent.contains(mot)) {
                System.out.println("le mot " + mot + "  existe sur la page");
            } else {
                System.out.println("le mot " + mot + " n'existe pas sur la page");
            }

        }

    }

    @When("I click on Remove button")
    public void i_click_on_remove_button() throws InterruptedException {


        WebElement removebtn;
        Thread.sleep(3000);
        removebtn=driver.findElement(By.id("remove-sauce-labs-backpack"));
        removebtn.click();

    }



    @Then("check product is remouving")
    public void check_product_is_remouving() {
        String pagecontent = driver.findElement(By.tagName("html")).getText();
        List<String> motrechrche = new ArrayList<>();
        motrechrche.add("Sauce Labs Backpack");
        for (String mot : motrechrche) {
            if (pagecontent.contains(mot)) {
                System.out.println("le mot " + mot + "  existe sur la page");
            } else {
                System.out.println("le mot " + mot + " n'existe pas sur la page");
            }

        }
    }

    @When("I click on checkout")
    public void i_click_on_checkout() {

       WebElement checkout;
       checkout=driver.findElement(By.id("checkout"));
       checkout.click();
    }
    @And("enter name")
    public void enter_name() {

        WebElement entername;
        entername=driver.findElement(By.id("first-name"));
        entername.sendKeys("rayhane");

    }
    @And("enter firstname")
    public void enter_firstname() {

        WebElement enterlastname;
        enterlastname=driver.findElement(By.id("last-name"));
        enterlastname.sendKeys("jelassi");
    }
    @And("enter codepostal")
    public void enter_codepostal() {

        WebElement zip;
        zip=driver.findElement(By.id("postal-code"));
        zip.sendKeys("5011");
    }
    @And("click continue")
    public void click_continue() throws InterruptedException {


        Thread.sleep(3000);

        WebElement continuebtn;
        continuebtn=driver.findElement(By.id("continue"));
        continuebtn.click();
    }
    @And("click finish")
    public void click_finish() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       WebElement finish;
       finish=driver.findElement(By.id("finish"));
       finish.click();
    }
    @Then("checkout successfuly")
    public void checkout_successfuly() {

        String expectedUrl;
        expectedUrl="https://www.saucedemo.com/checkout-complete.html";

        String acctualUrl;
        acctualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,acctualUrl);

    }



}



