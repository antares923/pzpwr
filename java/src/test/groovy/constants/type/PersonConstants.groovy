package constants.type

import appenum.JobEnum
import appenum.RightEnum
import type.Visit

class PersonConstants {

    static final VISIT_0 = new Visit()

    static final LOGIN = 'login'
    static final PASSWORD = 'password'
    static final NAME = 'name'
    static final SURNAME = 'surname'
    static final JOB = JobEnum.ADMIN
    static final RIGHTS = RightEnum.ADMIN
    static final MEDICAL_DOCUMENTATION = Arrays.asList(VISIT_0)
}
