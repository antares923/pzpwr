package com.pzpwr.core.type;

import com.pzpwr.core.converter.TimeConverter;
import com.pzpwr.core.appenum.VisitTypeEnum;

import java.time.LocalDateTime;
import java.util.List;

public class Visit {

    private int id;
    private int roomNumber;
    private List<Integer> doctorIdList;
    private LocalDateTime dateTime;
    private int durationInMinutes;
    private int patientId;
    private VisitTypeEnum type;

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public List<Integer> getDoctorIdList() {
        return doctorIdList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getPatientId() {
        return patientId;
    }

    public VisitTypeEnum getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDoctorIdList(List<Integer> doctorIdList) {
        this.doctorIdList = doctorIdList;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = TimeConverter.applyFormatter(dateTime);
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setType(VisitTypeEnum type) {
        this.type = type;
    }

    @Override
    public Visit clone() {
        Visit clone = new Visit();
        clone.setId(this.getId());
        clone.setRoomNumber(this.getRoomNumber());
        clone.setDoctorIdList(this.getDoctorIdList());
        clone.setDateTime(this.getDateTime());
        clone.setPatientId(this.getPatientId());
        clone.setType(this.getType());
        return clone;
    }
}
