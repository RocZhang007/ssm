package com.roc.domain;

public class ActivityCount {
    private int id;
    private String act_name;
    private String type_name;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ActivityCount{" +
                "id=" + id +
                ", act_name='" + act_name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", number=" + number +
                '}';
    }
}
