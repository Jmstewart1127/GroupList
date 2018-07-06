package com.grouplist.grouplist.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "group_name")
    private String groupName;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_groups",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<Users> users = new HashSet<>();

    public Groups() {}

    public Groups(String groupName) {
        setGroupName(groupName);
    }

    public Groups(int createdBy, String groupName) {
        setCreatedBy(createdBy);
        setGroupName(groupName);
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

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }
}
