package java_practice.DI.logic;

import java.util.List;

import java_practice.DI.annotation.Resource;
import java_practice.DI.dataaccess.ItemDao;
import java_practice.DI.dataaccess.ItemDaoImpl;

public class ItemCatalogImpl implements ItemCatalog {
    // 直接newすることをやめることができる
    @Resource(ItemDaoImpl.class)
    private ItemDao dao;
    // private ItemDao dao = ItemDao.getInstance();

    public List<Item> getAll() {
        return dao.findAll();
    }
}