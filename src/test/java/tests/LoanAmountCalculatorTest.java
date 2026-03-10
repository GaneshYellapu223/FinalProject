package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanAmountCalculatorTest extends BaseTest {

    @Test(priority = 0)
    public void validateLoanAmtCalBtn() throws InterruptedException {
        loanPage.scrollIntoView(loanPage.LoanCalBtn);
        loanPage.clickElement(loanPage.LoanCalBtn);
//        loanPage.scrollIntoView(loanPage.LoanAmtCalBtn);
        loanPage.scrollTOTop();
        loanPage.clickElement(loanPage.LoanAmtCalBtn);
        Assert.assertTrue(loanPage.LoanAmtCalBtn.isDisplayed());
    }

    @Test(priority = 1)
    public void validateLoanAmountCalculator_EMI() throws InterruptedException {

        loanPage.clickElement(loanPage.EmiTextBox);
        String actualLoan=loanPage.enterData(loanPage.EmiTextBox,"25440");
        Assert.assertEquals(actualLoan,"25,440.01");
        String actual=loanPage.sliderCheck(loanPage.EmiSlider);
        Assert.assertEquals(actual,"left: 33.5%;");
    }
    @Test(priority = 2)
    public void validateLoanAmountCalculator_Interest()  {
        String actualInterest=loanPage.enterData(loanPage.InterestTextBox,"6.25");
        Assert.assertEquals(actualInterest,"6.25");
        String actual=loanPage.sliderCheck(loanPage.InterestSlider);
        Assert.assertEquals(actual,"left: 38.75%;");

    }
    @Test(priority = 3)
    public void validateLoanAmountCalculator_Tenure() {
        String actualInterest=loanPage.enterData(loanPage.TenureTextBox,"4");
        Assert.assertEquals(actualInterest,"4");
        String actual=loanPage.sliderCheck(loanPage.TenureSlider);
        Assert.assertEquals(actual,"left: 21.6667%;");

    }
    @Test(priority = 4)
    public void validateYearBtn() {
        loanPage.clickElement(loanPage.YearBtn);
        Assert.assertEquals(loanPage.getClassAttribute(loanPage.YearBtn),"btn btn-secondary active focus");
    }
    @Test(priority = 5)
    public void validateLoanAmountCalculator_Charges()  {
        String actualInterest=loanPage.enterData(loanPage.ChargesTextBox,"8599");
        Assert.assertEquals(actualInterest,"8599");
        String actual=loanPage.sliderCheck(loanPage.Chargesslider);
        Assert.assertEquals(actual,"left: 16.5%;");

    }

}
