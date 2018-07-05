package com.grouplist.grouplist.repository;

import com.grouplist.grouplist.model.Items;
import org.springframework.data.repository.CrudRepository;

public interface ListItemsRepository extends CrudRepository<Items, Long> {

    Items findById(int id);

    Iterable<Items> findAllById(int id);

}
