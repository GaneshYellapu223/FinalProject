package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EMI_CalculatorTest extends BaseTest{
    @Test(priority = 1)
    public void validateEMICalculator_LoanAmount() throws InterruptedException {
        loanPage.scrollIntoView(loanPage.LoanCalBtn);
        loanPage.clickElement(loanPage.LoanCalBtn);
        String actualLoan=loanPage.enterData(loanPage.LoanTextBox,"2500000");
        Assert.assertEquals(actualLoan,"2500000");
        String actual=loanPage.sliderCheck(loanPage.LoanSlider);
        log.info(actual);
        Assert.assertEquals(actual,"left: 20.5%;");
    }
    @Test(priority = 2)
    public void validateEMICalculator_LoanInterest() throws InterruptedException {
        String actualInterest=loanPage.enterData(loanPage.InterestTextBox,"8.25");
        Assert.assertEquals(actualInterest,"8.25");
        String actual=loanPage.sliderCheck(loanPage.InterestSlider);
        Assert.assertEquals(actual,"left: 48.75%;");

    }
    @Test(priority = 3)
    public void validateEMICalculator_LoanTenure() throws InterruptedException {
        String actualInterest=loanPage.enterData(loanPage.TenureTextBox,"7");
        Assert.assertEquals(actualInterest,"7");
        String actual=loanPage.sliderCheck(loanPage.TenureSlider);
        Assert.assertEquals(actual,"left: 31.6667%;");

    }
    @Test(priority = 4)
    public void validateMonthBtn() throws InterruptedException {
        loanPage.clickElement(loanPage.MonthBtn);
        Assert.assertEquals(loanPage.getClassAttribute(loanPage.MonthBtn),"btn btn-secondary focus active");
    }
    @Test(priority = 5)
    public void validateEMICalculator_LoanCharges() throws InterruptedException {
        String actualInterest=loanPage.enterData(loanPage.ChargesTextBox,"8599");
        Assert.assertEquals(actualInterest,"8599");
        String actual=loanPage.sliderCheck(loanPage.Chargesslider);
        Assert.assertEquals(actual,"left: 16.5%;");

    }
}