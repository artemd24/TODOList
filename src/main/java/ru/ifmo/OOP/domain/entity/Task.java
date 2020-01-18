package ru.ifmo.OOP.domain.entity;

// make package-private
public class Task {
    private int id;
    private final String task;
    private final String date;
    private final String create_date;

    public Task(int id, String task, String date, String create_date){
        this.id = id;
        this.task = task;
        this.date = date;
        this.create_date = create_date;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }

    public String getCreateDate() {
        return create_date;
    }
}