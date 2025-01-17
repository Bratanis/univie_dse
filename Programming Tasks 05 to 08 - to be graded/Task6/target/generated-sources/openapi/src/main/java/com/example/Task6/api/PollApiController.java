package com.example.Task6.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T18:20:59.534882768+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
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
