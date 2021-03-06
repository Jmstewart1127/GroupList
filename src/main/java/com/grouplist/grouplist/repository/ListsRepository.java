package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Lists;
import org.springframework.data.repository.CrudRepository;

public interface ListsRepository extends CrudRepository<Lists, Long> {

    Lists findById(int id);

    Iterable<Lists> findAll();

    Iterable<Lists> findAllByGroupId(Groups group);

}
