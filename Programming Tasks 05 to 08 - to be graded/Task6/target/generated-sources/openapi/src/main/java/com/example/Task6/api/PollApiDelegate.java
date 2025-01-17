package com.example.Task6.api;

import com.example.Task6.model.Poll;
import com.example.Task6.model.PollIdPatchRequest;
import com.example.Task6.model.PollPollIdProposedMeetingMeetingIdPatchRequest;
import com.example.Task6.model.ProposedMeeting;
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
 * A delegate to be called by the {@link PollApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T15:19:30.908617591+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public interface PollApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /poll
     * Get all of the polls 
     *
     * @return Successful pull of polls (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollGet
     */
    default ResponseEntity<List<Poll>> pollGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"pollId\" : 101, \"proposals\" : [ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }, { \"meetingId\" : 12, \"subject\" : \"Design Review\", \"date\" : \"2025-02-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"no\" } } ], \"isPublished\" : false }, { \"pollId\" : 101, \"proposals\" : [ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }, { \"meetingId\" : 12, \"subject\" : \"Design Review\", \"date\" : \"2025-02-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"no\" } } ], \"isPublished\" : false } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /poll/{id}
     * Delete a specific poll
     *
     * @param id The unique identifier of the poll (required)
     * @return Successfully deleted a poll (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollIdDelete
     */
    default ResponseEntity<Void> pollIdDelete(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /poll/{id}
     * Retrieve details of a specific poll
     *
     * @param id The unique identifier of the poll (required)
     * @return Successfully retrieved the poll details (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollIdGet
     */
    default ResponseEntity<Poll> pollIdGet(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pollId\" : 101, \"proposals\" : [ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }, { \"meetingId\" : 12, \"subject\" : \"Design Review\", \"date\" : \"2025-02-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"no\" } } ], \"isPublished\" : false }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /poll/{id}
     * Publish a poll by setting its isPublished field to true
     *
     * @param id The unique identifier of the poll (required)
     * @param pollIdPatchRequest  (required)
     * @return Poll successfully updated (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollIdPatch
     */
    default ResponseEntity<Poll> pollIdPatch(Integer id,
        PollIdPatchRequest pollIdPatchRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pollId\" : 101, \"proposals\" : [ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }, { \"meetingId\" : 12, \"subject\" : \"Design Review\", \"date\" : \"2025-02-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"no\" } } ], \"isPublished\" : false }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /poll/{pollId}/ProposedMeeting
     * Retrieve all proposed meetings of a specific poll
     *
     * @param pollId The unique identifier of the poll (required)
     * @return Successfully retrieved proposed meetings of the poll (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollPollIdProposedMeetingGet
     */
    default ResponseEntity<List<ProposedMeeting>> pollPollIdProposedMeetingGet(Integer pollId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }, { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /poll/{pollId}/ProposedMeeting/{meetingId}
     * Delete a specific proposed meeting from a specific poll
     *
     * @param pollId The unique identifier of the poll (required)
     * @param meetingId The unique identifier of the meeting (required)
     * @return Successfully deleted a meeting proposal from the poll (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollPollIdProposedMeetingMeetingIdDelete
     */
    default ResponseEntity<Void> pollPollIdProposedMeetingMeetingIdDelete(Integer pollId,
        Integer meetingId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /poll/{pollId}/ProposedMeeting/{meetingId}
     * Retrieve a specific proposed meeting from a specific poll
     *
     * @param pollId The unique identifier of the poll (required)
     * @param meetingId The unique identifier of the meeting (required)
     * @return Successfully retrieved a proposed meeting from the poll (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollPollIdProposedMeetingMeetingIdGet
     */
    default ResponseEntity<ProposedMeeting> pollPollIdProposedMeetingMeetingIdGet(Integer pollId,
        Integer meetingId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /poll/{pollId}/ProposedMeeting/{meetingId}
     * Vote for a meeting in a poll by creating a \&quot;user\&quot; object (name, availability) and adding it to the selected proposed meeting in the selected poll 
     *
     * @param pollId The unique identifier of the poll (required)
     * @param meetingId The unique identifier of the meeting (required)
     * @param pollPollIdProposedMeetingMeetingIdPatchRequest  (required)
     * @return Poll successfully updated (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollPollIdProposedMeetingMeetingIdPatch
     */
    default ResponseEntity<Poll> pollPollIdProposedMeetingMeetingIdPatch(Integer pollId,
        Integer meetingId,
        PollPollIdProposedMeetingMeetingIdPatchRequest pollPollIdProposedMeetingMeetingIdPatchRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"pollId\" : 101, \"proposals\" : [ { \"meetingId\" : 11, \"subject\" : \"Design Review\", \"date\" : \"2025-01-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"maybe\" } }, { \"meetingId\" : 12, \"subject\" : \"Design Review\", \"date\" : \"2025-02-25\", \"participants\" : { \"Alice\" : \"yes\", \"Bob\" : \"no\" } } ], \"isPublished\" : false }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /poll/{pollId}/ProposedMeeting
     * add a new proposed meeting to the poll
     *
     * @param pollId The unique identifier of the poll (required)
     * @param proposedMeeting  (required)
     * @return Successfully proposed a meeting to the poll (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollPollIdProposedMeetingPost
     */
    default ResponseEntity<Void> pollPollIdProposedMeetingPost(Integer pollId,
        ProposedMeeting proposedMeeting) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /poll
     * Add a new poll to the dashboard 
     *
     * @param poll  (required)
     * @return Successfully created a new poll and added it to the dashboard (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     * @see PollApi#pollPost
     */
    default ResponseEntity<Void> pollPost(Poll poll) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
