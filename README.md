# api-kafka-handler
API for kafka queue calls

## 0. Kafka 
Crear cola Kafka con Docker compose de la carpeta [docker-compose.yml](src/main/resources/kafka/docker-compose.yml).

```
docker compose up -d
```

## 1. Setup API
Verificar versión Java 21.

Con maven, instalar proyecto verificando que quede sin errores y que tests corran bien.

## 2. Ejecución
Los siguientes cURL sirven para la ejecución del proyecto:

* [POST] Agregar eventos a cola Kafka:
```
curl --location 'localhost:8080/api/kafka/add' \
--header 'Content-Type: application/json' \
--data '{
"id": "12344",
"timestamp": "2024-12-24T11:19:32Z", 
"message": "Este es un mensaje de prueba 4", 
"metadata": {
    "source": "app1",
    "type": "notification" 
    }
}'
```

* [GET] Obtener entradas de la cola Kafka:
``` 
curl --location 'localhost:8080/api/kafka/queue'
```

Importante: El método queue obtiene los elementos agregados a la cola desde el instante en que se comenzó a correr el servicio,
por lo que se sugiere primero usar el llamado a _add_.