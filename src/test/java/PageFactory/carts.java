package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class carts {
    @FindBy(id="remove-sauce-labs-backpack")
    WebElement remvoepro1;

    @FindBy(id="remove-sauce-labs-bolt-t-shirt")
    WebElement removepro2;

    @FindBy(id="checkout")
    WebElement btnchekout;
    @FindBy(id="continue-shopping")
    WebElement continueshopping;

    @FindBy(id="first-name")
    WebElement firstname;
    @FindBy(id="last-name")

    WebElement lastname;

    @FindBy(id="postal-code")
    WebElement postalcode;

    @FindBy(id="continue")
    WebElement btncontinue;

    @FindBy(id="finish")
    WebElement finish;

    @FindBy(id="back-to-products")
    WebElement backtoproducts;

    WebDriver driver;
    public carts(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);

    }

    public void setRemvoepro1() {
       remvoepro1.click();
    }

    public void setRemovepro2() {
        removepro2.click();
    }

    public void setBtnchekout() {
        btnchekout.click();
    }

    public void setBacktoproducts() {
        backtoproducts.click();
    }

    public void setFirstname(String first) {
        firstname.sendKeys(first);
    }

    public void setLastname(String last) {
        lastname.sendKeys(last);
    }

    public void setPostalcode(String zip) {
        postalcode.sendKeys(zip);
    }

    public void setBtncontinue() {
        btncontinue.click();
    }

    public void setContinueshopping() {
        continueshopping.click();
    }

    public void setFinish() {
        finish.click();
    }

    public void setBacktoproducts(WebElement backtoproducts) {
        backtoproducts.click();
    }
}
