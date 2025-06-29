package com.k8s.deployment.dockerhub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/common-api")
@Tag(name = "Common Info", description = "Provides server time, app info, and request count")
public class CommonInfoController {

    @Value("${spring.application.name:ingress-nginx-controller-test}")
    private String appName;

    @Value("${spring.profiles.active:mk-local-cluster}")
    private String activeProfile;

    private final AtomicInteger requestCount = new AtomicInteger(0);

    @GetMapping("/status")
    @Operation(summary = "Get server and app info", description = "Returns server time, app name, active profile, and request count")
    public Map<String, String> getServerStatus() {
        Map<String, String> info = new HashMap<>();

        info.put("Server Time", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        info.put("Application Name", appName);
        info.put("Active Profile", activeProfile);
        info.put("Request Count", String.valueOf(requestCount.incrementAndGet()));

        return info;
    }
}
