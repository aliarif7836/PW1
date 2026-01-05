package example;

import com.microsoft.playwright.*;

import javax.xml.stream.Location;
import java.util.Collections;

public class RoboBypass {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()){
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setArgs(Collections.singletonList("--disable-blink-features=AutomationControlled")));

        BrowserContext bcnt = browser.newContext(new Browser.NewContextOptions().setUserAgent("Safari/537.36"));
        Page page = bcnt.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login");


        Locator text = page.locator("h2:has-text('New Customer')");
        text.waitFor(new Locator.WaitForOptions().setTimeout(10000));
        String s = text.textContent();
        System.out.println(s);
    }
        catch (TimeoutError e)
        {
            System.out.println(e);
        }

//        String header =  page.locator("'Solutions'").first().textContent();
//        System.out.println(header);
    }
}
