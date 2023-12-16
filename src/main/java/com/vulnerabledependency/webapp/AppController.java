package com.vulnerabledependency.webapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Updated dependency")
public class AppController {
	Logger log = LogManager.getLogger(AppController.class);

	@PostMapping("/getUserName")
	@Operation(summary = "Server Program uses non-vulnerable log4j dependency", description = "{java:version} prefix by $ in either firstName or LastName will not run the command")
	public String getDetailLogs(@RequestBody() User user) {
		log.info("User First Name: {}" , user.getFirstName());
		log.info("User Last Name: {}" , user.getLastName());
		return user.getFirstName() + " "+ user.getLastName();
	}
}
