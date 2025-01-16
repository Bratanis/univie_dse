/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.Task6.api;

import com.example.Task6.model.Poll;
import com.example.Task6.model.PollIdPatchRequest;
import com.example.Task6.model.PollPollIdProposedMeetingMeetingIdPatchRequest;
import com.example.Task6.model.ProposedMeeting;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T23:12:21.815558952+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "poll", description = "the poll API")
public interface PollApi {

    default PollApiDelegate getDelegate() {
        return new PollApiDelegate() {};
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
     */
    @Operation(
        operationId = "pollGet",
        description = "Get all of the polls ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful pull of polls", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Poll.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poll",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Poll>> pollGet(
        
    ) {
        return getDelegate().pollGet();
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
     */
    @Operation(
        operationId = "pollIdDelete",
        description = "Delete a specific poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a poll"),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/poll/{id}"
    )
    
    default ResponseEntity<Void> pollIdDelete(
        @Min(0) @Max(999) @Parameter(name = "id", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return getDelegate().pollIdDelete(id);
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
     */
    @Operation(
        operationId = "pollIdGet",
        description = "Retrieve details of a specific poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the poll details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Poll.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poll/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Poll> pollIdGet(
        @Min(0) @Max(999) @Parameter(name = "id", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return getDelegate().pollIdGet(id);
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
     */
    @Operation(
        operationId = "pollIdPatch",
        description = "Publish a poll by setting its isPublished field to true",
        responses = {
            @ApiResponse(responseCode = "200", description = "Poll successfully updated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Poll.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/poll/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Poll> pollIdPatch(
        @Min(0) @Max(999) @Parameter(name = "id", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "PollIdPatchRequest", description = "", required = true) @Valid @RequestBody PollIdPatchRequest pollIdPatchRequest
    ) {
        return getDelegate().pollIdPatch(id, pollIdPatchRequest);
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
     */
    @Operation(
        operationId = "pollPollIdProposedMeetingGet",
        description = "Retrieve all proposed meetings of a specific poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved proposed meetings of the poll", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProposedMeeting.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poll/{pollId}/ProposedMeeting",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ProposedMeeting>> pollPollIdProposedMeetingGet(
        @Min(0) @Max(999) @Parameter(name = "pollId", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("pollId") Integer pollId
    ) {
        return getDelegate().pollPollIdProposedMeetingGet(pollId);
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
     */
    @Operation(
        operationId = "pollPollIdProposedMeetingMeetingIdDelete",
        description = "Delete a specific proposed meeting from a specific poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a meeting proposal from the poll"),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/poll/{pollId}/ProposedMeeting/{meetingId}"
    )
    
    default ResponseEntity<Void> pollPollIdProposedMeetingMeetingIdDelete(
        @Min(0) @Max(999) @Parameter(name = "pollId", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("pollId") Integer pollId,
        @Min(0) @Max(999) @Parameter(name = "meetingId", description = "The unique identifier of the meeting", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") Integer meetingId
    ) {
        return getDelegate().pollPollIdProposedMeetingMeetingIdDelete(pollId, meetingId);
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
     */
    @Operation(
        operationId = "pollPollIdProposedMeetingMeetingIdGet",
        description = "Retrieve a specific proposed meeting from a specific poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved a proposed meeting from the poll", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProposedMeeting.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poll/{pollId}/ProposedMeeting/{meetingId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ProposedMeeting> pollPollIdProposedMeetingMeetingIdGet(
        @Min(0) @Max(999) @Parameter(name = "pollId", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("pollId") Integer pollId,
        @Min(0) @Max(999) @Parameter(name = "meetingId", description = "The unique identifier of the meeting", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") Integer meetingId
    ) {
        return getDelegate().pollPollIdProposedMeetingMeetingIdGet(pollId, meetingId);
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
     */
    @Operation(
        operationId = "pollPollIdProposedMeetingMeetingIdPatch",
        description = "Vote for a meeting in a poll by creating a \"user\" object (name, availability) and adding it to the selected proposed meeting in the selected poll ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Poll successfully updated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Poll.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/poll/{pollId}/ProposedMeeting/{meetingId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Poll> pollPollIdProposedMeetingMeetingIdPatch(
        @Min(0) @Max(999) @Parameter(name = "pollId", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("pollId") Integer pollId,
        @Min(0) @Max(999) @Parameter(name = "meetingId", description = "The unique identifier of the meeting", required = true, in = ParameterIn.PATH) @PathVariable("meetingId") Integer meetingId,
        @Parameter(name = "PollPollIdProposedMeetingMeetingIdPatchRequest", description = "", required = true) @Valid @RequestBody PollPollIdProposedMeetingMeetingIdPatchRequest pollPollIdProposedMeetingMeetingIdPatchRequest
    ) {
        return getDelegate().pollPollIdProposedMeetingMeetingIdPatch(pollId, meetingId, pollPollIdProposedMeetingMeetingIdPatchRequest);
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
     */
    @Operation(
        operationId = "pollPollIdProposedMeetingPost",
        description = "add a new proposed meeting to the poll",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully proposed a meeting to the poll"),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/poll/{pollId}/ProposedMeeting",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> pollPollIdProposedMeetingPost(
        @Min(0) @Max(999) @Parameter(name = "pollId", description = "The unique identifier of the poll", required = true, in = ParameterIn.PATH) @PathVariable("pollId") Integer pollId,
        @Parameter(name = "ProposedMeeting", description = "", required = true) @Valid @RequestBody ProposedMeeting proposedMeeting
    ) {
        return getDelegate().pollPollIdProposedMeetingPost(pollId, proposedMeeting);
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
     */
    @Operation(
        operationId = "pollPost",
        description = "Add a new poll to the dashboard ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully created a new poll and added it to the dashboard"),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/poll",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> pollPost(
        @Parameter(name = "Poll", description = "", required = true) @Valid @RequestBody Poll poll
    ) {
        return getDelegate().pollPost(poll);
    }

}
