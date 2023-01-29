package Domaci_27_1_2023;
//        Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik na svako dugme od PRIMARY do DARK
//        Sacekati da se toasts u desnom gornjem uglu pojavi
//        Pauza izmedju klikova 1s
//        Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");


        List<WebElement> buttons = driver
                .findElements(By.xpath("//*[@class = 'container text-center']" +
                        "/button[contains(@id, 'basic')]"));

        Thread.sleep(1000);

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(1000);

            String subtract = "-trigger";
            String s = buttons.get(i).getAttribute("id");
            s = s.substring(0, s.length() - subtract.length());

            driver.findElement(By.xpath("//*[@id = '" + s + "-example" + "']"));
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        driver.quit();
    }
}
