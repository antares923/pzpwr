package com.pzpwr.core.storage;

import com.pzpwr.core.appenum.VisitTypeEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.Visit;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitStorage {

    void add(Visit visit) throws StorageException;

    void remove(Visit visit) throws StorageException;

    void update(int visitId, Visit visit) throws StorageException;

    void setNewValues(List<Visit> newVisitList) throws StorageException;

    Visit get(int visitId) throws StorageException;

    List<Visit> getAllObjects();

    List<Visit> filterByTime(LocalDateTime startTime, LocalDateTime endTime);

    List<Visit> filterByType(VisitTypeEnum visitType);

    void removeAll();
}
