package com.k8s.deployment.dockerhub.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Tag(name = "Request Details", description = "Fetch client request information")
public class UserRequestController {

	    @GetMapping("/request-info")
	    @Operation(summary = "Get request details", description = "Returns IP address, headers, and other request details")
	    public Map<String, String> getRequestDetails(HttpServletRequest request) {
	        Map<String, String> details = new HashMap<>();

	        details.put("IP Address", request.getRemoteAddr());
	        details.put("User-Agent", request.getHeader("User-Agent"));
	        details.put("Host", request.getHeader("Host"));
	        details.put("Referer", request.getHeader("Referer"));
	        details.put("Accept-Language", request.getHeader("Accept-Language"));

	        return details;
	    }

}
