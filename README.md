# Coopeuch Project

### Microservice
Spring boot 2.5.6 + JPA + Postgresql

### API Documentation
swagger 2.4.0

http://localhost:8085/swagger-ui.html

### Compilation and execution
mvn clean package

java -jar coopeuch-1.0.0.jar


### Database Creation

CREATE DATABASE coopeuch;

CREATE USER coopeuch WITH PASSWORD 'coopeuch';

GRANT ALL PRIVILEGES ON DATABASE coopeuch TO coopeuch;

ALTER ROLE coopeuch WITH SUPERUSER;

ALTER DATABASE coopeuch OWNER TO coopeuch;


### Consume

### POST
http://localhost:8085/v_1/task
{
  "description" : "Task 1",
  "validity" : true
}

### GET ALL
http://localhost:8085/v_1/task{1}

### GET BY ID
http://localhost:8085/v_1/task{1}

### UPDATE
http://localhost:8085/v_1/task
{
  "id": 1,
  "description" : "Task 1",
  "validity" : true
}

### DELETE
http://localhost:8085/v_1/task{1}

