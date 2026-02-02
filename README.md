# Open Jobs

## Description
This is a backend software.\
The programmed utilized was Java and Spring Boot.\
This code will implement a RESTful API to deal with candidates and jobs.\
This will API will save/view/delete/update in a database.


## How to Compile and Run

### Copy the whole code
```bash
git clone https://github.com/MarcosLealDev/open_jobs.git
```

### First run
```bash
mvn clean install
```

### Then execute 
```bash
mvn spring-boot:spring
```
 
## Folders description
#### Main folder
```bash
/src/main/java/com.marcos.open_jobs/open_jobs/
```

## API Description
When running local, send all commands to
```thymeleafurlexpressions
http://localhost:8080
```
To add a candidate, use
```thymeleafurlexpressions
POST localhost:8080/candidate

body {
    "username":"xx leal",
    "password":"12567",
    "name":"",
    "email":"xxxx@x.com",
    "description":"",
    "resume":""
}
```