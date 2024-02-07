package seturTest;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import page.SeturPage;
import utilities.ConfigReader;
import utilities.TestBaseBeforeMethodAfterMethod;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;


public class SeturTest extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void SeturTest() throws Exception {
        SeturPage seturPage = new SeturPage(driver);
        Actions action = new Actions(driver);
        //1.setur web sitesine git
        driver.get(ConfigReader.properties.getProperty("seturUrl"));
        Thread.sleep(2000);
        //2.setur URL in doğru olduğunu kontrol et
        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://www.setur.com.tr/")) {
            logger.info("Setur URL'si doğru bir şekilde yüklendi.");
        } else {
            logger.info("Setur URL'si beklenmedik bir şekilde yüklendi.");
        }

        //reklamların kapanışı
       seturPage.wheelCampain.click();
       seturPage.backHomePage.click();
       Thread.sleep(6000);
       //çerezlerin kabul edilmesi
       seturPage.cookies.click();

        //5. Ana sayfada Otel tabının default geldiği kontrol edilir,
        if(seturPage.divContainer.isDisplayed())
        {
            logger.info("Otel tabı default olarak geliyor");
        }
        else
        {
            logger.info("Otel tabı default olarak gelmiyor");
        }

        // 6. “Nereye Gideceksiniz?” alanına csv dosyasından “Antalya” yazılır ve en üsteki Antalya seçeneğinetıklanılır.

        //csv uzantılı dosyayı okuma
        String line="";
        String cityName="";
        try {
            String csvFile = "sehir.csv";
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                 logger.info(line);
                cityName=line;
                            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Nereye Gideceksiniz seçeneğine tıklama
        seturPage.cityName.click();
        //csv dosyasınsan okuduğun stringi bu boşluğa yazdırma
        seturPage.cityName.sendKeys(cityName);


        Thread.sleep(3000);
        seturPage.cityButton.click();
        //Gün aralığı seçme
        seturPage.dateButton.click();
        Thread.sleep(3000);
        for (int i =0; i<3;i++)
        {
            Thread.sleep(3000);
            seturPage.dateForwardButton.click();
        }

        //İlk ve son günü seçme
        seturPage.startDateButton.click();
        Thread.sleep(3000);
        seturPage.endDateButton.click();
        Thread.sleep(3000);
        //Yetişkin Sayısını seçme ve  arttırma
        seturPage.personButton.click();
        Thread.sleep(3000);
        seturPage.incrementButton.click();
        Thread.sleep(3000);

        //Yetişkin sayısının artmasını kontrol etme
        String text = seturPage.personNumberArea.getText();
        if (text.equals("3")) {
            logger.info("The text is :"+text);
        } else {
            logger.info("The text is not '3' text: "+text);
        }
        if (seturPage.searchButton.isDisplayed())
        {
            logger.info("Search butonu aktif");
            seturPage.searchButton.click();
        }
        Thread.sleep(3000);

    //url de antalya var mı diye bakılır?
        currentURL = driver.getCurrentUrl();
        if(currentURL.contains("antalya")){
            logger.info("Bulunuyor");
        }else logger.info("Bulunmuyor");

        Thread.sleep(3000);

        //Diğer Öğeleri Göstere Tıkla
        seturPage.otherElementsButton.click();
        Thread.sleep(3000);

        //Rastgale bir şekilde şehir seçme
        Random random = new Random(4);
        int randomIndex = random.nextInt(seturPage.checkboxes.size());
        seturPage.checkboxes.get(randomIndex).click();
        String checkboxText =seturPage.checkboxes.get(randomIndex).getText();
        String numberInParentheses = checkboxText.substring(checkboxText.indexOf('(') + 1, checkboxText.indexOf(')'));

        Thread.sleep(3000);

        //Sayfa sonuna gelip parantezle aynı mı diye kontrol etme
        if(Integer.parseInt(numberInParentheses)>20){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500)");
            js.executeScript("arguments[0].scrollIntoView();", seturPage.hotelNumber);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            String pageElement=seturPage.hotelNumber.getText();
            if (pageElement.equalsIgnoreCase(numberInParentheses)){
                logger.info("Eşittir");
            }else {logger.info("Eşit degil");}
        }else {
            logger.info("20 den kucuk");
            //Eğer 20 seçenekten az ise sayfada gösterilmiyor
        }

    }
}

