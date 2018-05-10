# TestingBotTunnel

Whether you want to test your website on your local computer (localhost), on a staging server inside your private network or on a computer across VPN, our TestingBot Tunnel makes all of this possible in a secure and reliable way.


You will no longer need to open up ports on your firewall or whitelist our IP range to run tests on your staging environment. Below are some of the features of the TestingBot Tunnel:


Fast: at our end of the tunnel we keep a cache of static content, to reduce traffic inside the tunnel.

Secure: when you start the Tunnel, a pristine VM server is booted just for you and will last until you end the tunnel.

Robust: full HTTP(s) support, coded in Java

Easy: to set up and use.

Step:-

Step1:-Download the testingBot tunnel from this link:-

https://testingbot.com/support/other/tunnel

Step2:-extract the zip file.

Step3:-open the extracted file to find the testingbot-tunnel.jar file

Step4:-run the command to install the testingbot tunnel

java -jar testingbot-tunnel.jar 9c9f7535089bb8d3093fc5bb8411b422 47211d5f1a1e158068b795c22938c946

Step5:-now get your localhost address it may be like this:-

http://127.0.0.1:4445/

http://localhost:2000/

Step6:-now you can start your test with selenium and testNG.

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
        
        driver.get("https://myswaastherp.sia.co.in/");
        
        driver.findElement(By.xpath("/html/body/app-root/div/app-onboarding/div/div/app-main/div[1]/div/div[1]/div[4]/ul/li/a")).click();
    }

    @AfterClass
    public void tearDown() throws Exception {
    
        ((RemoteWebDriver) driver).getSessionId();
        
        driver.quit();
    }
}



