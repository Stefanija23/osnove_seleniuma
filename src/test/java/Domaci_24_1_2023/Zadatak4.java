package Domaci_24_1_2023;
//Maksimizirati prozor
//        Ucitati stranicu https://artplayer.org/
//        U fokusu je player sa desne strane
//        Ceka 3-4s
//        Klik na play dugme
//        Klik na na zvucnik za mute
//        Ceka 3s
//        Klik na screenshot
//        Klik na PIP mode
//        Ceka 1s
//        Klik na Exit PIP mode
//        Klik na WebFullscreen
//        Klik na Exit WebFullscreen
//        Cekanje od 5s
//        Zatvorite pretrazivac


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artplayer.org/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@aria-label='Play']")).click();
        driver.findElement(By.xpath("//i[@aria-label='Mute']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@aria-label='Screenshot']/i")).click();
        driver.findElement(By.xpath("//div[@aria-label='PIP Mode']/i")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@aria-label='Exit PIP Mode']/i")).click();
        driver.findElement(By.xpath("//div[@aria-label='Web Fullscreen']/i")).click();
        driver.findElement(By.xpath("//div[@aria-label='Exit Web Fullscreen']/i[2]")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
