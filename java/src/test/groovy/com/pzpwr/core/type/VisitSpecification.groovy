package com.pzpwr.core.type

import com.pzpwr.core.converter.TimeConverter
import constants.converter.TimeConverterConstants

import static constants.type.VisitConstants.*

import spock.lang.Specification

class VisitSpecification extends Specification {

    def uut = new Visit()

    def setup() {
        TimeConverter.initialize(TimeConverterConstants.DATE_FORMAT)
        uut.setId(ID)
        uut.setRoomNumber(ROOM_NUMBER)
        uut.setDoctorIdList(DOCTOR_IDS_LIST)
        uut.setDateTime(DATE_TIME)
        uut.setPatientId(PATIENT_ID)
        uut.setType(TYPE)
    }

    def "When setting new values then every field set correctly"() {
        expect:
        uut.getId() == ID
        uut.getRoomNumber() == ROOM_NUMBER
        uut.getDoctorIdList() == DOCTOR_IDS_LIST
        uut.getDateTime() == DATE_TIME
        uut.getPatientId() == PATIENT_ID
        uut.getType() == TYPE
    }

    def "When clone called then object with correct fields returned"() {
        when:
        def clone = uut.clone()

        then:
        clone.getRoomNumber() == uut.getRoomNumber()
        clone.getDoctorIdList().containsAll(uut.getDoctorIdList())
        clone.getDateTime() == uut.getDateTime()
        clone.getPatientId() == uut.getPatientId()
        clone.getType() == uut.getType()
    }
}
