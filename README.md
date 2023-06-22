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

