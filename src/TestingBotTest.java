import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestingBotTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabillities = DesiredCapabilities.chrome();
        capabillities.setCapability("version", "latest");
        capabillities.setCapability("platform", Platform.WINDOWS);
        capabillities.setCapability("name", "Testing Selenium");

        driver = new RemoteWebDriver(new URL("https://9c9f7535089bb8d3093fc5bb8411b422:47211d5f1a1e158068b795c22938c946@hub.testingbot.com/wd/hub"),capabillities);
    }

    @Test
    public void testSimple() throws Exception {
        driver.get("http://localhost:2000/");
//        http://127.0.0.1:4445/        
//        String searchHeader = driver.findElement(By.cssSelector("H1")).getText().toLowerCase();
//        Assert.assertTrue(searchHeader.contains("Browser Testing"));
        driver.get("https://myswaastherp.sia.co.in/");
        driver.findElement(By.xpath("/html/body/app-root/div/app-onboarding/div/div/app-main/div[1]/div/div[1]/div[4]/ul/li/a")).click();
    }

    @AfterClass
    public void tearDown() throws Exception {
        ((RemoteWebDriver) driver).getSessionId();
        driver.quit();
    }
}
