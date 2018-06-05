package com.grouplist.grouplist.serviceTests;

import com.grouplist.grouplist.GrouplistApplication;
import com.grouplist.grouplist.model.Groups;
import com.grouplist.grouplist.model.Lists;
import com.grouplist.grouplist.service.ListItemsService;
import com.grouplist.grouplist.service.ListsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GrouplistApplication.class)
public class ListItemsTest {

    @Autowired
    ListsService listsService;

    @Autowired
    ListItemsService listItemsService;

    @Test
    public void testCreatingAndRetrievingListItems() {
        Groups group = new Groups("group2");
        Lists list = new Lists(group, "test");
        listsService.saveList(list);
        for (int i = 0; i < 10; i++) {
            listItemsService.createListItem(list);
        }
        Assert.assertNotNull(listItemsService.findAllListItemsByListId(list.getId()));
    }
}
