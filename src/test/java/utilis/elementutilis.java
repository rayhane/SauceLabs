package utilis;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class elementutilis {

    WebDriver driver;

    public elementutilis(WebDriver driver)
    {
        this.driver=driver;
    }
  // méthode pour vérifier qu'une chaine existe ou pas sur la page
    public void validation(String msg){

        String pagecontent = driver.findElement(By.tagName("html")).getText();
        List<String> motrechrche = new ArrayList<>();

        motrechrche.add(msg);
        for (String mot : motrechrche) {
            if (pagecontent.contains(mot)) {
                System.out.println("le mot " + mot + "  s'affiche");
            } else {
                System.out.println("le mot " + mot + " ne s'affiche pas");
            }

        }

    }
public void confirmation(String lien){

        String expectedurl=lien;
        String acctualurl=driver.getCurrentUrl();

    Assert.assertEquals(expectedurl,acctualurl);


}

    //4-défiler la page vers le bas d'un nombre spécifié de pixels
    public void javaScriptscrollByPixels(int pixels) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0," + pixels + ");");
    }

    //5-défiler la page jusqu'à la fin (bas) de la page.
    public void javaScriptscrollToBottom() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //3- défiler la page jusqu'à ce que l'élément spécifié soit visible
    public void javaScriptscrollToElement(WebElement element, String textToBeTyped) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //méthodes alert
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForalert(durationInSeconds);
        alert.accept();
    }

    public Alert waitForalert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            System.out.println("alert is not present");
        }
        return alert;

    }

    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForalert(durationInSeconds);
        alert.dismiss();
    }








}
