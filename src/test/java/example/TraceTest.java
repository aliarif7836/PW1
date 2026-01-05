package example;

import com.microsoft.playwright.Playwright;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class TraceTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses").setExact(true)).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).fill("Arif Ali");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).fill("arif.ali@gmail.com");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).fill("12345678");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("India: +")).click();
            page.locator("#microfe-popup-login").contentFrame().getByText("India", new FrameLocator.GetByTextOptions().setExact(true)).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).fill("+91 99990-008899");
            page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }

    public static class ExcelUtils {

        private static Workbook workbook;
        private static Sheet sheet;

        public static void loadExcel(String path, String sheetName) throws IOException {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        }

        public static String getCellData(int row, int col) {
            Cell cell = sheet.getRow(row).getCell(col);
            return cell.toString();
        }

        public static int getRowCount() {
            return sheet.getLastRowNum();
        }
    }
}