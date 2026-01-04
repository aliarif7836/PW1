package org.example;

import com.microsoft.playwright.*;

import javax.xml.stream.Location;

public class textSelector {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bcnt = browser.newContext();
        Page page = bcnt.newPage();
       //page.navigate("https://demo.opencart.com/index.php?route=account/login");
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
       //  Locating the close button on pop-up
        // Pauses the execution for 5 seconds (5000ms)
        page.waitForTimeout(5000);
        Locator popUP = page.locator("#CybotCookiebotBannerCloseButtonE2E");

        popUP.waitFor();
        popUP.click(new Locator.ClickOptions().setForce(true));
        System.out.println("popup is closed ✅");
//        Locator l2 = page.locator("#Form_getForm_subdomain");
//        l2.click();
//        l2.fill("Arif");
//       Locator contactBtn = page.locator("text=Contact Sales");
//       for(int i=0;i<contactBtn.count();i++)
//       {
//           String button = contactBtn.nth(i).textContent();
//           if(button.contains("Contact Sales"))
//           {
//               contactBtn.nth(i).click();
//               break;
//           }
//       }
       //contactBtn.waitFor();

      // contactBtn.click();
        String s = page.locator("div.form-main-menu h3:has-text('Start Your')").textContent();

        System.out.println(s);

       String header =  page.locator("'Solutions'").first().textContent();
        System.out.println(header);

        page.locator("p button:has-text('Get Your Free Trial')").click();

    }

}
