package com.pzpwr.core.storage;

import com.pzpwr.core.appenum.VisitTypeEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.Visit;

import java.time.LocalDateTime;
import java.util.List;

public class VisitStorageImpl extends BaseStorage<Integer, Visit> implements VisitStorage {

    @Override
    public void add(Visit visit) throws StorageException {
        super.add(visit.getId(), visit);
    }

    @Override
    public void remove(Visit visit) throws StorageException {
        notifyRemove(visit.getId());
        super.remove(visit.getId());
    }

    @Override
    public void update(int visitId, Visit visit) throws StorageException {
        super.update(visitId, visit);
    }

    @Override
    public void setNewValues(List<Visit> newVisitList) throws StorageException {
        List<Visit> oldVisitCalendar = super.getAllObjects();
        super.removeAll();
        try {
            for (Visit visit : newVisitList) {
                add(visit);
            }
        } catch (StorageException e) {
            for (Visit visit : oldVisitCalendar) {
                add(visit);
            }
            throw e;
        }
    }

    @Override
    public Visit get(int visitId) throws StorageException {
        return super.get(visitId);
    }

    @Override
    public List<Visit> filterByTime(LocalDateTime startTime, LocalDateTime endTime) {
        return super.getListByFilter(
                visit -> (startTime == null || visit.getDateTime().isAfter(startTime)) &&
                        (endTime == null || visit.getDateTime().isBefore(endTime))
        );
    }

    @Override
    public List<Visit> filterByType(VisitTypeEnum visitType) {
        return super.getListByFilter(
                visit -> visit.getType() == visitType
        );
    }
}
