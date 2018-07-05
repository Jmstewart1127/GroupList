package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Items;
import com.grouplist.grouplist.repository.ListItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListItemsService {

    @Autowired
    ListItemsRepository listItemsRepository;

    public void completeListItem(int id) {
        Items listItem = listItemsRepository.findById(id);
        listItem.setComplete(true);
        listItemsRepository.save(listItem);
    }

//    public void createListItem(Lists list) {
//        Items newListItem = new Items(list);
//        listItemsRepository.save(newListItem);
//    }
}
