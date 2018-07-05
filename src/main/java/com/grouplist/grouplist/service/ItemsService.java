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

    public void completeListItem(int id) {
        Items listItem = itemsRepository.findById(id);
        listItem.setComplete(true);
        itemsRepository.save(listItem);
    }

    public void addListItem(Lists list, String itemName) {
        Items listItem = new Items(itemName);
        List<Items> li = list.getItems();
        li.add(listItem);
        list.setItems(li);
        listsRepository.save(list);
    }
}
