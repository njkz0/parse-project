package utill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Item;

public class JacksonUtill {

    public static String itemToXML(Item item){
        XmlMapper xmlMapper=new XmlMapper();
        try {
            String xmlResult=xmlMapper.writeValueAsString(item);
            return  xmlResult;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
