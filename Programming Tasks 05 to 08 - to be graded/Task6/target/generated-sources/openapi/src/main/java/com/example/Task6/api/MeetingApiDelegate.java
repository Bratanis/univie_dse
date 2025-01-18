package com.example.Task6.api;

import com.example.Task6.model.Meeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link MeetingApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-18T19:11:04.541998563+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
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
     * DELETE /meeting/{meetingId}
     * Delete a specific meeting
     *
     * @param meetingId The unique identifier of the meeting (required)
     * @return Successfully deleted a meeting (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see MeetingApi#meetingMeetingIdDelete
     */
    default ResponseEntity<Void> meetingMeetingIdDelete(Integer meetingId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /meeting/{meetingId}
     * Retrieve details of a specific meeting
     *
     * @param meetingId The unique identifier of the meeting (required)
     * @return Successfully retrieved the meeting details (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see MeetingApi#meetingMeetingIdGet
     */
    default ResponseEntity<Meeting> meetingMeetingIdGet(Integer meetingId) {
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
