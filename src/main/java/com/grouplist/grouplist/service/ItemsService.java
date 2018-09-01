package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Items;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.repository.ItemsRepository;
import com.grouplist.grouplist.repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    ListsRepository listsRepository;

    public Items getItemById(int id) {
        return itemsRepository.findById(id);
    }

    public void completeListItem(int id) {
        Items item = getItemById(id);
        item.setComplete(true);
        itemsRepository.save(item);
    }

    public void addListItem(Items item, int listId) {
        Lists list = listsRepository.findById(listId);
        list.getItems().add(item);
        listsRepository.save(list);
    }

}
