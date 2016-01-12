package type

import static constants.type.PersonConstants.*

import spock.lang.Specification

class PersonSpecification extends Specification {

    def uut = new Person()

    def setup() {
        uut.setLogin(LOGIN)
        uut.setPassword(PASSWORD)
        uut.setName(NAME)
        uut.setSurname(SURNAME)
        uut.setJob(JOB)
        uut.setRights(RIGHTS)
        uut.setRisk(RISK)
//        uut.setMedicalDocumentation(MEDICAL_DOCUMENTATION)
    }

    def "When setting new values then every field set correctly"() {
        expect:
        uut.getLogin() == LOGIN
        uut.getPassword() == PASSWORD
        uut.getName() == NAME
        uut.getSurname() == SURNAME
        uut.getJob() == JOB
        uut.getRights() == RIGHTS
        uut.getRisk() == RISK
//        uut.getMedicalDocumentation() ==  MEDICAL_DOCUMENTATION
    }

    def "When clone called then object with correct fields returned"() {
        when:
        def clone = uut.clone()

        then:
        clone.getLogin() == uut.getLogin()
        clone.getPassword() == uut.getPassword()
        clone.getName() == uut.getName()
        clone.getSurname() == uut.getSurname()
        clone.getJob() == uut.getJob()
        clone.getRights() == uut.getRights()
        clone.getRisk() == uut.getRisk()
//        clone.getMedicalDocumentation() ==  uut.getMedicalDocumentation()
    }
}
