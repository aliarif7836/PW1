package org.example;

import com.microsoft.playwright.*;

import java.util.Scanner;

public class iframe {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bct = browser.newContext();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter First name");
        String userName = myObj.nextLine();

        Page p = bct.newPage();
        p.navigate("https://vinothqaacademy.com/iframe/");

        FrameLocator  iframe = p.frameLocator("//iframe[@name='registeruser']");

        iframe.locator("//input[@id='vfb-5']").fill(userName);
        iframe.locator("//input[@id='vfb-7']").fill("Ali");
        iframe.locator("text=Male").first().click();
        iframe.locator("#vfb-14").fill("arif.ali@yopmail.com");
        iframe.locator("//input[@id='vfb-3']").fill("33");
        iframe.locator("text=Submit").click();

        String text = iframe.locator("//div[@id='messageContainer']").textContent();
        System.out.println("Original text is : " + text);

        String[] parts = text.split(":");

        // trim() removes the leading space before the number
        String id = parts[1].trim();

        System.out.println("Here is your transaction id : " + id);








    }
}
