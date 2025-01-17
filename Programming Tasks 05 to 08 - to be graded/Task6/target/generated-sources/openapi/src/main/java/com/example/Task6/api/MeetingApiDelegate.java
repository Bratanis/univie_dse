package com.example.Task6.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.example.Task6.model.Meeting;

import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link MeetingApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T12:23:32.423591700+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public interface MeetingApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /meeting
     * Get all of the scheduled meetings 
     *
     * @return Successful pull of meetings (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see MeetingApi#meetingGet
     */
    default ResponseEntity<List<Meeting>> meetingGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"meetingId\" : 1, \"subject\" : \"Team Sync\", \"date\" : \"2025-01-20\" }, { \"meetingId\" : 1, \"subject\" : \"Team Sync\", \"date\" : \"2025-01-20\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /meeting/{id}
     * Delete a specific meeting
     *
     * @param id The unique identifier of the meeting (required)
     * @return Successfully deleted a meeting (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see MeetingApi#meetingIdDelete
     */
    default ResponseEntity<Void> meetingIdDelete(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /meeting/{id}
     * Retrieve details of a specific meeting
     *
     * @param id The unique identifier of the meeting (required)
     * @return Successfully retrieved the meeting details (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see MeetingApi#meetingIdGet
     */
    default ResponseEntity<Meeting> meetingIdGet(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"meetingId\" : 1, \"subject\" : \"Team Sync\", \"date\" : \"2025-01-20\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /meeting
     * Add a new meeting to the dashboard 
     *
     * @param meeting  (required)
     * @return Successfully created a new meeting and added it to the dashboard (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see MeetingApi#meetingPost
     */
    default ResponseEntity<Void> meetingPost(Meeting meeting) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
