package com.grouplist.grouplist.serviceTests;

import com.grouplist.grouplist.GrouplistApplication;
import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.service.GroupsService;
import com.grouplist.grouplist.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrouplistApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    GroupsService groupsService;

    @Test
    public void testCreateUser() {
        Random randInt = new Random();
        String phoneNumber = Integer.toString(randInt.nextInt(9999999));
        Users user = new Users(phoneNumber);
        userService.createUser(user);
        Assert.assertFalse(userService.checkIfPhoneNumberIsInUse(user.getPhoneNumber()));
    }

    @Test
    public void addUserToGroup() {
        Users user = newUser();
        Groups group = new Groups("groupTest");
        groupsService.save(group);
        List<Users> userSet = new ArrayList<>();
        userSet.add(user);
        group.setUsers(userSet);
        groupsService.save(group);
        Assert.assertNotNull(group.getUsers());
    }

    @Test
    public void addUserToAlreadyCreatedGroup() {
        List<Users> users = new ArrayList<>();
        Groups group = new Groups("MultiTest");
        groupsService.save(group);
        for (int i = 0; i < 25; i++) {
            users.add(newUser());
        }
        group.setUsers(users);
        groupsService.save(group);
        Assert.assertNotNull(group.getUsers());
    }

    private Users newUser() {
        Random randInt = new Random();
        String phoneNumber = Integer.toString(randInt.nextInt(9999999));
        Users user = new Users(phoneNumber);
        userService.createUser(user);
        return user;
    }

}
