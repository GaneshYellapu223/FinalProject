package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String enterData(WebElement element, String data){
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE), data);
        element.sendKeys(Keys.ENTER);
        return element.getAttribute("value");
    }
    public void scrollToView(WebElement element){
        element=driver.findElement(By.id("year2026"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElement(WebElement element){
        element.click();
    }



}
