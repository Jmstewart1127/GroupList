package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/get/user/{id}")
    public Users getUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    @RequestMapping("/api/get/user/by/phone/{phoneNumber}")
    public Users getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    @RequestMapping("/api/get/group/users/by/{id}")
    public List<Users> getUsersByGroup(@PathVariable int id) {
        return userService.findAllUsersByGroup(id);
    }

    @RequestMapping(value = "/api/create/user", method = RequestMethod.POST)
    public void createUser(@RequestBody Users user) {
        userService.createUser(user);
    }

}
