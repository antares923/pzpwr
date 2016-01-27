USERS:

[
{
  "login":"toLar1",
  "password":"abcd",
  "name":"Jan",
  "surname":"Kowalski",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toNeu1",
  "password":"abcd",
  "name":"Janek",
  "surname":"Nowak",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toNeu3",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toNeu2",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toInt5",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toNeu4",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toLar2",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toLar3",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toInt9",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"toPed1",
  "password":"abcd",
  "name":"Tomasz",
  "surname":"Tomasz",
  "job":"PATIENT",
  "rights":"PATIENT"
},
{
  "login":"NEU1",
  "password":"abcd",
  "name":"Olek",
  "surname":"Olek",
  "job":"NEUROLOG",
  "rights":"DOCTOR"
},
{
  "login":"LAR1",
  "password":"abcd",
  "name":"Olek",
  "surname":"Olek",
  "job":"LARINGOLOG",
  "rights":"DOCTOR"
},
{
  "login":"LAR2",
  "password":"abcd",
  "name":"Olek",
  "surname":"Olek",
  "job":"LARINGOLOG",
  "rights":"DOCTOR"
},
{
  "login":"NEU2",
  "password":"abcd",
  "name":"Olek",
  "surname":"Olek",
  "job":"NEUROLOG",
  "rights":"DOCTOR"
},
{
  "login":"INT1",
  "password":"abcd",
  "name":"Olek",
  "surname":"Olek",
  "job":"INTERNIST",
  "rights":"DOCTOR"
},
{
  "login":"LAR3",
  "password":"abcd",
  "name":"Olek",
  "surname":"Olek",
  "job":"LARINGOLOG",
  "rights":"DOCTOR"
},
{
  "login":"INT2",
  "password":"abcd",
  "name":"Pani",
  "surname":"Zosia",
  "job":"INTERNIST",
  "rights":"DOCTOR"
},
{
  "login":"PED1",
  "password":"abcd",
  "name":"Pani",
  "surname":"Zosia",
  "job":"PEDIATRIST",
  "rights":"DOCTOR"
},
{
  "login":"ZOCHA",
  "password":"abcd",
  "name":"Pani",
  "surname":"Zosia",
  "job":"RECEPTIONIST",
  "rights":"WORKER"
}
]

PATIENT QUERY:

{
  "patientId":1,
  "description":"boli mnie glowa"
}
{
  "patientId":2,
  "description":"boli mnie noga"
}
{
  "patientId":3,
  "description":"bola mnie plecy"
}
{
  "patientId":4,
  "description":"bola mnie plecy"
}
{
  "patientId":5,
  "description":"bola mnie plecy"
}
{
  "patientId":6,
  "description":"bola mnie plecy"
}
{
  "patientId":7,
  "description":"bola mnie plecy"
}
{
  "patientId":8,
  "description":"bola mnie plecy"
}
{
  "patientId":9,
  "description":"bola mnie plecy"
}
{
  "patientId":10,
  "description":"bola mnie plecy"
}

PATIENT_ACCEPTATION:

[   
   {
        "patientId": 1,
        "risk":3,
        "type":"TO_LARINGOLOG"
    },
    {
        "patientId": 2,
        "risk":1,
        "type":"TO_NEUROLOG"
    },
    {
        "patientId": 3,
        "risk":4,
        "type":"TO_NEUROLOG"
    },
    {
        "patientId": 4,
        "risk":10,
        "type":"TO_NEUROLOG"
    },
    {
        "patientId": 5,
        "risk":6,
        "type":"TO_INTERNIST"
    },
    {
        "patientId": 6,
        "risk":7,
        "type":"OPERATION_NEUROLOGIST"
    },
    {
        "patientId": 7,
        "risk":1,
        "type":"TO_LARINGOLOG"
    },
    {
        "patientId": 8,
        "risk":3,
        "type":"TO_LARINGOLOG"
    },
    {
        "patientId": 9,
        "risk":3,
        "type":"TO_INTERNIST"
    },
    {
        "patientId": 10,
        "risk":4,
        "type":"TO_PEDIATRIST"
    }
]