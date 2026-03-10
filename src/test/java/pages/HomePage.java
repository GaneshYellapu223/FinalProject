package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){super(driver);}
    @FindBy(id="home-loan")
    public WebElement homeLoanBtn;

    @FindBy(id="car-loan")
    public WebElement carLoanBtn;

    @FindBy(xpath="//input[@id='loanamount']")
    public WebElement amountTextBox;

    @FindBy(xpath="//input[@id='loaninterest']")
    public WebElement interestTextBox;

    @FindBy(xpath="//input[@id='loanterm']")
    public WebElement loanTextBox;

    @FindBy(id="year2026")
    public WebElement tablePlus;

    @FindBy(xpath="(//td[@class='col-3 col-sm-2 currency'])[3]")
    public WebElement principal;

    @FindBy(xpath="(//td[@class='col-3 col-sm-2 currency'])[4]")
    public WebElement interest;

    public String getAmount(WebElement element){
        return element.getText();
    }

}
