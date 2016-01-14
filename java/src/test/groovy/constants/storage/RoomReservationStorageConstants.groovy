package constants.storage

import com.pzpwr.core.type.RoomReservation

import java.time.LocalDateTime

class RoomReservationStorageConstants {

    static final ROOM_RESERVATION_0 = new RoomReservation()
    static final ROOM_RESERVATION_IN_TIME_0 = new RoomReservation()
    static final ROOM_RESERVATION_IN_DIFFERENT_TIME = new RoomReservation()
    static final ROOM_RESERVATION_WITH_DIFFERENT_ROOM_ID_1 = new RoomReservation()
    static final ROOM_RESERVATION_IN_TIME_1 = new RoomReservation()

    static final START_TIME_0 = LocalDateTime.of(1, 1, 1, 1, 1, 1)
    static final END_TIME_0 = LocalDateTime.of(1, 1, 1, 4, 1, 1)

    static final START_TIME_1 = LocalDateTime.of(1, 1, 1, 2, 1, 1)
    static final END_TIME_1 = LocalDateTime.of(1, 1, 1, 3, 1, 1)

    static final START_TIME_2 = LocalDateTime.of(1, 1, 2, 1, 1, 1)
    static final END_TIME_2 = LocalDateTime.of(1, 1, 2, 2, 1, 1)

    static final START_TIME_3 = LocalDateTime.of(1, 1, 1, 1, 1, 1)
    static final END_TIME_3 = LocalDateTime.of(1, 1, 1, 4, 1, 1)

    static final START_TIME_4 = LocalDateTime.of(1, 1, 2, 1, 1, 1)
    static final END_TIME_4 = LocalDateTime.of(1, 1, 2, 2, 1, 1)

    static final NO_AVAILABLE_ROOM = -1
    static final ROOM_NUMBER_0 = 0
    static final ROOM_NUMBER_1 = 1

    static final AVAILABLE_ROOMS = Arrays.asList(ROOM_NUMBER_0, ROOM_NUMBER_1)

    static {
        ROOM_RESERVATION_0.setRoomNumber(ROOM_NUMBER_0)
        ROOM_RESERVATION_0.setReservationStartTime(START_TIME_0)
        ROOM_RESERVATION_0.setReservationEndTime(END_TIME_0)

        ROOM_RESERVATION_IN_TIME_0.setRoomNumber(ROOM_NUMBER_0)
        ROOM_RESERVATION_IN_TIME_0.setReservationStartTime(START_TIME_1)
        ROOM_RESERVATION_IN_TIME_0.setReservationEndTime(END_TIME_1)

        ROOM_RESERVATION_IN_DIFFERENT_TIME.setRoomNumber(ROOM_NUMBER_0)
        ROOM_RESERVATION_IN_DIFFERENT_TIME.setReservationStartTime(START_TIME_2)
        ROOM_RESERVATION_IN_DIFFERENT_TIME.setReservationEndTime(END_TIME_2)

        ROOM_RESERVATION_WITH_DIFFERENT_ROOM_ID_1.setRoomNumber(ROOM_NUMBER_1)
        ROOM_RESERVATION_WITH_DIFFERENT_ROOM_ID_1.setReservationStartTime(START_TIME_3)
        ROOM_RESERVATION_WITH_DIFFERENT_ROOM_ID_1.setReservationEndTime(END_TIME_3)

        ROOM_RESERVATION_IN_TIME_1.setRoomNumber(ROOM_NUMBER_1)
        ROOM_RESERVATION_IN_TIME_1.setReservationStartTime(START_TIME_4)
        ROOM_RESERVATION_IN_TIME_1.setReservationEndTime(END_TIME_4)
    }
}
