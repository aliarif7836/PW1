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
      page.navigate("https://www.google.com/");
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
      page.getByText("bihar board model paper 2026 class").click();
      page.locator("iframe[name=\"a-uviljzllxp9s\"]").contentFrame().getByRole(AriaRole.CHECKBOX, new FrameLocator.GetByRoleOptions().setName("I'm not a robot")).click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"5\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"9\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"10\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"13\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"5\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"1\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Verify")).click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"8\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"5\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().locator("[id=\"0\"]").click();
      page.locator("iframe[name=\"c-uviljzllxp9s\"]").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Verify")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hindi Class 12 Official Model")).click();
      page.close();
    }
  }
}