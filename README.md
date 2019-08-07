# EventDriven-Challenge-Microservice

Run Application
Install Postgres, Apache Ignite and Eclipse Mosquitto in Docker using the docker-compose up -d command inside the docker folder
Return to the root directory and run the make run command
Specify a profile: SPRING_PROFILES_ACTIVE=staging ./gradlew bootRun

Run Unit tests and Integration tests
make test

Enable SQL logs
Add the proprieties below in application.yml

logging.level.org.hibernate.SQL: DEBUG

logging.level.org.hibernate.type.descriptor.sql.BasicBinder: TRACE

Load schema and Database Data
./gradlew u
Technical Debt: The MqttKeepAliveSignalIntegrationTest integration test is marked as ignored to run by the make test command, but you can run it directly in your IDE.

You can be the topic on the application.yml file
Architecture decision record (ADR)
You can see in the directory adr the records of architectural decisions.

The ADRs can be created using the following tool: https://github.com/npryce/adr-tools
