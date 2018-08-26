package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/api/create/group", method = RequestMethod.POST)
    public void createGroup(@RequestBody Groups group) {
        groupsService.createNewGroup(group);
    }

}
