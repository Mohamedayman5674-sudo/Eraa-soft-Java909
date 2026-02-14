package item.service;

import item.model.Item;
import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(Long id);

    Item getItemByName(String name);

    boolean addItem(Item item);

    boolean updateItem(Item item);

    boolean removeItem(Long id);
}
