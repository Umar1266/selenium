package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchTest {

    private WebDriver driver;

    @BeforeClass
    // public void setUp() {
    //     // 🧹 Clear old ChromeDriver cache
    //     WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache();

    //     // 🧩 Auto-download matching ChromeDriver for your current Chrome (v142)
    //     WebDriverManager.chromedriver().setup();

    //     ChromeOptions options = new ChromeOptions();
    //     options.addArguments("--start-maximized");
    //     options.addArguments("--disable-gpu");
    //     options.addArguments("--no-sandbox");
    //     options.addArguments("--disable-dev-shm-usage");
    //     options.addArguments("--window-size=1920,1080");
    //     options.addArguments("--remote-allow-origins=*");

    //     driver = new ChromeDriver(options);
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //     // ✅ Confirm the ChromeDriver being used
    //     System.out.println("Using ChromeDriver from: " + WebDriverManager.chromedriver().getDownloadedDriverPath());
    // }
    public void setUp() { // Auto-download ChromeDriver
        WebDriverManager.chromedriver().setup(); 
        ChromeOptions options = new ChromeOptions(); // Headless mode (remove if you want to see browser) 
        options.addArguments("--start-maximized"); //
        options.addArguments("--headless=new"); 
        options.addArguments("--disable-gpu"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--window-size=1920,1080"); 
        options.addArguments("--remote-allow-origins=*"); 
        driver = new ChromeDriver(options); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
    }


    @Test
    public void searchForHeadphones() {
        driver.get("https://www.amazon.in/");

        // Wait for the "Continue shopping" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Attempt to locate the "Continue shopping" button by its visible text
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue shopping']")));
            
            // If the button is found, click it
            continueButton.click();
            System.out.println(" Clicked the 'Continue shopping' button.");
        } catch (Exception e) {
            // If the button isn't present, proceed with the search
            System.out.println("No 'Continue shopping' button found, proceeding with the search.");
        }

        // Proceed with the search for headphones
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("headphones");
        driver.findElement(By.id("nav-search-submit-button")).click();

        //  Just print message, no waiting for results
        System.out.println(" Searched for headphones on Amazon successfully.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
