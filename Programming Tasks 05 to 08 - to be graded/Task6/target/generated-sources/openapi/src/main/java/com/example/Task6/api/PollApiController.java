package com.example.Task6.api;

import com.example.Task6.model.Poll;
import com.example.Task6.model.PollIdPatchRequest;
import com.example.Task6.model.PollPollIdProposedMeetingMeetingIdPatchRequest;
import com.example.Task6.model.ProposedMeeting;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T12:49:00.769420277+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.schedulerApp.base-path:}")
public class PollApiController implements PollApi {

    private final PollApiDelegate delegate;

    public PollApiController(@Autowired(required = false) PollApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PollApiDelegate() {});
    }

    @Override
    public PollApiDelegate getDelegate() {
        return delegate;
    }

}
