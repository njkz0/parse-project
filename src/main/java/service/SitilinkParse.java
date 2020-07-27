package service;

import model.Item;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utill.JSoupUtill;

public class SitilinkParse {

    public static Item getItemFromURL(String url) {

        Document page = JSoupUtill.getDocument(url);
        String itemName = extractItemName(page);
        String itemPrice=extractItemPrice(page);
        String itemID=extractItemID(page);
        String itemImage=extractItemImage(page);

        return Item
                .builder()
                .name(itemName)
                .price(itemPrice)
                .item_id(Integer.parseInt(itemID))
                .image(itemImage)
                .build();
    }

    private static String extractItemImage(Document document) {
        Elements itemImageElement=document.getElementsByTag("img");
        Element element=itemImageElement.get(2);
        String attr= element.attr("src");
        if(itemImageElement==null){
            return "information is not available";
        }
        else {return attr;}

    }

    private static String extractItemPrice(Document document) {
        Element itemPriceElement=document.getElementsByAttributeValue("class", "price price_break").first();
        if(itemPriceElement==null){
            return "information is not available";
        }
        else {return itemPriceElement.text();}

    }

    private static String extractItemName(Document document) {
        Element itemNameElement=document.getElementsByTag("h1").first();
        if(itemNameElement==null){
            return "information is not available";
        }
        else {return itemNameElement.text();}
    }

    private static String extractItemID(Document document) {
        Element itemCodeElement=document.getElementsByAttributeValue("class", "product_id").first();
        if(itemCodeElement==null){
            return "information is not available";
        }
        else {return itemCodeElement.text();}

    }

}
