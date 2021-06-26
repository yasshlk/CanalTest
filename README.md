# Project required for the recruitment proccess

• For The Project " Meeting Planner " JAVADOC : Documentation/index.html

• For The Project " Meeting Planner " Source Code : Project Source
    
      Parent 
        -frontend (Module) --> Angular 9
        -backend (Module) --> Spring Boot

• Java 1.8 • Spring Boot 2.5 • Embedded Database H2

• Other tools : Lombok , Swagger, Material Angular, BootStrap.

## Install The project Steps : 

1. Import "Parent" Project 
2. Execute Command Line for The Project "Parent"
   ```sh
   mvn clean
   ```
    ```sh
   mvn install
   ```
3. Launch The Application From Generated WAR
   ```sh
   java -jar ./backend/target/MeetingPlannerAPI-0.0.1-SNAPSHOT.war
   ```

#### Link App: http://localhost:8080/ 
#### Swagger API Documentation : http://localhost:8080/swagger-ui.html 
#### H2 Console (without Password) : http://localhost:8080/h2-console

