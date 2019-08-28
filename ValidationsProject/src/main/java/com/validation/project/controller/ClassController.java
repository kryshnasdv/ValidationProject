package com.validation.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.project.model.Band;
import com.validation.project.model.ErrorResponse;
import com.validation.project.model.Response;

@RestController
public class ClassController {

	@GetMapping(value="/getBandInfoById/{employeeId}")
	private ResponseEntity<Response> getInfoById(@Valid Band band,BindingResult bindingResult){
		Response response = new Response();
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			List<String> message = new ArrayList<>();
			for (FieldError e : errors){
				message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
			}

			response.setStatus("Error");
			response.setPayload("Bad request- Binding Error");
			
			ErrorResponse errorResponse;
			
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, message.get(0));

			response.setErrorResponse(errorResponse);

			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		else
		{
			response.setStatus("Success");
			response.setPayload(band.getEmployeeId());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}

	}

}
