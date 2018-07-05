package com.grouplist.grouplist.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Lists")
@Table(name = "lists")
public class Lists {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Groups groupId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Items> items = new ArrayList<>();
    @Column(name = "list_name")
    private String listName;

    public Lists() {}

    public Lists(Groups groupId, String name) {
        this.setGroupId(groupId);
        this.setListName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
