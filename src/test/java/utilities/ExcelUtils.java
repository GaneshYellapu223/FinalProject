package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static List<List<String>> extractTable2D(WebElement table) {
        List<List<String>> data = new ArrayList<>();

        // Read header (th)
        List<WebElement> headers = table.findElements(By.cssSelector("th"));
        if (!headers.isEmpty()) {
            List<String> headerRow = new ArrayList<>();
            for (WebElement h : headers) headerRow.add(h.getText());
            data.add(headerRow);
        }

        // Read body rows (td)
        List<WebElement> rows = table.findElements(By.cssSelector("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector("td"));
            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) rowData.add(cell.getText());
            data.add(rowData);
        }
        return data;
    }
    public static List<List<String>> generateXcel(WebElement table){
//        WebElement table = driver.findElement(By.id("emipaymenttable"));
//        System.out.println(table.getText());
        List<List<String>> tableData = extractTable2D(table);
        return tableData;
    }



    public static void  scrollIntoTable2(WebDriver driver,String path){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
    }


    public static void writeToNewExcel(List<List<String>> data, String filePath, String sheetName) {
        // Create workbook + sheet
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);

            // Write rows & cells
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);

                List<String> rowData = data.get(i);
                for (int j = 0; j < rowData.size(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(rowData.get(j));
                }
            }

            // Auto-size columns (optional)
            if (!data.isEmpty()) {
                for (int col = 0; col < data.get(0).size(); col++) {
                    sheet.autoSizeColumn(col);
                }
            }

            // Ensure folder exists
            Path parent = Path.of(filePath).getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }

            // Save Excel file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

            System.out.println("Excel created successfully: " + filePath);

        } catch (IOException e) {
            throw new RuntimeException("Failed to create Excel: " + e.getMessage(), e);
        }
    }
}
