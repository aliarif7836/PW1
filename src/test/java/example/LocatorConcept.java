package example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import java.util.List;

public class LocatorConcept {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
       // Page page = browser.newPage();
        BrowserContext brct = browser.newContext();
        Page p = brct.newPage();
        p.navigate("https://www.orangehrm.com/en/30-day-free-trial");
        // Single element
//        Locator l = p.locator("text = Login");
//        int cnt = l.count();
//        System.out.println(cnt);
//        l.first().hover();
//        //l.first().waitFor();
//        l.first().click();

        Locator l1 = p.locator("#CybotCookiebotBannerCloseButtonE2E");
        l1.waitFor();
        l1.click();


        // Multiple element
        Locator countryOptions = p.locator("#Form_getForm_Country");
        String targetCountry = "India";
        //countryOptions.waitFor();

//        int cnt  = countryOptions.count();
//        System.out.println(cnt);
//        for(int i=0; i<cnt;i++)
//        {
//            String s = countryOptions.nth(i).textContent();
//            System.out.print(s);
//        }

        List<String> optionList= countryOptions.allTextContents();
        for (String e:optionList)
        {
            System.out.print(e);
        }
//
        countryOptions.waitFor();


        countryOptions.selectOption(targetCountry);
        Locator l2 = p.locator("#Form_getForm_subdomain");
        l2.click();
        l2.fill("Arif");


    }
}
