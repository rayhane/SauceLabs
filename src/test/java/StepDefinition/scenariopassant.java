package StepDefinition;

import PageFactory.carts;
import PageFactory.homepage;
import PageFactory.loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utilis.ConfigReader;
import utilis.elementutilis;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class scenariopassant {
    WebDriver driver;
    loginpage login;

    homepage home;
    carts cartpage;

    elementutilis element;

    Properties prop;
    ConfigReader site;

    @Given("Je me rends sur le site SwagLabs")
    public void je_me_rends_sur_le_site_swag_labs() {
        site=new ConfigReader();
        prop=site.ConfigurationManager();

        driver=new ChromeDriver();
        driver.get(site.geturl());
        driver.manage().window().maximize();

    }
    @When("Je saisie le username")
    public void je_saisie_le_username() {
        login=new loginpage(driver);
        login.setUsername(site.getusername());

    }
    @And("Je saisie le password")
    public void je_saisie_le_password() {
        login.setPassword(site.getpassword());

    }
    @And("Je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_login() {
        login.setLoginbutton();

    }
    @Then("La page des produit s affichent")
    public void la_page_des_produit_s_affichent() {

        element=new elementutilis(driver);
        element.confirmation("https://www.saucedemo.com/inventory.html");

    }
    @When("Je clique sur le bouton Add to cart du produit BackPack")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_back_pack() {

        home=new homepage(driver);
        home.setAddbaxkpack();


    }
    @And("Je clique sur le bouton Add to cart du produit T-Shirt")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_t_shirt() {
         home.setAddtshirt();


    }
    @Then("Les produit s ajoutent dans le panier")
    public void les_produit_s_ajoutent_dans_le_panier() {

        element=new elementutilis(driver);

        element.validation("Remove");

    }
    @When("Je clique sur l icone panier")
    public void je_clique_sur_l_icone_panier() {

        home.setCart();
    }
    @And("Je clique sur le bouton remove")
    public void je_clique_sur_le_bouton_remove() {


     cartpage=new carts(driver);
     cartpage.setRemvoepro1();

    }
    @Then("Le produit sera supprimé du panier")
    public void le_produit_sera_supprimé_du_panier() {

        element=new elementutilis(driver);
        element.validation("Sauce Labs Backpack");
    }


    @When("Je clique sur le bouton checkout")
    public void je_clique_sur_le_bouton_checkout() {
        cartpage=new carts(driver);
        cartpage.setBtnchekout();
    }
    @When("Je rempli le username")
    public void je_rempli_le_username() {
       cartpage.setFirstname("rayhane");
    }
    @When("Je saisie le lastname")
    public void je_saisie_le_lastname() {
        cartpage.setLastname("jelassi");
    }
    @And("Je saisie le code postal")
    public void je_saisie_le_code_postal() {
       cartpage.setPostalcode("5011");
    }
    @And("je clique sur le bouton continue")
    public void je_clique_sur_le_bouton_continue() {

        cartpage.setBtncontinue();
    }
    @Then("une page overview s affiche")
    public void une_page_overview_s_affiche() {

        element=new elementutilis(driver);
        element.validation("Checkout: Overview");

    }
    @When("je clique sur le bouton finish")
    public void je_clique_sur_le_bouton_finish() {

        element.javaScriptscrollToBottom();


    }
    @Then("une page Checkout:Complete s affiche")
    public void une_page_checkout_complete_s_affiche() {

        element.validation("Checkout: Complete!");
    }

    @When("Je clique sur le menu burger")
    public void je_clique_sur_le_menu_burger() {
        home=new homepage(driver);
        home.setMenu();

    }
    @And("Je clique surle bouton Logout")
    public void je_clique_surle_bouton_logout() throws InterruptedException {
        Thread.sleep(2000);

       home.setLogout();

    }
    @Then("Je me redirige vers la page d authentification {string}")
    public void je_me_redirige_vers_la_page_d_authentification(String string) {


      element=new elementutilis(driver);

        element.confirmation("https://www.saucedemo.com/");


    }




}
