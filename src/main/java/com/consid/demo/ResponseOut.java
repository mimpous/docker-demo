package com.consid.demo;

public class ResponseOut {

	private String hostname;
	private String hostip;
	private String name;
	
	public ResponseOut(String hostname, String hostIp , String name ) {
		this.hostname = hostname; 
		this.hostip = hostIp; 
		this.name = name;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHostip() {
		return hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
