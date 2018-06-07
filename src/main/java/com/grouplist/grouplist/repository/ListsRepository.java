package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.ListItems;
import com.grouplist.grouplist.model.Lists;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Query;

public interface ListsRepository extends CrudRepository<Lists, Long> {

    Lists findById(int id);

    Iterable<Lists> findAllByGroupId(int id);

    Iterable<ListItems> findAllListItemsByid(int id);

}
