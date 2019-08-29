# EventDriven-Challenge-Microservice

Run Application
...

Run Unit tests and Integration tests
make test

Enable SQL logs
Add the proprieties below in application.yml

logging.level.org.hibernate.SQL: DEBUG

logging.level.org.hibernate.type.descriptor.sql.BasicBinder: TRACE

Load schema and Database Data
./gradlew u

Technical Debt: 

You can be the topic on the application.yml file
Architecture decision record (ADR)
You can see in the directory adr the records of architectural decisions.

The ADRs can be created using the following tool: https://github.com/npryce/adr-tools
