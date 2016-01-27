package com.pzpwr.core.scheduler;

import java.time.LocalDateTime;

public class ReservationTime {

    LocalDateTime startTime;
    LocalDateTime endTime;

    public ReservationTime(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
