package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.repository.GroupsRepository;
import com.grouplist.grouplist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    GroupsRepository groupsRepository;

    public Users findById(int id) {
        return usersRepository.findById(id);
    }

    public Users findUserByPhoneNumber(String phoneNumber) {
        return usersRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean checkIfPhoneNumberIsInUse(String phoneNumber) {
        return findUserByPhoneNumber(phoneNumber) == null;
    }

    public List<Users> findAllUsersByGroup(int groupId) {
        Groups group = groupsRepository.findGroupsById(groupId);
        return group.getUsers();
    }

    public void createUser(Users user) {
        if (checkIfPhoneNumberIsInUse(user.getPhoneNumber())) {
            usersRepository.save(user);
        }
    }
}
