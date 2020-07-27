package dao;

import model.Item;
import service.SitilinkParse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static Item save(Item item) {
        String sql = "INSERT INTO items(name, image, item_id, price) VALUES (?, ?, ?, ?)";
        String curIdStatement = "SELECT currval(pg_get_serial_sequence('items','id'))";
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             PreparedStatement idPreparedStatement = connection.prepareStatement(curIdStatement)
        ) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getImage());
            preparedStatement.setInt(3, item.getItem_id());
            preparedStatement.setString(4, item.getPrice());
            preparedStatement.executeUpdate();
            ResultSet resultSet = idPreparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                item.setId(id);

                return item;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static Item saveItemFromURL(String url) {
        Item item = SitilinkParse.getItemFromURL(url);
        return save(item);
    }

    public static void deleteItem(int item_id) {
        String sql = "DELETE FROM items where item_id=?";
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, item_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList getAllItems() {
        ArrayList<Item> items = new ArrayList<>();
        String sql = "SELECT * from items";

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String image = resultSet.getString(3);
                int item_id = resultSet.getInt(4);
                String price = resultSet.getString(5);
                Item item = Item.builder()
                        .id(id)
                        .name(name)
                        .image(image)
                        .item_id(item_id)
                        .price(price)
                        .build();
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item update(Item NewItem, int changedItemId) {
        String sql = "UPDATE items SET name=?, image=?, item_id=?, price=? WHERE id=?";

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, NewItem.getName());
            preparedStatement.setString(2, NewItem.getImage());
            preparedStatement.setInt(3, NewItem.getItem_id());
            preparedStatement.setString(4, NewItem.getPrice());
            preparedStatement.setInt(5, changedItemId);
            preparedStatement.executeUpdate();
            return NewItem;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
