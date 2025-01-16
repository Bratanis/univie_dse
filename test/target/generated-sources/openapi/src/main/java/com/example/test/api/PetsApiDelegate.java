package com.example.test.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.example.test.model.Pet;

import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link PetsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T18:51:17.856231266+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public interface PetsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /pets : Create a pet
     *
     * @return Null response (status code 201)
     *         or unexpected error (status code 200)
     * @see PetsApi#createPets
     */
    default ResponseEntity<Void> createPets() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 6, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pets : List all pets
     *
     * @param limit How many items to return at one time (max 100) (optional)
     * @return A paged array of pets (status code 200)
     *         or unexpected error (status code 200)
     * @see PetsApi#listPets
     */
    default ResponseEntity<List<Pet>> listPets(Integer limit) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"name\" : \"name\", \"id\" : 0, \"tag\" : \"tag\" }, { \"name\" : \"name\", \"id\" : 0, \"tag\" : \"tag\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 6, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /pets/{petId} : Info for a specific pet
     *
     * @param petId The id of the pet to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     * @see PetsApi#showPetById
     */
    default ResponseEntity<Pet> showPetById(String petId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : 0, \"tag\" : \"tag\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 6, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
