package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    public void launchBrowser() throws InterruptedException {
//Selenium code-

        //Implement methods for webdriver -> Invoke .exe file
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

        //Create driver object
        WebDriver driver = new ChromeDriver();
        //The code below will Launch browser
        driver.get("http://demo.guru99.com/test/newtours");
        //Maximize Browser Window
        driver.manage().window().maximize();
        //Wait for 10 seconds for all elements to appear on the page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

        //Get title of the page.
        System.out.println("*** Gets Page Title ***");
        System.out.println(driver.getTitle());

        //IDENTIFYING ELEMENTS
        //Find element by LINK TEXT then click on "Register"
        driver.findElement(By.linkText("REGISTER")).click();

        //Register User by Entering users details
        driver.findElement(By.name("firstName")).sendKeys("Aisha");
        driver.findElement(By.name("lastName")).sendKeys("Hlatshwayo");
        driver.findElement(By.name("phone")).sendKeys("0710191715");
        driver.findElement(By.id("userName")).sendKeys("ash.hlatshwayo22@gmail.com");
        driver.findElement(By.name("address1")).sendKeys("48 Brietta Street, Ridgeway Ext4");
        driver.findElement(By.name("city")).sendKeys("Johannesburg");
        driver.findElement(By.name("state")).sendKeys("Gauteng");
        driver.findElement(By.name("postalCode")).sendKeys("2091");

        //Dropdown with select tag
        Select dropdown = new Select(driver.findElement(By.name("country")));
        dropdown.selectByVisibleText("SOUTH AFRICA");
        Thread.sleep(4000);

        //Creating "Username & Password"
        driver.findElement(By.id("email")).sendKeys("ash.hlatshwayo22@gmail.com");
        driver.findElement(By.name("password")).sendKeys("2021@French");
        driver.findElement(By.name("confirmPassword")).sendKeys("2021@French");
        //Click on Submit Button
        driver.findElement(By.name("submit")).click();
        Thread.sleep(4000);

        //Sign-in as a "User"
        driver.findElement(By.linkText("sign-in")).click();
        Thread.sleep(4000);

        //Sign-in as a user using your "User Name and Password then click the submit button"
        driver.findElement(By.name("userName")).sendKeys("ash.hlatshwayo22@gmail.com");
        driver.findElement(By.name("password")).sendKeys("2021@French");
        driver.findElement(By.xpath("//tbody/tr[4]/td[1]/input[1]")).click();

        //GetText on Display screen
        System.out.println("*** Display screen ***");
        System.out.println(driver.findElement(By.xpath("//tbody//tr//td//h3")).getText());
        System.out.println(driver.findElement(By.xpath("//b[contains(text(),'Thank you for Loggin.')]"))
                .getText());

        //Go onto the Home page
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();

        //Click on flight to book flights
        driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();

        //UI Components UI controls in automation
        //Dropdown with select tag
        WebElement staticDropdown = driver.findElement(By.name("passCount"));

        //Handling Radio Buttons
        List<WebElement> checkButton1 = driver.findElements(By.name("tripType"));
        for (WebElement elementinlist : checkButton1)
        {
            System.out.println(elementinlist.getAttribute("value"));
        }
        driver.findElements(By.name("tripType")).get(0).click();

        //Selecting number of Passengers
        Select selectPassengers = new Select(staticDropdown);
        selectPassengers.selectByValue("3");

        //Selecting Departure
        Select selectDeparting = new Select(driver.findElement(By.name("fromPort")));
        selectDeparting.selectByVisibleText("New York");

        //Selecting on date, by Creating a list of elements and storing them one list
        WebElement[] dates1 = {driver.findElement(By.name("fromMonth")),driver.findElement(By
                .name("toDay")) };
        //Selecting Month of departure
        Select selectMonth = new Select(dates1[0]);
        selectMonth.selectByValue("6");

        Select  selectToDay = new Select(dates1[1]);
        selectToDay.selectByValue("3");

        //Selecting Arrival
        Select selectArriving = new Select(driver.findElement(By.name("toPort")));
        selectArriving.selectByVisibleText("Paris");

        //Selecting on date, by Creating a list of elements and storing them one list
        WebElement[] dates2 = {driver.findElement(By.name("fromMonth")),driver.findElement(By
                .name("toDay"))};
        //Selecting Month of departure
        Select selectMonth2 = new Select(dates2[0]);
        selectMonth2.selectByValue("6");

        Select  selectToDay2 = new Select(dates2[1]);
        selectToDay2.selectByValue("20");

        //Handling Radio Buttons
        List<WebElement> checkButton2 = driver.findElements(By.name("servClass"));
        for (WebElement elementinlist : checkButton2)
        {
            System.out.println(elementinlist.getAttribute("value"));
        }
        driver.findElements(By.name("servClass")).get(2).click();

        Select selectAirline = new Select(driver.findElement(By.name("airline")));
        selectAirline.selectByVisibleText("Blue Skies Airlines");

        //Click the continue button
        driver.findElement(By.name("findFlights")).click();

        //Get text on display screen
        System.out.println("*** Get text on display screen ***");
        System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[1]"))
                .getText());
        System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td[1]/p[1]/font[1]/b[1]/font[3]/font[2]"))
        .getText());

        driver.findElement(By.xpath("//tbody/tr[2]/td[1]/a[1]/img[1]")).click();
    }
}
