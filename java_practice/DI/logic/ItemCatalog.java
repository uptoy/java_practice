package java_practice.DI.logic;

public interface ItemCatalog {

    public static ItemCatalog getInstance() {
        return new ItemCatalogImpl();
    }

}