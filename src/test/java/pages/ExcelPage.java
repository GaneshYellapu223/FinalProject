package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utilities.ExcelUtils.*;

public class ExcelPage extends HomePage{
    public ExcelPage (WebDriver driver){super(driver);}
    @FindBy(id="home-loan")
    public WebElement homeLoanBtn;
    @FindBy(id="emipaymenttable")
    public WebElement table;

    public void ExecuteExcel(WebElement table) throws InterruptedException {
        int num=2026;
        for(int i=0;i<=20;i++){
            int plus=num+i;
            String ans=Integer.toString(plus);
            scrollIntoTable2(driver,"year"+ans);
            driver.findElement(By.id("year"+ans)).click();
            Thread.sleep(200);

        }
        // Usage:
        List<List<String>> tableData=generateXcel(table);
        writeToNewExcel(tableData, "output/TableData4.xlsx", "Table");
    }
}
