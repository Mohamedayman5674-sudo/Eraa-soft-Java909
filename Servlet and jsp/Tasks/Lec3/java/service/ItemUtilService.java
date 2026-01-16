package service;

import java.util.ArrayList;
import java.util.List;
import model.Item;

public class ItemUtilService {

    private List<Item> items = new ArrayList<>();

    // 1️⃣ function to get items where id in (1,2)
    public List<Item> getItemsByIds(List<Item> itemList) {
        List<Item> result = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getId() == 1 || item.getId() == 2) {
                result.add(item);
            }
        }
        return result;
    }

    // 2️⃣ function to get items where name contain 'i'
    public List<Item> getItemsNameContainI(List<Item> itemList) {
        List<Item> result = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getName() != null && item.getName().toLowerCase().contains("i")) {
                result.add(item);
            }
        }
        return result;
    }

    // 3️⃣ function to get items where price > 20 and < 50
    public List<Item> getItemsByPriceRange(List<Item> itemList) {
        List<Item> result = new ArrayList<>();

        for (Item item : itemList) {
            if (item.getPrice() > 20 && item.getPrice() < 50) {
                result.add(item);
            }
        }
        return result;
    }

    // 4️⃣ function to save list of items
    public void saveItems(List<Item> itemList) {
        items.addAll(itemList);
    }

    // Helper (اختياري) عشان نختبر
    public List<Item> getSavedItems() {
        return items;
    }
}