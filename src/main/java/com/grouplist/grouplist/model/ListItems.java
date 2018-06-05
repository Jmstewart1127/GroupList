package com.grouplist.grouplist.model;

import javax.persistence.*;

@Entity
public class ListItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "complete")
    private boolean complete;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private Lists listId;
    @Column(name = "name")
    private String name;

    public ListItems() {}

    public ListItems(Lists list) {
        this.setComplete(false);
        this.setListId(list);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Lists getListId() {
        return listId;
    }

    public void setListId(Lists listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
