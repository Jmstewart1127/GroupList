package com.grouplist.grouplist.serviceTests;

import com.grouplist.grouplist.GrouplistApplication;
import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.ListItems;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ListItemsService;
import com.grouplist.grouplist.service.ListsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrouplistApplication.class)
public class ListItemsTest {

    @Autowired
    ListsService listsService;

    @Autowired
    ListItemsService listItemsService;

    @Test
    public void testCreatingListItems() {
        Groups group = new Groups("group2");
        Lists list = new Lists(group, "test");
        listsService.saveList(list);
        Lists testList = listsService.findListById(61);
        listsService.addListItem(testList, "test");
        Assert.assertNotNull(testList.getItems());
    }

    @Test
    public void retrieveListItems() {
        Lists list = listsService.findListById(61);
        List<ListItems> listItems = list.getItems();

        for (ListItems li : listItems)
            System.out.println(li.getName());
    }
}
