package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

    @FindBy(id="react-burger-menu-btn")
    WebElement menu;

    @FindBy(id="logout_sidebar_link")
    WebElement logout;
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addbaxkpack;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addtshirt;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cart;


    WebDriver driver;
    public homepage(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);

    }
    public void setMenu() {
        menu.click();
    }

    public void setLogout() {
        logout.click();
    }

    public void setAddbaxkpack() {
        addbaxkpack.click();
    }

    public void setAddtshirt() {
        addtshirt.click();
    }

    public void setCart() {

        cart.click();
    }
}
