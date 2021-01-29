package java_practice.DI.presentation;

import java_practice.DI.logic.ItemCatalog;
import java_practice.DI.logic.ItemCatalogImpl;
import java_practice.DI.core.Container;

public class Main {
    public static void main(String[] args) throws Exception {
        Container con = new Container();
        // ItemCatalog catalog = ItemCatalog.getInstance();
        ItemCatalog catalog = (ItemCatalog) con.getInstance(ItemCatalogImpl.class);

        List<Item> items = catalog.getAll();
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }

}
