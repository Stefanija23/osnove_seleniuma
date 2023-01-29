package Domaci_26_1_2023;
//        Napisati program koji ucitava stranicu https://geodata.solutions/
//        Bira Country, State i City po vasoj zelji
//        Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//        I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//        Izabrerit Country, State i City tako da imate podatke da selektujete!


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://geodata.solutions/");

        WebElement dropDown = driver.findElement(By.id("countryId"));
        dropDown.click();
        dropDown.findElement(By.xpath("//option[@countryId='BE']")).click();

        Thread.sleep(1000);

        dropDown = driver.findElement(By.id("stateId"));
        dropDown.click();
        dropDown.findElement(By.xpath("//*[@value='Flanders']")).click();

        Thread.sleep(1000);

        dropDown = driver.findElement(By.id("cityId"));
        dropDown.click();
        dropDown.findElement(By.xpath("//*[@value='Balen']")).click();


        Thread.sleep(5000);
        driver.quit();

    }
}
