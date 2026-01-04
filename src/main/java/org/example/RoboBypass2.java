package org.example;

import com.microsoft.playwright.*;
import java.util.Collections;

public class RoboBypass2 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // 1. Launch Headed (Headless is the #1 signal for bots)
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    // Optional: Add arguments to disable typical automation flags
                    .setArgs(Collections.singletonList("--disable-blink-features=AutomationControlled")));

            // 2. Configure a Realistic Context
            BrowserContext bcnt = browser.newContext(new Browser.NewContextOptions()
                    .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                    .setViewportSize(1920, 1080)
                    .setDeviceScaleFactor(1));

            // 3. STEALTH INJECTION: Overwrite the webdriver property
            // This script runs on every page load before any other script
            bcnt.addInitScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

            Page page = bcnt.newPage();

            System.out.println("🚀 Navigating to OpenCart...");
            page.navigate("https://demo.opencart.com/index.php?route=account/login");

            try {
                // Use a visible locator check
                Locator text = page.locator("h2:has-text('New Customer')");
                text.waitFor(new Locator.WaitForOptions().setTimeout(15000));

                System.out.println("✅ Success! Page content detected: " + text.textContent());
            } catch (TimeoutError e) {
                System.out.println("⚠️ Still blocked. If a CAPTCHA appeared, solve it manually now...");
                // Keep browser open for 30 seconds to allow manual solving if needed
                page.waitForTimeout(30000);
            }

            browser.close();
        }
    }
}