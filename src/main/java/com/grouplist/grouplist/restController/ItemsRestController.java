package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Items;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsRestController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping(value = "/api/add/item/{listId}", method = RequestMethod.POST)
    public void addListItem(@RequestBody Items item, @PathVariable int listId) {
        itemsService.addListItem(item, listId);
    }

    @RequestMapping("/api/item/complete/{itemId}")
    public void setItemAsComplete(@PathVariable int itemId) {
        itemsService.completeListItem(itemId);
    }

}
