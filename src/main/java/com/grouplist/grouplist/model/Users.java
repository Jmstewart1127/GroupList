package com.grouplist.grouplist.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToMany(mappedBy = "users")
    private List<Groups> groups = new ArrayList<>();

    public Users() {}

    public Users(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
