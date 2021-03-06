package constants.type

import com.pzpwr.core.converter.TimeConverter
import com.pzpwr.core.appenum.VisitTypeEnum

class VisitConstants {

    static final DOCTOR_ID_0 = 3
    static final DOCTOR_ID_1 = 4
    static final DATE_0 = '2015-11-01T01:01:01'

    static final ID = 0
    static final ROOM_NUMBER = 1
    static final DOCTOR_IDS_LIST = Arrays.asList(DOCTOR_ID_0, DOCTOR_ID_1)
    static final DATE_TIME = TimeConverter.convertToLocalDateTime(DATE_0);
    static final PATIENT_LOGIN = 'patientLogin'
    static final TYPE = VisitTypeEnum.TO_INTERNIST
}
