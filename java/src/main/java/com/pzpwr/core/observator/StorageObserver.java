package com.pzpwr.core.observator;

public interface StorageObserver<KEY_TYPE> {

    void add(KEY_TYPE id);

    void update(KEY_TYPE id);

    void remove(KEY_TYPE id);
}
