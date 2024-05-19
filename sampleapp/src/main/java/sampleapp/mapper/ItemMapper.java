package sampleapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sampleapp.entity.Item;

@Mapper
public interface ItemMapper {

    List<Item> getAllItems();

    Item getItemById(int id);

    void addItem(Item item);

    void updateItem(Item item);

    void deleteItem(int id);
}
