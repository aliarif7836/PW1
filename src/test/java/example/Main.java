package example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Main {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);

        Browser browser = playwright.chromium().launch(lp);


        Page page = browser.newPage();
        page.pause();
        page.navigate("https://playwright.dev/java/docs/intro");
        String title = page.title();
        System.out.println(title);

        page.pause();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Writing tests").setExact(true)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Generating tests").setExact(true)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JUnit (experimental)")).click();

        String url = page.url();
        System.out.println("Url is " + url);
        // browser.close();
        // playwright.close();
    }
}