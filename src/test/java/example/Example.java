package example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://testautomationpractice.blogspot.com/");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Name")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Name")).fill("Arif");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter EMail")).fill("test@gmail.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Phone")).fill("9988998899");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Address:")).fill("address, test");
            page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Male").setExact(true)).check();
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Sunday")).check();
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Monday")).check();
            page.getByLabel("Country:").selectOption("india");
            page.getByLabel("Colors:").selectOption("green");
            page.getByLabel("Sorted List:").selectOption("lion");
            page.locator("#datepicker").click();
            page.locator("#ui-datepicker-div").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("4").setExact(true)).click();
            page.locator("#txtDate").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("6").setExact(true)).click();
            page.getByPlaceholder("Start Date").fill("2025-12-18");
            page.getByPlaceholder("End Date").fill("2025-12-20");
            page.locator("#post-body-1307673142697428135").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Submit")).click();

        }
    }
}