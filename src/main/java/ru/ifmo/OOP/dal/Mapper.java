package ru.ifmo.OOP.dal;

import ru.ifmo.OOP.domain.entity.Task;
import ru.ifmo.OOP.dal.entity.dbTask;

public class Mapper {
    public static dbTask map(Task task) {
        int id = task.getId();
        String text = task.getTask();
        String date = task.getDate();
        String create_date = task.getCreateDate();
        return new dbTask(id, text, date, create_date);
    }
}
