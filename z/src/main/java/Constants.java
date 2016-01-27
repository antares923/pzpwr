import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String user1 = "{\"patientId\":1,\"description\":\"boli mnie noga\"}";
    public static final String user2 = "{\"patientId\":2,\"description\":\"boli mnie glowa\"}";
    public static final String user3 = "{\"patientId\":3,\"description\":\"boli mnie udo\"}";
    public static final String user4 = "{\"patientId\":4,\"description\":\"boli mnie zab\"}";
    public static final String user5 = "{\"patientId\":5,\"description\":\"boli mnie reka\"}";
    public static final String user6 = "{\"patientId\":6,\"description\":\"boli mnie pacha\"}";
    public static final String user7 = "{\"patientId\":7,\"description\":\"mam wysypke\"}";
    public static final String user8 = "{\"patientId\":8,\"description\":\"strasznie boli\"}";
    public static final String user9 = "{\"patientId\":9,\"description\":\"urwalo mi noge\"}";
    public static final String user10 = "{\"patientId\":10,\"description\":\"urwalo mi glowe\"}";

    public static final List<String> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);

    public static final String firstRequest = "[{" +
            "\"login\":\"toLar1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Jan\"," +
            "\"surname\":\"Kowalski\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toNeu1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Janek\"," +
            "\"surname\":\"Nowak\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toNeu3\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toNeu2\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toInt5\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toNeu4\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toLar2\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toLar3\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toInt9\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"toPed1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Tomasz\"," +
            "\"surname\":\"Tomasz\"," +
            "\"job\":\"PATIENT\"," +
            "\"rights\":\"PATIENT\"}," +
            "{\"login\":\"NEU1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Olek\"," +
            "\"surname\":\"Olek\"," +
            "\"job\":\"NEUROLOG\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"LAR1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Olek\"," +
            "\"surname\":\"Olek\"," +
            "\"job\":\"LARINGOLOG\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"LAR2\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Olek\"," +
            "\"surname\":\"Olek\"," +
            "\"job\":\"LARINGOLOG\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"NEU2\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Olek\"," +
            "\"surname\":\"Olek\"," +
            "\"job\":\"NEUROLOG\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"INT1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Olek\"," +
            "\"surname\":\"Olek\"," +
            "\"job\":\"INTERNIST\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"LAR3\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Olek\"," +
            "\"surname\":\"Olek\"," +
            "\"job\":\"LARINGOLOG\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"INT2\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Pani\"," +
            "\"surname\":\"Zosia\"," +
            "\"job\":\"INTERNIST\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"PED1\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Pani\"," +
            "\"surname\":\"Zosia\"," +
            "\"job\":\"PEDIATRIST\"," +
            "\"rights\":\"DOCTOR\"}," +
            "{\"login\":\"ZOCHA\"," +
            "\"password\":\"abcd\"," +
            "\"name\":\"Pani\"," +
            "\"surname\":\"Zosia\"," +
            "\"job\":\"RECEPTIONIST\"," +
            "\"rights\":\"WORKER\"}]";
    
    public static final String patientsAcceptation = "[" +
            "{" +
            "\"patientId\":1," +
            "\"risk\":3," +
            "\"type\":\"TO_LARINGOLOG\"" +
            "}," +
            "{" +
            "\"patientId\":2," +
            "\"risk\":1," +
            "\"type\":\"TO_NEUROLOG\"" +
            "}," +
            "{" +
            "\"patientId\":3," +
            "\"risk\":4," +
            "\"type\":\"TO_NEUROLOG\"" +
            "}," +
            "{" +
            "\"patientId\":4," +
            "\"risk\":10," +
            "\"type\":\"TO_NEUROLOG\"" +
            "}," +
            "{" +
            "\"patientId\":5," +
            "\"risk\":6," +
            "\"type\":\"TO_INTERNIST\"" +
            "}," +
            "{\"patientId\":6," +
            "\"risk\":7," +
            "\"type\":\"OPERATION_NEUROLOGIST\"" +
            "}," +
            "{" +
            "\"patientId\":7," +
            "\"risk\":1," +
            "\"type\":\"TO_LARINGOLOG\"" +
            "}," +
            "{" +
            "\"patientId\":8," +
            "\"risk\":3," +
            "\"type\":\"TO_LARINGOLOG\"" +
            "}," +
            "{" +
            "\"patientId\":9," +
            "\"risk\":3," +
            "\"type\":\"TO_INTERNIST\"" +
            "}," +
            "{" +
            "\"patientId\":10," +
            "\"risk\":4," +
            "\"type\":\"TO_PEDIATRIST\"" +
            "}" +
            "]";

}
