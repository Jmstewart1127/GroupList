package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Items;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListsRestController {

    @Autowired
    ListsService listsService;

    @RequestMapping("/api/get/lists/{id}")
    public Iterable<Lists> getListsByGroupId(@PathVariable int id) {
        return listsService.findListsByGroupId(id);
    }

    @RequestMapping("/api/get/lists/")
    public Iterable<Lists> getListsByGroupId() {
        return listsService.findAllLists();
    }

    @RequestMapping("/api/get/list/items/{listId}")
    public Iterable<Items> getListItemsByListId(@PathVariable int listId) {
        return listsService.findAllItemsByListId(listId);
    }

    @RequestMapping(value = "/api/add/list/{groupId}", method = RequestMethod.POST)
    public void createNewList(@PathVariable int groupId, @RequestBody String listName) {
        listsService.createList(groupId, listName);
    }

    @RequestMapping(value = "/api/update/list", method = RequestMethod.POST)
    public void addListItem(@RequestBody Lists list) {
        listsService.saveList(list);
    }

}
