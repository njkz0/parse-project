package dao;

import model.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDAOTest {
    Item item = Item.builder()
            .name("testName")
            .item_id(1111)
            .image("testImage")
            .price("111")
            .build();
    Item item2 = Item.builder()
            .name("testName2")
            .item_id(2222)
            .image("testImage2")
            .price("222")
            .build();

    @Test
    void save() {
        Item saved = ItemDAO.save(item);
        assertNotNull(saved);
        assertNotNull(saved.getId());
    }


    @Test
    void getAndDeleteItem() {
        Item saved = ItemDAO.save(item);
        assertNotNull(saved);//item is added
        ItemDAO.deleteItem(1111);
        List<Item> items = ItemDAO.getAllItems();
        assertNotEquals(saved, items.get(items.size() - 1));

    }



    @Test
    void update() {
        Item saved = ItemDAO.save(item);
        ItemDAO.update(item2, saved.getId());
        List<Item> items = ItemDAO.getAllItems();
        Item changed=items.get(items.size() - 1);
        assertNotEquals(saved, changed);
    }
}