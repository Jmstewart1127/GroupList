package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    public Groups findGroupById(int id) {
        return groupsRepository.findGroupsById(id);
    }

    public Iterable<Groups> findGroupsCreatedByUser(int userId) {
        return groupsRepository.findAllGroupsByCreatedBy(userId);
    }

    public void createNewGroup(int userId, String groupName) {
        groupsRepository.save(new Groups(userId, groupName));
    }

    public void save(Groups group) {
        groupsRepository.save(group);
    }
}
