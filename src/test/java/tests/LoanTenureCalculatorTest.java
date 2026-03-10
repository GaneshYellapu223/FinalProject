package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoanTenureCalculatorTest extends BaseTest{
    @Test(priority = 0)
    public void validateLoanTenureIcon() throws InterruptedException {
        loanPage.scrollIntoView(loanPage.LoanCalBtn);
        loanPage.clickElement(loanPage.LoanCalBtn);
        loanPage.scrollTOTop();
        loanPage.clickElement(loanPage.LoanTenureCalBtn);
        Assert.assertTrue(loanPage.LoanTenureCalBtn.isDisplayed());
    }
    @Test(priority = 1)
    public void validateLoanTenureCalculator_LoanAmount() throws InterruptedException {

        String actualLoan=loanPage.enterData(loanPage.LoanTextBox,"1400000");
        Assert.assertEquals(actualLoan,"1400000");
        String actual=loanPage.sliderCheck(loanPage.LoanSlider);
        Assert.assertEquals(actual,"left: 15%;");
    }
    @Test(priority = 2)
    public void validateLoanTenureCalculator_EMI() throws InterruptedException {

        loanPage.clickElement(loanPage.EmiTextBox);
        String actualLoan=loanPage.enterData(loanPage.EmiTextBox,"35000");
        Assert.assertEquals(actualLoan,"34,976.52");
        String actual=loanPage.sliderCheck(loanPage.EmiSlider);
        Assert.assertEquals(actual,"left: 43%;");
    }
    @Test(priority = 3)
    public void validateLoanTenureCalculator_Interest() throws InterruptedException {
        String actualInterest=loanPage.enterData(loanPage.InterestTextBox,"6.75");
        Assert.assertEquals(actualInterest,"6.75");
        String actual=loanPage.sliderCheck(loanPage.InterestSlider);
        Assert.assertEquals(actual,"left: 41.25%;");

    }

    @Test(priority = 4)
    public void validateLoanTenureCalculator_Charges() throws InterruptedException {
        String actualInterest=loanPage.enterData(loanPage.ChargesTextBox,"4599");
        Assert.assertEquals(actualInterest,"4599");
        String actual=loanPage.sliderCheck(loanPage.Chargesslider);
        Assert.assertEquals(actual,"left: 12.5%;");

    }
}
