package storage

import static constants.storage.RoomReservationStorageConstants.AVAILABLE_ROOMS
import static constants.storage.RoomReservationStorageConstants.END_TIME_1
import static constants.storage.RoomReservationStorageConstants.END_TIME_4
import static constants.storage.RoomReservationStorageConstants.NO_AVAILABLE_ROOM
import static constants.storage.RoomReservationStorageConstants.ROOM_NUMBER_1
import static constants.storage.RoomReservationStorageConstants.ROOM_RESERVATION_0
import static constants.storage.RoomReservationStorageConstants.ROOM_RESERVATION_IN_DIFFERENT_TIME
import static constants.storage.RoomReservationStorageConstants.ROOM_RESERVATION_IN_TIME_0
import static constants.storage.RoomReservationStorageConstants.ROOM_RESERVATION_WITH_DIFFERENT_ROOM_ID_1
import static constants.storage.RoomReservationStorageConstants.START_TIME_1
import static constants.storage.RoomReservationStorageConstants.START_TIME_4

import exception.StorageException
import spock.lang.Specification
import spock.lang.Unroll

class RoomReservationStorageSpecification extends Specification {

    def uut = new RoomReservationStorageImpl()

    def setup() {
        uut.setAvailableRoomNumbers(AVAILABLE_ROOMS)
    }

    def "When adding new RoomReservation then reservation added correctly"() {
        when:
        uut.add(ROOM_RESERVATION_0)
        uut.add(ROOM_RESERVATION_IN_DIFFERENT_TIME)

        then:
        noExceptionThrown()
    }

    def "When adding new RoomReservation in same time then exception thrown"() {
        setup:
        uut.add(ROOM_RESERVATION_0)

        when:
        uut.add(ROOM_RESERVATION_IN_TIME_0)

        then:
        thrown(StorageException)
    }

    def "When release reservation then no exception thrown"() {
        setup:
        uut.add(ROOM_RESERVATION_0)

        when:
        uut.release(ROOM_RESERVATION_0)

        then:
        noExceptionThrown()
    }

    def "When release not existing reservation then exception thrown"() {
        when:
        uut.release(ROOM_RESERVATION_0)

        then:
        thrown(StorageException)
    }

    @Unroll
    def "When getFreeRoomAtTime called with #startTime and #endTime then #roomNumber returned"() {
        setup:
        uut.add(ROOM_RESERVATION_0)
        uut.add(ROOM_RESERVATION_IN_DIFFERENT_TIME)
        uut.add(ROOM_RESERVATION_WITH_DIFFERENT_ROOM_ID_1)

        when:
        def result = uut.getFreeRoomAtTime(startTime, endTime)

        then:
        result == roomNumber

        where:
        startTime    | endTime    | roomNumber
        START_TIME_4 | END_TIME_4 | ROOM_NUMBER_1
        START_TIME_1 | END_TIME_1 | NO_AVAILABLE_ROOM
    }
}
