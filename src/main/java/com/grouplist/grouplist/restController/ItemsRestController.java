package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsRestController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping("/api/add/item")
    public void addListItem(Lists list, String itemName) {
        itemsService.addListItem(list, itemName);
    }
}
