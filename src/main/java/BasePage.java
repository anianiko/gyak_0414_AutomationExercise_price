import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToWebElement(WebElement element) throws InterruptedException {
      //WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }


}
