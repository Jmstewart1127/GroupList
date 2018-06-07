package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.ListItems;
import org.springframework.data.repository.CrudRepository;

public interface ListItemsRepository extends CrudRepository<ListItems, Long> {

    ListItems findById(int id);

    Iterable<ListItems> findAllById(int id);

}
