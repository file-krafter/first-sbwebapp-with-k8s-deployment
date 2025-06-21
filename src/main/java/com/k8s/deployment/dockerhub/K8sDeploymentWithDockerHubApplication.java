package com.k8s.deployment.dockerhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "K8s-1 Deployment, User and request details Services ", version = "1.0", description = "K8s-1, get request and user details"))
public class K8sDeploymentWithDockerHubApplication extends SpringBootServletInitializer{
 
	public static void main(String[] args) {
		SpringApplication.run(K8sDeploymentWithDockerHubApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(K8sDeploymentWithDockerHubApplication.class);
	}
	
	
 

}
