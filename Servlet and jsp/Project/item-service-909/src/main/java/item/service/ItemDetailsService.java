package item.service;

import item.model.ItemDetails;

public interface ItemDetailsService {

    ItemDetails getByItemId(Long id);

    boolean addDetails(ItemDetails details);

    boolean deleteDetails(Long id);

    boolean updateDetails(ItemDetails details);  
}