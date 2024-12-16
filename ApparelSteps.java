import packege Assessment;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class ApparelSteps {
    WebDriver driver;

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("I select the {string} category")
    public void iSelectTheCategory(String category) {
        WebElement apparelCategory = driver.findElement(By.linkText(category));
        apparelCategory.click();
    }

    @When("I sort products by {string}")
    public void iSortProductsBy(String sortOption) {
        WebElement sortDropdown = driver.findElement(By.id("sort"));
        sortDropdown.sendKeys(sortOption);
    }

    @When("I select a product and add it to the cart")
    public void iSelectAProductAndAddItToTheCart() {
        WebElement product = driver.findElement(By.cssSelector(".productgrid a"));
        product.click();
        WebElement addToCartButton = driver.findElement(By.id("add_to_cart"));
        addToCartButton.click();
    }

    @Then("I verify the product is successfully added to the cart")
    public void iVerifyTheProductIsSuccessfullyAddedToTheCart() {
        WebElement cartMessage = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(cartMessage.getText().contains("added to your cart"));
        driver.quit();
    }
}
