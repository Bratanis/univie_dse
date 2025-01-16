/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.Task6.api;

import com.example.Task6.model.Meeting;
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
@Tag(name = "meeting", description = "the meeting API")
public interface MeetingApi {

    default MeetingApiDelegate getDelegate() {
        return new MeetingApiDelegate() {};
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
     */
    @Operation(
        operationId = "meetingGet",
        description = "Get all of the scheduled meetings ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful pull of meetings", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Meeting.class)))
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
        value = "/meeting",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Meeting>> meetingGet(
        
    ) {
        return getDelegate().meetingGet();
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
     */
    @Operation(
        operationId = "meetingIdDelete",
        description = "Delete a specific meeting",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted a meeting"),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/meeting/{id}"
    )
    
    default ResponseEntity<Void> meetingIdDelete(
        @Min(0) @Max(999) @Parameter(name = "id", description = "The unique identifier of the meeting", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return getDelegate().meetingIdDelete(id);
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
     */
    @Operation(
        operationId = "meetingIdGet",
        description = "Retrieve details of a specific meeting",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the meeting details", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Meeting.class))
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
        value = "/meeting/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Meeting> meetingIdGet(
        @Min(0) @Max(999) @Parameter(name = "id", description = "The unique identifier of the meeting", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return getDelegate().meetingIdGet(id);
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
     */
    @Operation(
        operationId = "meetingPost",
        description = "Add a new meeting to the dashboard ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully created a new meeting and added it to the dashboard"),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid or missing input data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized - authentication required"),
            @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
            @ApiResponse(responseCode = "404", description = "Not found - resource does not exist"),
            @ApiResponse(responseCode = "500", description = "Internal server error - unexpected issue on the server")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/meeting",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> meetingPost(
        @Parameter(name = "Meeting", description = "", required = true) @Valid @RequestBody Meeting meeting
    ) {
        return getDelegate().meetingPost(meeting);
    }

}
