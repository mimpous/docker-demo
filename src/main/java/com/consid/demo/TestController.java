package com.consid.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") 
public class TestController {

	@RequestMapping("/")
	public String demo() {
		return "application name : Consid Demo Project";
	}
	@RequestMapping("/api/test")
	public String test() {
		return "application name : this is a test";
	}
	
	
	@RequestMapping("/api/{name}")
	public ResponseEntity<ResponseOut>  demoWithParameters( @PathVariable(name = "name", required = true ) String name ) {
		
		String hostName = "";
		String hostIp = "";
		
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			hostIp  = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return  new ResponseEntity<>( new ResponseOut( hostName, hostIp, name), HttpStatus.OK);
		
	}
	
	
}
