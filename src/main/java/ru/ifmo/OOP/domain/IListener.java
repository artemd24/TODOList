package ru.ifmo.OOP.domain;

public interface IListener {
    void progressSet(int volume);

    void progressChanged(int value);

    float getStat();
}
