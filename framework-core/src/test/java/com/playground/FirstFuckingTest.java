package com.playground;

import com.dataload.PropertyLoader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class FirstFuckingTest extends BaseTest {

    @Test
    public void doSomeShit(){
        PropertyLoader.loadProperties();
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless( Boolean.parseBoolean(PropertyLoader.getProperty("browser.headless.mode"))));
            Page page = browser.newPage();
            page.navigate("https://www.google.com/");
            page.isVisible("//img[@class='lnXdpd']");
        }

    }

}
