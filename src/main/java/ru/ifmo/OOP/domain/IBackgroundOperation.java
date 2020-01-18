package ru.ifmo.OOP.domain;

public interface IBackgroundOperation {
    void add(IListener listener);

    void setProgress(int volume);

    void changeProgress(int value);

    void run(Runnable r);
}
