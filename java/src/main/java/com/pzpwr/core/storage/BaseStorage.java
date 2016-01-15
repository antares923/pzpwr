package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.observator.Observable;
import com.pzpwr.core.type.Type;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseStorage<KEY_TYPE, OBJECT_TYPE extends Type> extends Observable<KEY_TYPE> {

    private Logger logger = Logger.getLogger("BaseStorage");
    protected Map<KEY_TYPE, OBJECT_TYPE> map = new ConcurrentSkipListMap<>();

    protected void add(KEY_TYPE id, OBJECT_TYPE t) throws StorageException {
        logger.debug("add(id: " + id + ", object: " + t + ") called");
        if (!isIdValid(id)) {
            throw new StorageException(id.toString(), "Unable to add object (" + id + ") to storage");
        }
        map.put(id, t);
        logger.debug("add() executed");
    }

    protected void remove(KEY_TYPE id) throws StorageException {
        logger.debug("remove(id: " + id + ") called");
        if (!removeImpl(id)) {
            throw new StorageException(id.toString(), "Unable to remove object (" + id + ") from storage");
        }
        logger.debug("remove() executed");
    }

    private boolean removeImpl(KEY_TYPE id) {
        return map.remove(id) != null;
    }

    protected void update(KEY_TYPE id, OBJECT_TYPE t) throws StorageException {
        logger.debug("update(id: " + id + ", object: " + t + ") called");
        if (!updateImpl(id, t)) {
            throw new StorageException(id.toString(), "Unable to update object (" + id + ") in storage");
        }
        map.put(id, t);
        logger.debug("update() executed");
    }

    private boolean updateImpl(KEY_TYPE id, OBJECT_TYPE t) {
        return map.get(id) != null;
    }

    @SuppressWarnings("unchecked")
    public OBJECT_TYPE get(KEY_TYPE id) throws StorageException {
        logger.debug("get(id: " + id + ") called");
        OBJECT_TYPE object = (isIdValid(id) ? map.get(id) : null);

        if (object == null) {
            throw new StorageException(id.toString(), "Object (" + id + ") not found in storage");
        }
        logger.debug("get() returned " + object);
        return (OBJECT_TYPE) object.clone();
    }

    protected List<OBJECT_TYPE> getListByFilter(Predicate<OBJECT_TYPE> filter) {
        logger.debug("getListByFilter(filter: " + filter + ") called");
        List<OBJECT_TYPE> list = new ArrayList<>(map.values());
        List<OBJECT_TYPE> filteredList = list.stream().filter(filter).collect(Collectors.toList());
        logger.debug("getListByFilter() returned " + filteredList);
        return filteredList;
    }

    public int count() {
        return map.size();
    }

    public List<OBJECT_TYPE> getAllObjects() {
        return new ArrayList<>(map.values());
    }

    public void removeAll() {
        map.clear();
    }

    protected boolean isIdValid(KEY_TYPE id) {
        return id != null && map.get(id) == null;
    }
}