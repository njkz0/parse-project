import service.FileService;

public class ApplicationRunner {
    public static void main(String[] args)  {
        //System.out.println(SitilinkParse.getItemFromURL("https://www.citilink.ru/catalog/mobile/notebooks/1216440/"));
        FileService.writeItemToXMLfile("https://www.citilink.ru/catalog/power_tools_and_garden_equipments/other_garden_equipments/garden_pumps/1074318/", true);
    }
}
