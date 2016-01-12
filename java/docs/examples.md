#Pobieranie dokumentacji

��danie:
http://localhost:8080/get_documentation?id=5

(przewidywana) odpowied�:
[
	{
		"id":"0",
		"roomNumber":"501",
		"doctorId":"11",
		"date":"2015-11-01T06:10:00",
		"patientId":"5",
		"type":"wyci�cie trzustki"
	},
	{
		"id":"3",
		"roomNumber":"200",
		"doctorId":"20",
		"date":"2015-12-04T06:10:00",
		"patientId":"5",
		"type":"szycie rozci�tego �uku brwiowego"
	}
]


#Pobieranie kalendarza wizyt

��danie:
http://localhost:8080/calendar/get?id=1

(przewidywana) odpowied�:
[
	{
		"id":"10",
		"roomNumber":"501",
		"doctorId":"1",
		"date":"2016-11-01T06:10:00",
		"patientId":"10",
		"type":"wyci�cie trzustki"
	},
	{
		"id":"13",
		"roomNumber":"200",
		"doctorId":"1",
		"date":"2016-12-04T06:10:00",
		"patientId":"12",
		"type":"szycie rozci�tego �uku brwiowego""
	}
]


#Pobieranie kalendarza wszystkich wizyt

��danie:
http://localhost:8080/calendar/employee/get

(przewidywana) odpowied�:
[
	{
		"id":"10",
		"roomNumber":"501",
		"doctorId":"1",
		"date":"2016-11-01T06:10:00",
		"patientId":"10",
		"type":"wyci�cie trzustki"
	},
	{
		"id":"13",
		"roomNumber":"200",
		"doctorId":"1",
		"date":"2016-12-04T06:10:00",
		"patientId":"12",
		"type":"szycie rozci�tego �uku brwiowego"
	},
	{
		"id":"0",
		"roomNumber":"501",
		"doctorId":"11",
		"date":"2015-11-01T06:10:00",
		"patientId":"5",
		"type":"wyci�cie trzustki"
	},
	{
		"id":"3",
		"roomNumber":"200",
		"doctorId":"20",
		"date":"2015-12-04T06:10:00",
		"patientId":"5",
		"type":"szycie rozci�tego �uku brwiowego"
	}
]
	
	
#Ustawienie kalendarza wizyt

��danie: http://localhost:8080/calendar/employee/set
content-type: application/json

request body:
[
	{
		"id":"10",
		"roomNumber":"501",
		"doctorId":"1",
		"date":"2016-11-01T01:10:00",
		"patientId":"10",
		"type":"wyci�cie trzustki"
	},
	{
		"id":"13",
		"roomNumber":"200",
		"doctorId":"1",
		"date":"2016-12-04T01:10:00",
		"patientId":"12",
		"type":"szycie rozci�tego �uku brwiowego"
	},
	{
		"id":"0",
		"roomNumber":"501",
		"doctorId":"11",
		"date":"2015-11-01T01:10:00",
		"patientId":"5",
		"type":"wyci�cie trzustki"
	},
	{
		"id":"3",
		"roomNumber":"200",
		"doctorId":"20",
		"date":"2015-12-04T01:10:00",
		"patientId":"5",
		"type":"szycie rozci�tego �uku brwiowego"
	}
]

Odpowied�: Http status code 200


#Rejestracja pacjenta

��danie: http://localhost:8080/register
content-type: application/json

request body:
{
	"patientId":"5",
	"reason":"boli mnie z�b"
}

odpowied�: Http status code 200


#Dodanie u�ytkownika

��danie: http://localhost:8080/admin/add_user
content-type: application/json

request body:
{
	"id":"-1",
	"name":"Jan",
	"surname":"Kowalski",
	"job":"Pacjent",
	"login":"jkowalski"
	"password":"abcdefgh",
	"rights":"user"
}

odpowied�: Http status code 200


#Zmiana uprawnie� u�ytkownika

��danie: http://localhost:8080/admin/change_rights
content-type: application/json

request body:
{
	"id":"10",
	"rights":"admin"
}

odpowied�: Http status code 200

...