# Task 6 Ivan Bratanov 12228892 DSE/WS24


## API Html render
- Please run the ./render_api_desc.sh 
  (in the same directory as this document) and go to 
  http://localhost:8080/ to see the swagger-ui render

## Design choices and assumptions 
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
  (per mvnrepository.com), I tried to update all imports
  to use jakarta. That conflicted with the mvn build so I 
  settled to manually add javax to the dependencies, even
  though they are from around 2017
- The generator seems to not support inheritance. I have
  changed the ProposedMeeting in the model package to 
  extend Meeting, since that was my intention.
- The tutorial recommended by the task 
  (https://www.baeldung.com/spring-boot-testing#integration-testing-with-springboottest)
  seems to demonstrate integration testing of a complete or at 
  least semi-complete server. We are asked to write integration
  tests for the openapi-generated server stub. Furthermore the 
  example of an integration test given in the java-openapi-
  generator is very different from the ITs in the other tutorial.
  An integration test that checks if the endpoint is not 
  implemented isn't very interesting. From my understanding 
  a proper integration test requires more than a server stub.
  I believe that a more detailed explanation of what is expected
  for the task would be helpful.


## Tools and Sources 
- All ressources listed in the task description
- Swagger
- How to build integration tests:
  https://www.youtube.com/watch?v=7QCzBwplNIk
