#Formigio API Service

Spring Boot JPA Based REST Service

Currently using HSQLDB as the database engine.

##Quick Start
1. Clone this repo
1. `./init` (Follow Prompts)
1. Use localhost:8080 as REST client endpoint

##Stepped Start
1. Clone this repo
1. `./buildimage` (This builds the Java app and the Docker Image)
1. `docker run -p "8080:8080" -v .db/data:/var/hsqldb/data commitr_service:latest`
1. Use localhost:8080 as REST client endpoint

##Building
`docker run -v [path/to/repo]:/var/service -w="/var/service" [openjdk image] /var/service/gradlew clean build`

optionally you can build without running tests adding `-x test` to the run command

##Running
`java -jar -Dspring.profiles.active=prod commitr-service-0.0.1-SNAPSHOT.jar`

##Documentation
###Swagger 2.0 - swagger.yaml
`http://<server>:<port>/v2/api-docs`
###Swagger UI
`http://<server>:<port>/swagger-ui.html`

##Development
Local development is pretty straightforwrd, 
**nix*
`./gradlew clean build`
*Windows*
`gradlew clean build`

Local server is also simple, 
**nix*
`./gradlew bootrun`
*Windows*
`gradlew bootrun`

###Idea
**nix*
`./gradlew cleanIdea idea`
*Windows*
`gradlew cleanIdea idea`
###Eclipse/STS
**nix*
`./gradlew cleanEclipse eclipse`
*Windows*
`gradlew cleanEclipse eclipse`

**Note:** I have noticed that if you change the `build.gradle` file you need to refresh your IDE using one of the above commands. You can also manage your classpath settings manually, but using the plugin works pretty well.