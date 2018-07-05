package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.repository.GroupsRepository;
import com.grouplist.grouplist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    UsersRepository usersRepository;

    public Groups findGroupById(int id) {
        return groupsRepository.findGroupsById(id);
    }

    public Iterable<Groups> findByCreatedBy(int id) {
        Users user = usersRepository.findById(id);
        return groupsRepository.findByUsers(user);
    }

    public void createNewGroup(int userId, String groupName) {
        groupsRepository.save(new Groups(userId, groupName));
    }

    public void save(Groups group) {
        groupsRepository.save(group);
    }
}
