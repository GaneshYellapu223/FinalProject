package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CarLoanTest extends BaseTest {
    @Test
    public void fillCarLoanDetails() {
        //HomePage hp=new HomePage(driver);
        log.info("CarLoan Test has started...");
        homePage.clickElement(homePage.carLoanBtn);
        homePage.enterData(homePage.amountTextBox,"1500000");
        homePage.enterData(homePage.interestTextBox,"9.5");
        homePage.enterData(homePage.loanTextBox,"1");
        homePage.scrollToView(homePage.tablePlus);
        homePage.clickElement(homePage.tablePlus);
        Assert.assertEquals(homePage.getAmount(homePage.principal),"₹ 1,19,650");
        Assert.assertEquals(homePage.getAmount(homePage.interest),"₹ 11,875");
        log.info("Principal Amount is:"+homePage.getAmount(homePage.principal));
        log.info("Interest Amount is:"+homePage.getAmount(homePage.interest));
        log.info("CarLoan Test has completed...");
    }


}
