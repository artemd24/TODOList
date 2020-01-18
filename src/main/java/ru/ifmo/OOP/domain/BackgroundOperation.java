package ru.ifmo.OOP.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BackgroundOperation implements IBackgroundOperation {
    private List<IListener> listeners = new ArrayList<IListener>();

    public void add(IListener listener) {
        listeners.add(listener);
    }

    public void setProgress(int volume) {
        for (IListener listener : listeners) {
            listener.progressSet(volume);
        }
    }

    public void changeProgress(int value) {
        for (IListener listener : listeners) {
            listener.progressChanged(value);
        }
    }

    public void run(Runnable r) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(r);
    }
}
