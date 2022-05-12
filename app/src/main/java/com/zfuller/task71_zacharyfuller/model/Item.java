package com.zfuller.task71_zacharyfuller.model;

public class Item {
    private int id;
    private String type, name, phone, desc, date, location;

    public Item(String type, String name, String phone, String desc, String date, String location) {
        this.type = type;
        this.name = name;
        this.phone = phone;
        this.desc = desc;
        this.date = date;
        this.location = location;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String lost) {
        this.type = lost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
