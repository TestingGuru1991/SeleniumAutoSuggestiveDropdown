import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args){
        System.setProperty("webdriver.driver.chrome", "C:\\Program Files\\Web Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //go to web site
        driver.get("https://www.ksrtc.in/oprs-web/");

        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"fromPlaceName\").value";
        String text = (String) js.executeScript(script);

        int i = 0;
        while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
            i++;
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
            System.out.println(text);
            if(i>10) {
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
        if(i>10){
            System.out.println("Element not found.");
        }
    }
}
