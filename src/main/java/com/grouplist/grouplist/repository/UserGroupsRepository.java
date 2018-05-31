package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.UserGroups;
import com.grouplist.grouplist.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserGroupsRepository extends CrudRepository<UserGroups, Long> {

    Iterable<UserGroups> findAllByUserId(Users users);

}
