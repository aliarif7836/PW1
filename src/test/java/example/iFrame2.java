package example;

import com.microsoft.playwright.*;
import Utils.ExcelUtils;

public class iFrame2 {

    public static void main(String[] args) throws Exception {

        // Load Excel
        ExcelUtils.loadExcel("testdata/LoginData.xlsx", "Sheet1");

        String firstName = ExcelUtils.getCellData(1, 0);
        String lastName  = ExcelUtils.getCellData(1, 1);
        String gender    = ExcelUtils.getCellData(1, 2);
        String email     = ExcelUtils.getCellData(1, 3);
        String age       = ExcelUtils.getCellData(1, 4);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext bct = browser.newContext();
        Page p = bct.newPage();

        p.navigate("https://vinothqaacademy.com/iframe/");

        FrameLocator iframe = p.frameLocator("//iframe[@name='registeruser']");

        iframe.locator("#vfb-5").fill(firstName);
        iframe.locator("#vfb-7").fill(lastName);
        iframe.locator("text=" + gender).first().click();
        iframe.locator("#vfb-14").fill(email);
        iframe.locator("#vfb-3").fill(age);
        iframe.locator("text=Submit").click();

        String text = iframe.locator("#messageContainer").textContent();
        System.out.println("Original text is : " + text);

        String id = text.split(":")[1].trim();
        System.out.println("Transaction ID : " + id);

        playwright.close();
    }
}
