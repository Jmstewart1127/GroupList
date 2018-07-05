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
    public void testCreatingListItems() {
        Groups group = new Groups("group2");
        Lists list = new Lists(group, "test");
        listsService.saveList(list);
        Lists testList = listsService.findListById(list.getId());
        itemsService.addListItem(testList, "test");
        Assert.assertNotNull(testList.getItems());
    }

    @Test
    public void addListItemToAlreadyCreatedList() {
        Groups group = new Groups("group2");
        Lists list = new Lists(group, "test");
        listsService.saveList(list);
        for (int i = 0; i < 25; i++) {
            itemsService.addListItem(list, Integer.toString(i));
        }
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
