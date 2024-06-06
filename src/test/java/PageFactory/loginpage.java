package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
    @FindBy(id ="user-name")
    WebElement username;
    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginbutton;

    WebDriver driver;

    public loginpage(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);

    }
    public void setUsername(String name){

        username.sendKeys(name);
    }

    public void setPassword(String motdepasse) {

        password.sendKeys(motdepasse);
    }

    public void setLoginbutton() {
        loginbutton.click();
    }
}
