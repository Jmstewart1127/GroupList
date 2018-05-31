package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.UserGroups;
import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.repository.UserGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupsService {

    @Autowired
    UserGroupsRepository userGroupsRepository;

    public Iterable<UserGroups> findAllGroupsByUser(Users users) {
        return userGroupsRepository.findAllByUserId(users);
    }

    public void addUserToGroup(Groups group, Users user) {
        UserGroups newUserGroup = new UserGroups(group, user);
        userGroupsRepository.save(newUserGroup);
    }

}
