package controller;

import entity.Customer;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import service.GoodsService;
import service.SalesService;

/**
 * Created by Home on 19.09.2017.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/item/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", goodsService.getById(id));
        return "showItem";
    }

    @GetMapping("/items")
    public String getAllUsers(Model model) {
        model.addAttribute("items", goodsService.getAll());
        return "itemList";
    }

    @PostMapping("/newItem")
    public String createItem(@ModelAttribute Item item) {
        goodsService.save(item);
        return "redirect:items";
    }
}
