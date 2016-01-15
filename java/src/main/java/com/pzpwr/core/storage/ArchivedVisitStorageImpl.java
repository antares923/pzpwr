package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.Visit;
import org.apache.log4j.Logger;

public class ArchivedVisitStorageImpl extends VisitStorageImpl {

    private Logger logger = Logger.getLogger("ArchivedVisitStorageImpl");

    @Override
    public void remove(Visit visit) throws StorageException {
        logger.debug("remove(visit: " + visit + ") called");
        if (!removeImpl(visit.getId())) {
            throw new StorageException(String.valueOf(visit.getId()),
                    "Unable to remove object (" + visit.getId() + ") from storage");
        }
        logger.debug("remove() executed");
    }

    private boolean removeImpl(int id) {
        return map.remove(id) != null;
    }
}
