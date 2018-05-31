package com.grouplist.grouplist.model;

import javax.persistence.*;

@Entity
public class UserGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
    @OneToOne
    @JoinColumn(name = "group_id")
    private Groups groupId;

    public UserGroups() {}

    public UserGroups(Groups group, Users user) {
        this.setGroupId(group);
        this.setUserId(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }
}
