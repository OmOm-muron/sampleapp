package sampleapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sampleapp.entity.Item;
import sampleapp.mapper.ItemMapper;

@Service
public class ItemService {

    private final ItemMapper itemMapper;

    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public List<Item> getAllItems() {
        return itemMapper.getAllItems();
    }

    public Item getItemById(int id) {
        return itemMapper.getItemById(id);
    }

    public void addItem(Item item) {
        itemMapper.addItem(item);
    }

    public void updateItem(Item item) {
        itemMapper.updateItem(item);
    }

    public void deleteItem(int id) {
        itemMapper.deleteItem(id);
    }
}
