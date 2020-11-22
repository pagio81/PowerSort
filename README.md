#PowerSort

PowerSort is simple REST API in spring boot that accepts a list of integers in the HTTP request body, sorts the integers, and returns the sorted list of integers as well as the sum of the data set in the response body. The implementation should use Java 8 streams in some way. The sorting should be implemented manually not using a sorting library.

The application is also available on GitHub @ https://github.com/pagio81/PowerSort/tree/development 

##Pre-requisite

Apache Maven and Java 8 are installed on the computer

##Run Test

Open command prompt from the root folder of the project and run

`mvn test`

##Run PowerSort

Open command prompt from the root folder of the project and run

`mvn spring-boot:run -pl power-sort-web`

Open your browser at the address 

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

try it out using Swagger UI

If you prefer using PostMan:

1. Set up a http POST call to http://localhost:8080/process
2. Configure a raw request body with content type JSON
3. set as body an array of integers, e.g. [5,6,3,4] 
4. Hit the button "Send"