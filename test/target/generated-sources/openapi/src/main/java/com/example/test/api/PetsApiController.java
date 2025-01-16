package com.example.test.api;

import java.util.Optional;

import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T18:37:34.134444630+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.swaggerPetstore.base-path:}")
public class PetsApiController implements PetsApi {

    private final PetsApiDelegate delegate;

    public PetsApiController(@Autowired(required = false) PetsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PetsApiDelegate() {});
    }

    @Override
    public PetsApiDelegate getDelegate() {
        return delegate;
    }

}
