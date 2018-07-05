package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupsRestController {

    @Autowired
    GroupsService groupsService;

    @RequestMapping("/api/get/group/by/{id}")
    public Groups getGroupsById(@PathVariable int id) {
        return groupsService.findGroupById(id);
    }

    @RequestMapping("/api/get/my/groups/{id}")
    public Iterable<Groups> getGroupsCreatedByUser(@PathVariable int id) {
        return groupsService.findByCreatedBy(id);
    }

}
