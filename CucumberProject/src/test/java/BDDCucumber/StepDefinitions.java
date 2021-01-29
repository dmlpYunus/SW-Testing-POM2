package BDDCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class StepDefinitions  {
    WebDriver driver;
    WebDriverWait wait;
    int cartSize;
    int addedIntoCart =0;

    @Given("I am on the login Page of Sauce demo")
    public void i_am_on_the_login_page_of_sauce_demo(){
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-button")));
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password(){
        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys("standard_user");
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

    }

    @Then("I should be taken to Inventory Page")
    public void i_should_be_taken_to_inventory_page() {
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
    }



    @Given ("I am on the Inventory Page of Sauce demo")
    public void i_am_on_the_inventory_page_of_sauce_demo(){
        /*System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/inventory.html");*/

        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }

    }

    @When("I add first item on the list")
    public void ı_add_first_item_on_the_list() {
        List<WebElement> products =  driver.findElements(By.className("inventory_item_name"));
        products.get(0).click();
    }


    @Then("Added successfully")
    public void added_successfully(){
        WebElement addCartButton =  driver.findElement(By.xpath("//*[contains(@class,'btn_primary btn_inventory')]"));
        addCartButton.click();
        addedIntoCart ++;
    }

    @Given("I am on the Inventory Item Page of Sauce Demo")
    public void i_am_on_the_inventory_item_page_of_sauce_demo(){
       /* System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/inventory.html");*/
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
    }

    @When ("I click to cart image")
    public void i_click_to_cart_image(){
        WebElement shoppingCartButton = driver.findElement(By.xpath("//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]"));
        shoppingCartButton.click();
    }

    @Then("I should be taken to Cart Page")
    public void i_should_be_taken_to_cart_page(){
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }

    }

    @Given("I am on the Cart Page")
    public void i_am_on_the_cart_page(){
         System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/cart.html");



        /*try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }*/
    }

    @When("I need to find the items on the list")
    public void i_need_to_find_the_items_on_the_list(){
        List <WebElement> itemsOnCharts = driver.findElements(By.className("inventory_item_name"));
        cartSize = itemsOnCharts.size();
    }

    @Then("I need to verify if they are on the cart")
    public void i_need_to_verify_if_they_on_the_cart(){
        Assert.assertEquals(addedIntoCart,cartSize);
    }

    @When("I need to click checkout button")
    public void i_need_to_click_checkout_button(){
        WebElement checkout=driver.findElement(By.xpath("//*[contains(@class,'btn_action checkout_button')]"));
        checkout.click();
    }
    @Then("I should be taken to Checkout Page")
    public void i_should_be_taken_to_checkout_page(){
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        /*
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-one.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }*/
    }

    @Given("I am on the Checkout Page")
    public void i_am_on_the_checkout_page(){
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/checkout-step-one.html");

        /*try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-one.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());*/
        }



    @When("I need fill the information blanks and finish shopping")
    public void i_need_fill_the_information_blanks_and_finish_shopping(){
        WebElement firstNameTextField = driver.findElement(By.id("first-name"));
        WebElement lastNameTextField = driver.findElement(By.id("last-name"));
        WebElement postalCodeTextField = driver.findElement(By.id("postal-code"));
        firstNameTextField.sendKeys("Yunus");
        lastNameTextField.sendKeys("Dumlupınar");
        postalCodeTextField.sendKeys("yunus@dumlupinar.com");
        WebElement continueButton = driver.findElement(By.xpath("//*[contains(@class,'btn_primary cart_button')]"));
        continueButton.click();
        /*try {
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-two.html"));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }*/
        WebElement finishButton=driver.findElement(By.xpath("//*[contains(@class,'btn_action cart_button')]"));
        finishButton.click();
    }

    @Then("I should log out")
    public void i_should_log_out(){
        WebElement menu = driver.findElement(By.className("bm-burger-button"));
        menu.click();
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();
    }





}
