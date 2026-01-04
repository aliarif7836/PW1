package org.example;

import com.microsoft.playwright.*;

public class Browser_Context {
    public static void main(String[] args) {

        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser br2 = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));


        BrowserContext bcxt1 = br.newContext();
        Page p1 = bcxt1.newPage();
        p1.navigate("https://academy.naveenautomationlabs.com/");
        //p1.fill("#text","Arif");
        String P1t = p1.title();
        System.out.println(P1t);

        BrowserContext bcxt2 = br.newContext();
        Page p2 = bcxt2.newPage();
        p2.navigate("https://www.orangehrm.com/");
        p2.fill("#Form_submitForm_EmailHomePage","Arif_Ali");
        String P2t = p2.title();
        System.out.println(P2t);

        BrowserContext bcxt3 = br2.newContext();
        Page p3 = bcxt3.newPage();
        p3.navigate("https://www.orangehrm.com/");
        p3.fill("#Form_submitForm_EmailHomePage","Arif_Ali");
        String P3t = p3.title();
        System.out.println(P3t);

    }
}