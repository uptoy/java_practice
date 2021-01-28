package java_practice.DI.dataaccess;

import java.util.List;
import java_practice.DI.logic.Item;

public interface ItemDao {
    public static ItemDao getInstance() {
        return new ItemDaoImpl();
    }

    public List<Item> findAll();
}