package org.example;

import com.microsoft.playwright.*;
// Removed unused imports for a cleaner class

import java.util.List;

public class LocatorConcept1 {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             BrowserContext brct = browser.newContext()) {

            Page p = brct.newPage();
            p.navigate("https://www.orangehrm.com/en/30-day-free-trial");

            // --- 1. HANDLE COOKIE POP-UP ---
            Locator cookieLocator = p.locator("#CybotCookiebotBannerCloseButtonE2E");

            // Wait for it, then force the click (robust cookie handling)
            cookieLocator.waitFor();
            cookieLocator.click(new Locator.ClickOptions().setForce(true));
            System.out.println("✅ Cookie banner closed successfully.");

            // --- 2. CORRECT COUNTRY DROPDOWN INTERACTION ---

            // The correct locator targets the unique SELECT element itself (ID: Form_getForm_Country)
            Locator countryDropdown = p.locator("#Form_getForm_Country");

            System.out.println("D1: Checking Country Dropdown...");

            // We can still print all options for debugging, but we use the correct locator:
            // This is valid, but slow.
            // List<String> optionList = countryDropdown.locator("option").allTextContents();
            // System.out.println("Total Options: " + optionList.size());
            // System.out.println("All Options: " + String.join(", ", optionList.subList(0, 5)) + "...");

            // --- FIX FOR SELECTION ---

            String targetCountry = "India";

            // Use waitFor() on the main dropdown to ensure it's loaded after the popup closes.
            countryDropdown.waitFor();
            System.out.println("D4: Dropdown is ready.");

            // CORRECT API USAGE: Use selectOption() on the SELECT element's locator.
            // This bypasses the need for clicking individual options.
            countryDropdown.selectOption(targetCountry);

            System.out.println("✅ Selected Country: " + targetCountry);

            // --- 3. HANDLE SUBDOMAIN FIELD ---

            Locator subdomainField = p.locator("#Form_getForm_subdomain");

            // Subdomain is a regular input field, use fill()
            subdomainField.click(); // Optional, fill() implies click
            subdomainField.fill("Arifff");

            System.out.println("D3: Subdomain field filled.");


        } catch (PlaywrightException e) {
            System.err.println("Playwright Automation Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}