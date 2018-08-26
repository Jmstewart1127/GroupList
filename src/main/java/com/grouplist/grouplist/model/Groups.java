package com.grouplist.grouplist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "group_name")
    private String groupName;
    @ManyToMany
    @JsonBackReference
    private List<Users> users = new ArrayList<>();

    public Groups() {}

    public Groups(String groupName) {
        setGroupName(groupName);
    }

    public Groups(int createdBy, String groupName) {
        setCreatedBy(createdBy);
        setGroupName(groupName);
    }

    public Groups(int createdBy, String groupName, List<Users> users) {
        setCreatedBy(createdBy);
        setGroupName(groupName);
        setUsers(users);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
