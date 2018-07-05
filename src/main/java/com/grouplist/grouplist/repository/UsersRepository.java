package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findById(int id);

    Users findByPhoneNumber(String phoneNumber);

}
