package Domaci_31_1_2023;
//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300,
//        skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder


import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException, IOException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://itbootcamp.rs/");

    new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[]contains(@class, 'slider_bkgd')]")));

        List<WebElement> lista = driver.findElements(By.xpath("//*[contains(@class,'owl-item')]/div/img"));
        Helper helper = new Helper();
        for (int i = 0; i < lista.size(); i++) {

            if (helper.response(lista.get(i).getAttribute("src")) >=200 &&
                    helper.response(lista.get(i).getAttribute("src")) < 300 ) {
                helper.downloadFile((lista.get(i).getAttribute("src")), "itBootcamp_slider/img"+i+".jpg");
            }else{
            System.out.println("Status Code is not active");
        }
        }

    Thread.sleep(5000);
    driver.quit();
    }
}
