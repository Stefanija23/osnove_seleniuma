package Domaci_30_1_2023;
//        Napisati program koji testira infinity scroll.
//        Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//        Selektujte delay od 2000ms, koristeci Select klasu.
//        Skrol do Show more dugmeta koje se nalazi na dnu stranice
//        Sacekajte da dugme bude klikljivo
//        Klik na Show more dugme
//        Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//        Sacekajte da dugme vise ne bude klikljivo


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        Thread.sleep(500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement delay = driver.findElement(By.id(("delay-select")));
        Select delaySelect = new Select(delay);
        delaySelect.selectByValue("2000");

        Actions a = new Actions(driver);
        a.scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        Thread.sleep(500);

        Actions b = new Actions(driver);
        b.scrollToElement(driver.findElement(By.id("sentinel"))).perform();
        Thread.sleep(500);


        a.scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        Thread.sleep(500);

        driver.findElement(By.id("infinite-scroll-button")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("item"),6));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id = 'infinite-scroll-button']/span[1]"), "Loading more items..."));

        Thread.sleep(5000);
        driver.quit();
    }
}
