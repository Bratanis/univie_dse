# Task 6 Ivan Bratanov 12228892 DSE/WS24


## API Html render
- Please run the ./render_api_desc.sh 
  (in the same directory as this document) and go to 
  http://localhost:8080/ to see the swagger-ui render

## changes made to the openapi-generated code
- I have used newer versions of the dependencies listed
  in the turoial, because I assume they are better 
  (and offer more support).
- I encountered errors generating stubs for my OpenAPI-
  conforming OAD due to javax dependencies from the 
  recommended tool, java-openapi-generator 
  (https://www.baeldung.com/java-openapi-generator-server).
  This happens even when I use the example project .yml
  (The one in the github repo for the tutorial).
  Since javax is deprecated and replaced by jakarta 
  (per mvnrepository.com), I manually updated all imports
  to use jakarta.
- The generator seems to not support inheritance. I have
  changed the ProposedMeeting in the model package to 
  extend Meeting, since that was my intention.


## Tools and Sources 
- All ressources listed in the task description
- Swagger
