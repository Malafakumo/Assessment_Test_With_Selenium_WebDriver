import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
    private WebDriver driver;

    @BeforeTest
    public void LaunchUrl() throws InterruptedException {
        //Locate the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open the browser
        driver = new ChromeDriver();
        //Input the Url
        driver.get("https://stage.outreach.sloovi.com/login");
        Thread.sleep(4000);
        //Test 1: Verify the Url
        String expectedUrl = "https://stage.outreach.sloovi.com/login";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("Current Url is:" + expectedUrl);
        else
            System.out.println("Wrong Url");
        //Maximize the page
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    //Login
    @Test(priority = 0)
    public void EmptyFields() throws InterruptedException {
        //Test 1: Verify Login with empty fields
        driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/form/div[2]/button")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void InvalidCredentials() throws InterruptedException {
        //Test 2: Verify Login with invalid credentials
        driver.findElement(By.name("email")).sendKeys("admin@dev.com");
        driver.findElement(By.name("password")).sendKeys("1234567A");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/form/div[2]/button")).click();
        String expectedMsg = "The email address and password does not match.";
        String actualMsg = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/form/div[2]")).getText();
        if (actualMsg.contains(expectedMsg))
            System.out.println("Passed");
        else System.out.println("Failed");
        Thread.sleep(4000);


    }

    @Test(priority = 4)
    public void ValidCredentials() throws InterruptedException {
        //Test 5: Verify Login with registered credentials
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();
        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys("smithwills1989@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345678");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/form/div[2]/button")).click();
        String expectedTitle = "Sloovi Outreach";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            System.out.println("Passed");
        else System.out.println("Failed");
        Thread.sleep(4000);

    }

    //Task Module
    @Test(priority = 5)
    public void LaunchTaskUrl() throws InterruptedException {
        //Launch the url
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open the browser
        driver = new ChromeDriver();
        //Input the Url
        driver.get("https://stage.outreach.sloovi.com/lead/lead_a17919191f614cd49d239da4d9596d9c");
        Thread.sleep(4000);

    }

    @Test(priority = 6)
    public void CreateTask() throws InterruptedException {
        //Create a Task
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/section/header/button/svg")).click();
        //Manually fill the form
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/section/section/ul/li[1]/div[2]/form/div/button[2]")).click();
        Thread.sleep(4000);
    }

    @Test(priority = 7)
    public void EditTask() throws InterruptedException {
        //Edit an existing task
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/section/section/ul/li[1]/div[1]/div[2]/div/button/svg/path")).click();
        //Manually fill the form
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/section/section/ul/li[1]/div[2]/form/div/button[2]")).click();
        Thread.sleep(4000);
    }

    @Test(priority = 8)
    public void DeleteTask() throws InterruptedException {
        //Delete a task
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/section/section/ul/li[1]/div[1]/div[2]/div/button/svg/path")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/section/section/ul/li[2]/div[2]/form/div/a/svg/path")).click();
        Thread.sleep(4000);

    }

    //Opportunity Module
    @Test(priority = 9)
    public void CreateOpportunity() throws InterruptedException {
        //Create a new opportunity
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/section/header/button/svg")).click();
        //Manually fill the form
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/section/section/ul/li[1]/div[2]/form/div[9]/div/button[2]")).click();
        Thread.sleep(3000);

    }

    @Test (priority = 10)
    public void EditOpportunity () throws InterruptedException {
        //Edit an existing opportunity
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/section/section/ul/li[1]/div[1]/div[1]/div[2]/button/svg")).click();
        //Manually edit the form
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/section/section/ul/li[1]/div[2]/form/div[9]/div/button[2]")).click();
        Thread.sleep(3000);

    }

    @Test (priority = 11)
    public void DeleteOpportunity () throws InterruptedException {
        //Delete an existing opportunity
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/section/section/ul/li/div[1]/div[1]/div[2]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/section/section/ul/li/div[1]/div[1]/div[2]/div/ul/li/span[2]")).click();
        //Manually click OK
        Thread.sleep(4000);

    }

    }


