package Domaci_02_02_2023;

import Helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class BootstrapTableTests {
        private WebDriver driver;
        private WebDriverWait wait;
        private String baseUrl = "https://s.bootsnipp.com";

        @BeforeClass
        public void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            this.driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @BeforeMethod
        public void before() {
            driver.get(baseUrl + "/iframe/K5yrx");
        }

//    Test #1: Edit Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Edit dugme prvog reda
//    Sacekati da dijalog za Editovanje bude vidljiv
//    Popuniti formu podacima.
//    Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear.
//    Koristan link
//    Klik na Update dugme
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//    Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//    Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske

        @Test
    public void EditRow () {
            Assert.assertEquals(driver.getTitle(),
                    "Table with Edit and Update Data - Bootsnipp.com",
                    "Title contains Table with Edit and Update Data - Bootsnipp.com");
            driver.findElement(By.xpath("//div[1]/div/table/tbody/tr[1]/td[5]/button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/div")));
            driver.findElement(By.id("fn")).clear();
            driver.findElement(By.id("fn")).sendKeys("Stefanija");
            driver.findElement(By.id("ln")).clear();
            driver.findElement(By.id("ln")).sendKeys("Spasic");
            driver.findElement(By.id("mn")).clear();
            driver.findElement(By.id("mn")).sendKeys("Sasa");
            driver.findElement(By.id("up")).clear();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[2]/div[2]/div")));
            Assert.assertEquals(driver.findElement(By.id("f1")).getText(),
                    "Stefanija." , "First name is not the same as expected.");
            Assert.assertEquals(driver.findElement(By.id("l1")).getText(),
                    "Spasic", "Last name is not the same as expected.");
            Assert.assertEquals(driver.findElement(By.id("m1")).getText(),
                    "Sasa", "Middle name is not the same as expected.");
        }

//    Test #2: Delete Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Delete dugme prvog reda
//    Sacekati da dijalog za brisanje bude vidljiv
//    Klik na Delete dugme iz dijaloga
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da je broj redova u tabeli za jedan manji
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    @Test
    public void DeleteRow() {
            driver.get("https://s.bootsnipp.com/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com", "Not expected title");
        driver.findElement(By.xpath("//tr[@id= 'd1']/td[6]/button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("delete"))));
        driver.findElement(By.xpath("//button[@id= 'del']")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("delete"))));
        Assert.assertTrue(driver.findElements(By.xpath("//tr[@id='d1']/td")).size()<1,
                "The row is not deleted");
    }


//    Test #3: Take a Screenshot
//    Koraci:
//    Ucitati stranu  /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Kreirati screenshot stranice.
//    Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

    @Test
    public void TakeAScreenshot ()  throws IOException {
            new Helper().takeScreenshot(driver, "screenshot/bootstrapTest.png");
        }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
