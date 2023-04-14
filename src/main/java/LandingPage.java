import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LandingPage extends BasePage {

    private final String URL = "https://automationexercise.com/";

    private final By itemCards = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

    //konstruktor
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void navigate(){
        driver.navigate().to(URL);
    }

    public boolean findProductCards() throws InterruptedException {
        List<WebElement> products = driver.findElements(itemCards);
        for(WebElement product : products){
            WebElement priceElement = product.findElement(By.xpath("./div/div/h2"));
            String price = priceElement.getText();
            scrollToWebElement(priceElement);
            Actions actions = new Actions(driver);
            actions.moveToElement(priceElement).perform();
            Thread.sleep(1000);

            WebElement overlayElement = product.findElement(By.xpath(".//div[@class='product-overlay']//h2"));
            String overlayPrice = overlayElement.getText();

            if (!price.equals(overlayPrice)){
                return false;
            }
        }
        return true;
    }


}
