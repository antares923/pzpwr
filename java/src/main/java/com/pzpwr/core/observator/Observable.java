package com.pzpwr.core.observator;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Observable<KEY_TYPE> {

    private Logger logger = Logger.getLogger("Observable");
    private List<StorageObserver<KEY_TYPE>> observers = new CopyOnWriteArrayList<>();

    public void registerObserver(StorageObserver<KEY_TYPE> observer) {
        logger.debug("registerObserver(observer: " + observer + ") called");
        observers.add(observer);
        logger.debug("registerObserver() executed");
    }

    public void notifyAdd(KEY_TYPE id) {
        logger.debug("notifyAdd(id: " + id + ") called");
        for (StorageObserver<KEY_TYPE> observer : observers) {
            observer.add(id);
        }
        logger.debug("notifyAdd() executed");
    }

    public void notifyUpdate(KEY_TYPE id) {
        logger.debug("notifyUpdate(id: " + id + ") called");
        for (StorageObserver<KEY_TYPE> observer : observers) {
            observer.update(id);
        }
        logger.debug("notifyUpdate() executed");
    }

    public void notifyRemove(KEY_TYPE id) {
        logger.debug("notifyRemove(id: " + id + ") called");
        for (StorageObserver<KEY_TYPE> observer : observers) {
            observer.remove(id);
        }
        logger.debug("notifyRemove() executed");
    }
}
