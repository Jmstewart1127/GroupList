package com.grouplist.grouplist.model;

import javax.persistence.*;

@Entity
@Table(name = "list_items")
public class ListItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "complete")
    private boolean complete;
    @Column(name = "name")
    private String name;

    public ListItems() {}

    public ListItems(String name) {
        this.setComplete(false);
        this.setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
