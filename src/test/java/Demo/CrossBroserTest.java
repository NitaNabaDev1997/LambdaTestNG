package Demo;

 

import java.net.MalformedURLException;

import java.net.URL;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.*;

public class CrossBroserTest{

public WebDriver driver;

private String username= "nabanita.debnath";

private String accessKey="Xg63p1mDOTpH0JqakFqYTSVV3PwNvkZujpxXWqCQxUzNGjHHuo";

private String hub="@hub.lambdatest.com/wd/hub";

String status = "failed";

 //boolean status = false;

@Parameters(value={"Browser","Version","Platform"})

@BeforeMethod

public void setUp(String browser,String version, String platform)

{

    DesiredCapabilities caps = new DesiredCapabilities();

    //DesiredCapabilities capability = new DesiredCapabilities();

caps.setCapability("build", "2.3");

caps.setCapability("name", "CrossBroserTest");

caps.setCapability("browserName", browser);

//caps.setCapability("version", version);

caps.setCapability("platformName", platform);

caps.setBrowserName(browser);

caps.setVersion(version);

caps.setCapability("network", true);
caps.setCapability("console", true);

caps.setCapability("visual", true);

//caps.setCapability("w3c", false);*/

 

 

 

 

 

/*capability.setCapability(CapabilityType.BROWSER_NAME, browser);

capability.setCapability(CapabilityType.VERSION,version);

capability.setCapability(CapabilityType.PLATFORM, platform);

            

capability.setCapability("build", "LambdaTest Sample Build");

 

capability.setCapability("network", true);

capability.setCapability("video", true);

capability.setCapability("console", true);

capability.setCapability("visual", true);*/

 

try {

    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub),caps);

}

catch(MalformedURLException exc) {

    exc.printStackTrace();

}

 

driver.get("https://lambdatest.github.io/sample-todo-app/");

}

 

@Test

public void testSimple() {

    driver.findElement(By.name("li1")).click();

    driver.findElement(By.name("li2")).click();

    driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");

    driver.findElement(By.id("addbutton")).click();
    
    status = "passed";

   }

 

@AfterMethod

public void tearDown() throws Exception {

    if (driver != null) {

         ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

         driver.quit();

     }

}

 

}