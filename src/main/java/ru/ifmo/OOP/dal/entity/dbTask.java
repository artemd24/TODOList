package ru.ifmo.OOP.dal.entity;

// make it TaskDTO (ValueObject/POJO)
public class dbTask {
    // make all fields final
    private int DBid;
    private final String DBtask;
    private final String DBdate;
    private final String DBcreate_date;

    public dbTask(int id, String task, String date, String create_date){
        this.DBid = id;
        this.DBtask = task;
        this.DBdate = date;
        this.DBcreate_date = create_date;
    }

    public int getId() {
        return DBid;
    }

    public String getTask() {
        return DBtask;
    }

    public String getDate() {
        return DBdate;
    }

    public String getCreateDate() {
        return DBcreate_date;
    }
}