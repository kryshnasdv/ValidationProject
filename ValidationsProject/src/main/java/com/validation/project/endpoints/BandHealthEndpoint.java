package com.validation.project.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="check",enableByDefault = true)
public class BandHealthEndpoint {
		
	@ReadOperation
    public String getMessage() {
        return "Checkpoint Hit";
    }

}
