//Napraviti aplikaciju pomocu Selenium-a koji ce
// otvoriti sajt kupujemprodajem.com,
// izlistati sve kategorije (Stvari) sa leve strane i njihove linkove
// (kao spoken tekst “kategorija: link”),
//
// kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje da se klikne),
// kliknuti na Električni (mozete hardcodovati).
//
// Ostati na toj strani kao kraj zadatka.
//
// Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.
//
//Obratiti paznju na "ad" koji kaze da se registrujete.
// Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.
//
//Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu
// (Mountainbike, Gradski itd).

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\3200g\\IdeaProjects\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://kupujemprodajem.com");

        driver.manage().window().fullscreen();

        WebElement ad = driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]"));
        ad.click();


        List<WebElement> elementList = driver.findElements(By.xpath("//*[@id=\"category-tree-content-goods\"]/a"));


        for (int i = 0; i < elementList.size(); i++) {

            String element = elementList.get(i).getText();
            System.out.println(element + " " + elementList.get(i).getAttribute("href"));

        }

        driver.get("https://www.kupujemprodajem.com/bicikli/kategorija/912");

        List<WebElement> categoryTitle = driver.findElements(By.className("categoryTitle"));

        for (int i = 0; i < categoryTitle.size(); i++) {

            String element = categoryTitle.get(i).getText();
            System.out.println(element);

        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("window.scrollBy(0,500)");

        WebElement elektricniBicikl = driver.findElement(By.xpath("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span"));
        elektricniBicikl.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
