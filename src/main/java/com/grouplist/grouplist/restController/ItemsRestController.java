package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsRestController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping(value = "/api/add/item", method = RequestMethod.POST)
    public void addListItem(@RequestBody Lists list) {
        itemsService.addListItem(list);
    }

    @RequestMapping("/api/item/complete/{itemId}")
    public void setItemAsComplete(@PathVariable int itemId) {
        itemsService.completeListItem(itemId);
    }

}
