package constants.type

import type.Visit
import visitenum.JobEnum

class PersonConstants {

    static final VISIT_0 = new Visit()

    static final LOGIN = 'login'
    static final PASSWORD = 'password'
    static final NAME = 'name'
    static final SURNAME = 'surname'
    static final JOB = JobEnum.ADMIN
    static final RIGHTS = 'rights'
    static final RISK = 0
    static final MEDICAL_DOCUMENTATION = Arrays.asList(VISIT_0)
}
