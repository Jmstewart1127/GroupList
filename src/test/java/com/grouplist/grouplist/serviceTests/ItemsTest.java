package com.grouplist.grouplist.serviceTests;

import com.grouplist.grouplist.GrouplistApplication;
import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Items;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ItemsService;
import com.grouplist.grouplist.service.ListsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrouplistApplication.class)
public class ItemsTest {

    @Autowired
    ListsService listsService;

    @Autowired
    ItemsService itemsService;

    @Test
    public void createListItemsTest() {
        Groups group = new Groups("group3");
        Lists list = new Lists(group, "test");
        list.getItems().add(new Items("test item"));
        itemsService.addListItem(list);
        Assert.assertNotNull(list.getItems());
    }

    @Test
    public void addListItemToAlreadyCreatedList() {
        Groups group = new Groups("group2");
        Lists list = new Lists(group, "test");
        listsService.saveList(list);
        for (int i = 0; i < 25; i++) {
            list.getItems().add(new Items(Integer.toString(i)));
        }
        itemsService.addListItem(list);
        Assert.assertNotNull(list.getItems());
    }

    @Test
    public void retrieveListItems() {
        Lists list = listsService.findListById(61);
        List<Items> items = list.getItems();
        for (Items li : items) {
            System.out.println(li.getName());
        }
    }
}
