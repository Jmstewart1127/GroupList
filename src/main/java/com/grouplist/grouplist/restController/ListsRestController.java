package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
