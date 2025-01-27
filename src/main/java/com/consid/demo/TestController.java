package com.consid.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User API", description = "API for managing users")
public class TestController {

	@GetMapping("/")
	public String demo() {
		return "application name : Consid Demo Project";
	}

	@GetMapping("/test")
	@Operation(summary = "Get test ", description = "Retrieve demo-test string.")

	public String test() {
		return "application : demo-test";
	}

	@GetMapping("/{name}")
	@Operation(summary = "Retrieves a json", description = "Retrieves a host name and ip and name as input.")

	public ResponseEntity<ResponseOut> demoWithParameters(@PathVariable(name = "name", required = true) String name) {

		String hostName = "";
		String hostIp = "";

		try {
			hostName = InetAddress.getLocalHost().getHostName();
			hostIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ResponseOut(hostName, hostIp, name), HttpStatus.OK);

	}

}
