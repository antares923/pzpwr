package com.pzpwr.core.generator;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeGenerator {

    private int iterator;
    private int amount;
    private LocalDateTime actualDate;

    public void initialize(int amount) {
        iterator = 0;
        this.amount = amount;
    }

    public void reset() {
        actualDate = LocalDateTime.now().withNano(0);
    }

    public LocalDateTime generateNextFreeDate(int duration) throws Exception {
        if (iterator >= amount) {
            return null;
        }
        LocalDateTime date = actualDate;

        actualDate = actualDate.plusMinutes(duration);

        iterator++;
        return date;
    }
}
