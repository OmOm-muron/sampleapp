package sampleapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sampleapp.entity.Item;
import sampleapp.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public String getAllItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items/item-list";
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable int id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "items/item-detail";
    }

    @GetMapping("/add")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "items/item-add";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item) {
        itemService.addItem(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/update")
    public String showUpdateItemForm(@PathVariable int id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "items/item-update";
    }

    @PostMapping("/{id}/update")
    public String updateItem(@PathVariable int id, @ModelAttribute Item item) {
        item.setId(id);
        itemService.updateItem(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteItemForm(@PathVariable int id) {
        return "items/item-delete";
    }
    
    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}
