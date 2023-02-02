package Domaci_31_1_2023;
//        Napisati program koji:
//        Podesava:
//        implicitno cekanje za trazenje elemenata od 10s
//        implicitno cekanje za ucitavanje stranice od 10s
//        eksplicitno cekanje podeseno na 10s
//        Podaci:
//        Potrebno je u projektu ukljuciti 4 slike:
//        front.jpg
//        left.jpg
//        right.jpg
//        back.jpg
//        Koraci:
//        Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//        Maksimizuje prozor
//        Klik na edit ikonicu
//        Klik na delete iz iskacuceg dijaloga
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte front.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 1.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte right.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 2.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Klik na Add Image dugme
//        Sacekajte da se pojavi desni meni
//        Uploadujte back.jpg sliku
//        Sacekajte da je ispod uploada slike, broj slika 3.
//        Klik na sliku
//        Klik na Done dugme
//        Sacekajte 2s
//        Sacekajte da Next dugme bude klikljivo
//        Klik na Next dugme
//        Unesite tekst
//        Klik na Next
//        Klik na Preview
//        Klik na Add to cart
//        Sacekajte 5s
//        Quit


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(@class, 'edit-image')]")).click();
        driver.findElement(By.xpath("//*[@id= 'image-option-remove']")).click();
        driver.findElement(By.xpath("//*[@id= 'active-face']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'sc-eGugkK brCFVr')]")));
        driver.findElement(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]\"")).
                sendKeys(new File("test_data/front.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]")));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]\"")).
                sendKeys(new File("test_data/left.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]")));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]\"")).
                sendKeys(new File("test_data/right.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]")));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]\"")).
                sendKeys(new File("test_data/back.jpg").getAbsolutePath());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'sc-hHTYSt bhBnqr')]")));
        driver.findElement(By.id("image-option-0")).click();
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='next-button']")));
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.id("textareaID")).sendKeys("Alphabet.");
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.xpath("//button[@id='next-button']")).click();

        Thread.sleep(5000);
        driver.quit();


    }
}
