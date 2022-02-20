# Fortune Quotes REST API

A website that prints a random epigram on every reload (like the `fortune` command-line tool, but on the web). 
Users are able to add their own epigrams.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/flowcrmtutorial-1.0-SNAPSHOT.jar`

## Running the application with Docker

A Dockerfile lives in the root of the project and can be used to dockerize the application for production and/or development purposes.

After a production build has been created with maven you can build a Docker image using `docker build -t fortune . ` 
and run it like so: `docker run -ti -p 8080:8080 fortune
`

