package converter

import static constants.converter.TimeConverterConstants.*

import spock.lang.Specification

class TimeConverterSpecification extends Specification {

    def uut = new TimeConverter()

    def setup() {
        uut.initialize(DATE_FORMAT)
    }

    def "When convertToString called then correct string returned"() {
        when:
        def result = uut.convertToString(LOCAL_DATE_TIME_0)

        then:
        result == DATE_0
    }

    def "When convertToLocalDateTime called then correct localDateTime returned"() {
        when:
        def result = uut.convertToLocalDateTime(DATE_1)

        then:
        result == LOCAL_DATE_TIME_1
    }
}
