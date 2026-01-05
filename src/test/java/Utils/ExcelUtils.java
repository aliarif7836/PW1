package Utils;

import org.apache.poi.ss.usermodel.*;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtils {

    private static Sheet sheet;

    public static void loadExcel(String filePath, String sheetName) throws Exception {
        InputStream is = ExcelUtils.class
                .getClassLoader()
                .getResourceAsStream(filePath);

        Workbook workbook = WorkbookFactory.create(is);
        sheet = workbook.getSheet(sheetName);
    }

    public static String getCellData(int row, int col) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(col));
    }

}
