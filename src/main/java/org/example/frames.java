package org.example;

import com.microsoft.playwright.*;

public class frames {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext cnt = browser.newContext();
        Page page = cnt.newPage();
        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

//        String Heading = page.frameLocator("frame[name='navbar']").locator("h3:has-text('Navigation')").textContent();
//        System.out.println(Heading);

        String Heading1 = page.frame("navbar").locator("h3").textContent();
        System.out.println(Heading1);
    }
}
