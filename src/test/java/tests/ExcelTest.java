package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExcelPage;

public class ExcelTest extends BaseTest {
    @Test
    public void getExcelFIle() throws InterruptedException {
        excelPage.clickElement(excelPage.homeLoanBtn);
        excelPage.scrollToView(excelPage.table);
        excelPage.ExecuteExcel(excelPage.table);
    }
}
