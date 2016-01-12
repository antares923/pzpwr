package storage;

import exception.StorageException;
import observator.Observable;
import org.apache.log4j.Logger;
import type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseStorage<OBJECT_TYPE extends Type> extends Observable {

    private Logger logger = Logger.getLogger("BaseStorage");
    protected Map<Integer, OBJECT_TYPE> map = new ConcurrentSkipListMap<>();

    protected void add(int id, OBJECT_TYPE t) throws StorageException {
        logger.debug("add(id: " + id + ", object: " + t + ") called");
        if (!isIdValid(id)) {
            throw new StorageException("Unable to add object (" + id + ") to storage");
        }
        map.put(id, t);
        notifyAdd(id);
        logger.debug("add() executed");
    }

    public void remove(int id) throws StorageException {
        logger.debug("remove(id: " + id + ") called");
        if (!removeImpl(id)) {
            throw new StorageException("Unable to remove object (" + id + ") from storage");
        }
        notifyRemove(id);

        logger.debug("remove() executed");
    }

    private boolean removeImpl(int id) {
        return map.remove(id) != null;
    }

    protected void update(int id, OBJECT_TYPE t) throws StorageException {
        logger.debug("update(id: " + id + ", object: " + t + ") called");
        if (!updateImpl(id, t)) {
            throw new StorageException("Unable to update object (" + id + ") in storage");
        }
        map.put(id, t);
        notifyUpdate(id);
        logger.debug("update() executed");
    }

    private boolean updateImpl(int id, OBJECT_TYPE t) {
        return map.get(id) != null;
    }

    @SuppressWarnings("unchecked")
    public OBJECT_TYPE get(int id) throws StorageException {
        logger.debug("get(id: " + id + ") called");
        OBJECT_TYPE object = (isIdValid(id) ? map.get(id) : null);

        if (object == null) {
            throw new StorageException("Object (" + id + ") not found in storage");
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

    protected boolean isIdValid(int id) {
        return map.get(id) == null;
    }
}