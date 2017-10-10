Autor: Gabriel Muñumel

# Introducción
> Gestión de los taxis de una ciudad dado sus conductores y los vehículos
>
>Esta aplicación permitirá tener un registro centralizado de los conductores de taxis y sus vehículos para una ciudad.

## Entities
A continuación presentamos el diagrama de clases del paquete de entidades:  
![api-architecture-simulation-vehicles-drivers-entities](https://github.com/gmunumel/APAW-ECP2-Gabriel.Munumel/blob/develop/ECP-vehicle-driver.png)

# API Rest
## Crear un conductor `POST /drivers` 
> Admite varias veces la misma referencia y teléfono, pero no llamadas sin referencia o con referencia vacía. El teléfono puede ser vacío.

Ejemplo: `POST /drivers  {1234XYZ:666666666}`

 Entrada | Respuesta | Respuesta sin tema
--|--|--
`reference: String` Referencia del conductor <br> `phone: String` Teléfono del conductor | `CREATED (201)` | `BAD_REQUEST(400)`<br> `{"error":"DriverFieldInvalidException"}`

## Obtiene el detalle de un conductor `GET /drivers/{id}`
> Consulta los conductores por `id`. El `id` debe pertenecer a un conductor y debe ser un entero.
  
Ejemplo: `GET /drivers/2`

Parámetros | Respuesta | Respuesta si<br>_id_ no existe<br>_id_ no entero
--|--|--
-- | `OK (200) {"id":2,"referencia":"1234XYZ","phone":"666666666"}` | `BAD_REQUEST(400)`<br> `{"error":"DriverIdNotFoundException"}`<br>`{"error":"NumberFormatException"}`

## Actualización de la información de un conductor `PATCH /drivers/{id}`  
> Admite varias veces la misma referencia y teléfono. No admite referencia vacía. Pero el teléfono puede ser vacío. En caso de ser vacío se actualiza a vacío el valor. Por ejemplo, para el cuerpo `{1234XYZ:}` como no se específica el teléfono entonces se actualiza en vacío. Si se tiene el cuerpo `{1234XYZ}` no se modifica el teléfono dado que no se define. 

Ejemplo: `PATCH /drivers/2  {1234XYZ:666666666}` 

Parámetros | Respuesta | Respuesta si<br>_id_ no existe<br>_id_ no entero
--|--|--
-- | `OK (200)` | `BAD_REQUEST(400)`<br> `{"error":"DriverIdNotFoundException"}`<br> `{"error":"NumberFormatException"}`

## Crear un Vehículo `POST /vehicles` 
> Admite varias veces la misma marca, modelo, id del conductor y combustible, pero no llamadas sin marca, modelo, id del conductor o combustible. Tampoco está permitido que ninguno de los campos sea vacío. 
 
Ejemplo: `POST /vehicles  {BMW:T1000:1:GASOLINE}`

Entrada | Respuesta | Respuesta si<br>_brand_ no vacío<br>_model_ no vacío<br>_driverId_ no existe<br>_fuel_ no seleccionada GASOLINE or DIESEL
--|--|--
`brand: String` nombre de la marca <br> `model : String` nombre del modelo <br> `driverId: int` id del conductor <br>`fuel: enum` GASOLINE or DIESEL | `CREATED (201)`|`BAD_REQUEST(400)`<br> `{"error":"VehicleFieldInvalidException"}`<br> `{"error":"DriverIdNotFoundException"}`<br> `{"error":"IllegalArgumentException"}`

## Lista de vehículos para un conductor `GET /drivers/{id}/vehicles`
> El `id` debe pertenecer a un conductor y debe ser un entero.
  
Ejemplo: `GET /drivers/2/vehicles`

Parámetros | Respuesta | Respuesta si<br>_id_ no existe<br>_id_ no entero
--|--|--
-- | `OK (200) {{"id":2,"referencia":"1234XYZ","phone":"666666666"}, [{"id":1,"brand":"BMW","model":"T1000","fuel":"GASOLINE"}, {"id":2,"brand":"Mercedes","model":"CLQ","fuel":"DIESEL"}]}` | `BAD_REQUEST(400)`<br> `{"error":"DriverIdNotFoundException"}`<br>`{"error":"NumberFormatException"}`

## Lista de todos los vehículos `GET /vehicles`
  
Ejemplo: `GET /vehicles`

Parámetros | Respuesta
--|--
-- | `OK (200)` <br>`[{"id":1,"brand":"BMW","model":"T1000","driver":1,"fuel":"GASOLINE"}, {"id":2,"brand":"Mercedes","model":"CLQ","driver":1,"fuel":"DIESEL"}]`

