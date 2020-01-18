package ru.ifmo.OOP.gui;

import ru.ifmo.OOP.domain.IListener;
import javafx.scene.control.ProgressBar;

public class ProgressListener implements IListener {

    private ProgressBar progressBar;
    private float all;
    private float current;

    public ProgressListener(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void progressSet(int volume) {
        all = volume;
    }

    @Override
    public void progressChanged(int value) {
        current = value;
        progressBar.setProgress(this.getStat());
    }

    @Override
    public float getStat() {
        return current / all;
    }
}