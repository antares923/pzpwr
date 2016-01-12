#Pobieranie dokumentacji

¿¹danie:
http://localhost:8080/get_documentation?id=5

(przewidywana) odpowiedŸ:
[
	{
		"id":"0",
		"roomNumber":"501",
		"doctorId":"11",
		"date":"2015-11-01T06:10:00",
		"patientId":"5",
		"type":"wyciêcie trzustki"
	},
	{
		"id":"3",
		"roomNumber":"200",
		"doctorId":"20",
		"date":"2015-12-04T06:10:00",
		"patientId":"5",
		"type":"szycie rozciêtego ³uku brwiowego"
	}
]


#Pobieranie kalendarza wizyt

¿¹danie:
http://localhost:8080/calendar/get?id=1

(przewidywana) odpowiedŸ:
[
	{
		"id":"10",
		"roomNumber":"501",
		"doctorId":"1",
		"date":"2016-11-01T06:10:00",
		"patientId":"10",
		"type":"wyciêcie trzustki"
	},
	{
		"id":"13",
		"roomNumber":"200",
		"doctorId":"1",
		"date":"2016-12-04T06:10:00",
		"patientId":"12",
		"type":"szycie rozciêtego ³uku brwiowego""
	}
]


#Pobieranie kalendarza wszystkich wizyt

¿¹danie:
http://localhost:8080/calendar/employee/get

(przewidywana) odpowiedŸ:
[
	{
		"id":"10",
		"roomNumber":"501",
		"doctorId":"1",
		"date":"2016-11-01T06:10:00",
		"patientId":"10",
		"type":"wyciêcie trzustki"
	},
	{
		"id":"13",
		"roomNumber":"200",
		"doctorId":"1",
		"date":"2016-12-04T06:10:00",
		"patientId":"12",
		"type":"szycie rozciêtego ³uku brwiowego"
	},
	{
		"id":"0",
		"roomNumber":"501",
		"doctorId":"11",
		"date":"2015-11-01T06:10:00",
		"patientId":"5",
		"type":"wyciêcie trzustki"
	},
	{
		"id":"3",
		"roomNumber":"200",
		"doctorId":"20",
		"date":"2015-12-04T06:10:00",
		"patientId":"5",
		"type":"szycie rozciêtego ³uku brwiowego"
	}
]
	
	
#Ustawienie kalendarza wizyt

¿¹danie: http://localhost:8080/calendar/employee/set
content-type: application/json

request body:
[
	{
		"id":"10",
		"roomNumber":"501",
		"doctorId":"1",
		"date":"2016-11-01T01:10:00",
		"patientId":"10",
		"type":"wyciêcie trzustki"
	},
	{
		"id":"13",
		"roomNumber":"200",
		"doctorId":"1",
		"date":"2016-12-04T01:10:00",
		"patientId":"12",
		"type":"szycie rozciêtego ³uku brwiowego"
	},
	{
		"id":"0",
		"roomNumber":"501",
		"doctorId":"11",
		"date":"2015-11-01T01:10:00",
		"patientId":"5",
		"type":"wyciêcie trzustki"
	},
	{
		"id":"3",
		"roomNumber":"200",
		"doctorId":"20",
		"date":"2015-12-04T01:10:00",
		"patientId":"5",
		"type":"szycie rozciêtego ³uku brwiowego"
	}
]

OdpowiedŸ: Http status code 200


#Rejestracja pacjenta

¿¹danie: http://localhost:8080/register
content-type: application/json

request body:
{
	"patientId":"5",
	"reason":"boli mnie z¹b"
}

odpowiedŸ: Http status code 200


#Dodanie u¿ytkownika

¿¹danie: http://localhost:8080/admin/add_user
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

odpowiedŸ: Http status code 200


#Zmiana uprawnieñ u¿ytkownika

¿¹danie: http://localhost:8080/admin/change_rights
content-type: application/json

request body:
{
	"id":"10",
	"rights":"admin"
}

odpowiedŸ: Http status code 200

...