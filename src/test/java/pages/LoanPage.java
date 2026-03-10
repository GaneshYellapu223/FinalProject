package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoanPage extends BasePage {
    public LoanPage(WebDriver driver){super(driver);}
    @FindBy(xpath="//*[@id=\"panel-7-1-2-0\"]/div/div")
    public WebElement LoanCalBtn;
    @FindBy(xpath="//*[@id=\"loanamount\"]")
    public WebElement LoanTextBox;
    @FindBy(xpath="//div[@id='loanamountslider']/span")
    public WebElement LoanSlider;
    @FindBy(xpath="//*[@id=\"loaninterest\"]")
    public WebElement InterestTextBox;
    @FindBy(xpath="//*[@id='loaninterestslider']/span")
    public WebElement InterestSlider;
    @FindBy(xpath="//*[@id=\"loanterm\"]")
    public WebElement TenureTextBox;
    @FindBy(xpath="//*[@id=\"loantermslider\"]/span")
    public WebElement TenureSlider;
    @FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")
    public WebElement MonthBtn;
    @FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]")
    public WebElement YearBtn;
    @FindBy(xpath="//*[@id=\"loanfees\"]")
    public WebElement ChargesTextBox;
    @FindBy(xpath="//*[@id=\"loanfeesslider\"]/span")
    public WebElement Chargesslider;
    //==========================================================
    @FindBy(xpath="//*[@id=\"loan-amount-calc\"]/a[1]")
    public WebElement LoanAmtCalBtn;
    @FindBy(xpath="//input[@id=\"loanemi\"]")
    public WebElement EmiTextBox;
    @FindBy(xpath="//*[@id=\"loanemislider\"]/span")
    public WebElement EmiSlider;
    //===========================
    @FindBy(xpath="//*[@id=\"loan-tenure-calc\"]/a[1]")
    public WebElement LoanTenureCalBtn;

    public void scrollTOTop(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

    }
    public String getClassAttribute(WebElement element){
        return element.getAttribute("class");
    }
    public String sliderCheck(WebElement element) {
        Actions move = new Actions(driver);
        move.dragAndDropBy(element, 50, 0).perform();
        String ans=element.getAttribute("style");
        return ans;
    }

}
