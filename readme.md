#Pobieranie dokumentacji

url: http://localhost:8080/get_documentation
metoda: GET
parametry: 
	id integer - identyfikator osoby, której dokumentację chcemy otrzymać.
odpowiedź:
	lista obiektów typu Visit w formacie JSON - cała dokumentacja medyczna dla jednej osoby (pacjenta, lekarza, etc)
	kod 500, wiadomość: "Uzytkownik o podanym id %id nie istnieje" - gdy nie uda się odnaleźć użytkownika o podanym identyfikatorze
	

#Pobieranie kalendarza wizyt

url: http://localhost:8080/calendar/get
metoda: GET
parametry:
	id integer - get osoby, której zaplanowane wizyty chcemy otrzymać.
odpowiedź:
	lista obiektów typu Visit w formacie JSON - zaplanowane przyszłe wizyty dla danej osoby
	kod 500, wiadomość: "Uzytkownik o podanym id %id nie istnieje" - gdy nie uda się odnaleźć użytkownika o podanym identyfikatorze
	

#Pobieranie kalendarza wszystkich wizyt

url: http://localhost:8080/calendar/employee/get
metoda: GET
parametry:
odpowiedź:
	lista obiektów typu Visit w formacie JSON - cała siatka wizyt, którą uprawniona do tego osoba może dowolnie zmieniać
	
	
#Ustawienie kalendarza wizyt

url: http://localhost:8080/calendar/employee/set
metoda: POST
MIME: application/json
parametry:
	lista obiektów typu Visit w formacie JSON - nowa siatka wizyt; aktualne wizyty zostaną zamienione na podane
odpowiedź:
	kod 200
	

#Rejestracja pacjenta

url: http://localhost:8080/register
metoda: POST
MIME: application/json
parametry:
	[wstępnie obiekt typu Registered{patientId : int, reason : String}]
odpowiedź:
	kod 200
	

#Dodanie użytkownika

url: http://localhost:8080/admin/add_user
metoda: POST
MIME: application/json
parametry:
	obiekt typu Person - dane użytkownika, który ma zostać dodany
odpowiedź:
	kod 200
	
	
#Zmiana uprawnień użytkownika

url: http://localhost:8080/admin/change_rights
metoda: POST
parametry:
	id : integer - identyfikator użytkownika, którego uprawnienia mają zostać zmienione
	right : String - nowe uprawnienia użytkownika
odpowiedź:
	kod 200
	kod 500, wiadomość: "Uzytkownik o podanym id %id nie istnieje" - gdy nie uda się odnaleźć użytkownika o podanym identyfikatorze
	
...