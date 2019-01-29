
package org.ec2.cisco.model;


import java.util.Date;

import org.ec2.cisco.model.Instances;


public class EC2CustomSearchResult {
	private String name;
	private String id;
	private String type;
	private String state;
	private String az;
	private String ip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAz() {
		return az;
	}
	public void setAz(String az) {
		this.az = az;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "EC2CustomSearchResult [name=" + name + ", id=" + id + ", type=" + type + ", state=" + state + ", az="
				+ az + ", ip=" + ip + "]";
	}
	
	
	
	
	
}