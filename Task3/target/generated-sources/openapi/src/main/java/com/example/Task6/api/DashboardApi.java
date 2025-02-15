/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.Task6.api;

import com.example.Task6.model.MeetingsDashboard;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-18T19:11:04.541998563+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "dashboard", description = "the dashboard API")
public interface DashboardApi {

    default DashboardApiDelegate getDelegate() {
        return new DashboardApiDelegate() {};
    }

    /**
     * GET /dashboard/export
     * Retrieve all data, including scheduled meetings  and ongoing polls in JSON format 
     *
     * @return Exported data in JSON format. (status code 200)
     *         or Bad request - invalid or missing input data (status code 400)
     *         or Unauthorized - authentication required (status code 401)
     *         or Forbidden - insufficient permissions (status code 403)
     *         or Not found - resource does not exist (status code 404)
     *         or Internal server error - unexpected issue on the server (status code 500)
     */
    @Operation(
        operationId = "dashboardExportGet",
        description = "Retrieve all data, including scheduled meetings  and ongoing polls in JSON format ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Exported data in JSON format.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MeetingsDashboard.class)),
                @Content(mediaType = "text/csv", schema = @Schema(implementation = MeetingsDashboard.class))
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
        value = "/dashboard/export",
        produces = { "application/json", "text/csv" }
    )
    
    default ResponseEntity<MeetingsDashboard> dashboardExportGet(
        
    ) {
        return getDelegate().dashboardExportGet();
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
     */
    @Operation(
        operationId = "dashboardGet",
        description = "Get the whole dashboard, containing all of the scheduled meetings and all of the polls that are ongoing ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful pull of dashboard object", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MeetingsDashboard.class))
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
        value = "/dashboard",
        produces = { "application/json" }
    )
    
    default ResponseEntity<MeetingsDashboard> dashboardGet(
        
    ) {
        return getDelegate().dashboardGet();
    }

}
