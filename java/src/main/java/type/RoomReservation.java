package type;

import java.time.LocalDateTime;

public class RoomReservation {

    private int roomNumber;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDateTime getReservationStartTime() {
        return reservationStartTime;
    }

    public LocalDateTime getReservationEndTime() {
        return reservationEndTime;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setReservationStartTime(LocalDateTime reservationStartTime) {
        this.reservationStartTime = reservationStartTime;
    }

    public void setReservationEndTime(LocalDateTime reservationEndTime) {
        this.reservationEndTime = reservationEndTime;
    }

    @Override
    public String toString() {
        return "Room number " + roomNumber + " reserved for " + reservationStartTime + " to " + reservationEndTime;
    }
}
