package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ExcelPage;
import pages.HomePage;
import pages.LoanPage;
import utilities.ExtentReportUtility;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    HomePage homePage;
    ExcelPage excelPage;
    LoanPage loanPage;
    public Logger log=LogManager.getLogger(this.getClass());
    @BeforeClass
    public void setUpBrowser(){
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--headless=new");
//        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver=new ChromeDriver(options);
        ExtentReportUtility.setDriver(driver);
        driver.navigate().to("https://emicalculator.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage=new HomePage(driver);
        excelPage=new ExcelPage(driver);
        loanPage =new LoanPage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
