package Domaci_24_1_2023;
//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter
//        Cekanje od 5s
//        Zatvorite pretrazivac


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        ArrayList<String>todo = new ArrayList<String>();
        todo.add("Visit Visit Paris");
        todo.add("Visit Prague");
        todo.add("Visit London");
        todo.add("Visit New York");
        todo.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");
        for (int i = 0; i < todo.size() ; i++) {
            driver.findElement(By.xpath("//input[@placeholder = 'What needs to be done?']")).
                    sendKeys(todo.get(i));
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@placeholder = 'What needs to be done?']")).
                    sendKeys(Keys.ENTER);
            Thread.sleep(1000);
        }
        Thread.sleep(5000);
        driver.quit();



        }

    }

