package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.repository.GroupsRepository;
import com.grouplist.grouplist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void createNewGroup(Groups group) {
        Users user = usersRepository.findById(group.getCreatedBy());
        group.getUsers().add(user);
        groupsRepository.save(group);
    }

    public void save(Groups group) {
        groupsRepository.save(group);
    }
}
