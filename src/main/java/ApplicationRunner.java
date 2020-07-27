import dao.ItemDAO;
import model.NewUser;
import org.openqa.selenium.WebDriver;
//import service.FileService;
import service.FileService;
import service.SeleniumSiteService;

public class ApplicationRunner {
    public static void main(String[] args) {

        //   FileService.writeItemToXMLfile("https://www.citilink.ru/catalog/audio_and_digits/tv/1376849/", true);
        //  NewUser newUser=NewUser
        //          .builder()
        //          .email("asdasd123123qwe@mail.ru")
        //          .phoneNumber("+78912345678")
        //          .phoneCode("1234")
        //          .build();
        //  String url="https://www.citilink.ru/";
        //  WebDriver webDriver= SeleniumSiteService.connectToSite(url);
        //  SeleniumSiteService.citilinkRegistration(newUser, webDriver);
        //  try {
        //      Thread.sleep(5000);
        //  } catch (InterruptedException e) {
        //      e.printStackTrace();

        //  }
        //  webDriver.quit();


        // ItemDAO.saveItemFromURL("https://www.citilink.ru/catalog/mobile/cell_phones/1380942/");
         ItemDAO.deleteItem(2222);


    }
}
