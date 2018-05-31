package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByPhoneNumber(String phoneNumber);

}
