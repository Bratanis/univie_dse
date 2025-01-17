package com.example.Task6.api;

import com.example.Task6.model.MeetingsDashboard;
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
 * A delegate to be called by the {@link DashboardApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T14:09:35.326009267+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public interface DashboardApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /dashboard
     * Get the whole dashboard, containing all of the scheduled meetings and all of the polls that are ongoing 
     *
     * @return Successful pull of dashboard object (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see DashboardApi#dashboardGet
     */
    default ResponseEntity<MeetingsDashboard> dashboardGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"meetings\" : [ { \"meetingId\" : 1, \"subject\" : \"Team Sync\", \"date\" : \"2025-01-20\" }, { \"meetingId\" : 2, \"subject\" : \"Project Kickoff\", \"date\" : \"2025-01-22\" } ], \"polls\" : [ { \"pollId\" : 101, \"proposals\" : [ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } } ], \"isPublished\" : false } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
