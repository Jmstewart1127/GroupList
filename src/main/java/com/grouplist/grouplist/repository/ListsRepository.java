package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.Items;
import com.grouplist.grouplist.model.Lists;
import org.springframework.data.repository.CrudRepository;

public interface ListsRepository extends CrudRepository<Lists, Long> {

    Lists findById(int id);

    Iterable<Lists> findAllByGroupId(int id);

    Iterable<Items> findAllListItemsByid(int id);

}
