package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Query;

public interface GroupsRepository extends CrudRepository<Groups, Long> {

    Groups findGroupsById(int id);

    Iterable<Groups> findByUsers(Users user);

}
