package com.grouplist.grouplist.service;

import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListsService {

    @Autowired
    ListsRepository listsRepository;

    @Autowired
    GroupsService groupsService;

    public Lists findListById(int id) {
        return listsRepository.findById(id);
    }

    public Iterable<Lists> findListsByGroupId(int id) {
        Groups group = groupsService.findGroupById(id);
        return listsRepository.findAllByGroupId(group);
    }

    public Iterable<Lists> findAllLists() {
        return listsRepository.findAll();
    }

    public void saveList(Lists list) {
        listsRepository.save(list);
    }


}
