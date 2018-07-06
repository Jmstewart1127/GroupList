package com.grouplist.grouplist.restController;

import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersRestController {

    @Autowired
    UserService userService;

    @RequestMapping("/api/get/user/{phoneNumber}")
    public Users getUser(@PathVariable String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "/api/create/user", method = RequestMethod.POST)
    public void createUser(@RequestBody Users user) {
        userService.createUser(user);
    }

}
