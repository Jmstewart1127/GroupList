package com.grouplist.grouplist.model;

import javax.persistence.*;

@Entity
public class ListItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "complete")
    private boolean complete;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private Lists listId;

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
}
