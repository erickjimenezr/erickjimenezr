Para consultar un cliente:
GET http://localhost:8080/v1/client/{id}
Donde {id} es un path variable de tipo Integer(0 - 999999999)

En caso de existir un cliente regresa un HTTP 200 OK con el siguiente response body:
{
	"documentId": 1,
	"documentType": "CEDULA",
	"fullName": "Erick Jimenez",
	"birthdate": "1989-04-01"
}
De lo contrario regresa un response vacío con HTTP 404 NOT  FOUND


Para crear un cliente:
POST http://localhost:8080/v1/client
Agregando el siguiente JSON como request body:
{
	"documentId": 1,
	"documentType": "CEDULA",
	"fullName": "Erick Jimenez",
	"birthdate": "1989-04-01"
}
Regresa como respuesta un HTTP 201 CREATED con el siguiente response body:
{
	"documentId": 1,
	"documentType": "CEDULA",
	"fullName": "Erick Jimenez",
	"birthdate": "1989-04-01"
}

