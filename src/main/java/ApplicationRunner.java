import service.FileService;

public class ApplicationRunner {
    public static void main(String[] args)  {
        //System.out.println(SitilinkParse.getItemFromURL("https://www.citilink.ru/catalog/mobile/notebooks/1216440/"));
        FileService.writeItemTofile("https://www.citilink.ru/catalog/mobile/notebooks/1216440/", true);
    }
}
