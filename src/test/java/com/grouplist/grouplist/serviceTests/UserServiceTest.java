package com.grouplist.grouplist.serviceTests;

import com.grouplist.grouplist.GrouplistApplication;
import com.grouplist.grouplist.model.Users;
import com.grouplist.grouplist.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrouplistApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testCreateUser() {
        Random randInt = new Random();
        String phoneNumber = Integer.toString(randInt.nextInt(9999999));
        Users user = new Users(phoneNumber);
        userService.createUser(user);
        Assert.assertFalse(userService.checkIfPhoneNumberIsInUse(user.getPhoneNumber()));
    }

}
