package ru.ifmo.OOP.dal.file;

import ru.ifmo.OOP.dal.Dao;
import ru.ifmo.OOP.domain.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class InListTaskDao implements Dao<Task> {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public Task create(Task entity) {
        tasks.add(entity);
        return entity;
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }

    @Override
    public Task getById(int id) {
        return tasks.get(id);
    }

    @Override
    public Task update(Task entity) {
        tasks.add(entity.getId(), entity);
        return entity;
    }

    @Override
    public void remove(int id) {
        tasks.remove(id);
    }
}
