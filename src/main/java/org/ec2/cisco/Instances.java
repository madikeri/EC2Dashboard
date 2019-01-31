
package org.ec2.cisco;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "instances")

public class Instances implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String name;
	private String instance_id;
	private String type;
	private String state;
	private String az;
	private String publicIP;
	private String privateIP;
	
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
	public String getPublicIP() {
		return publicIP;
	}
	public void setPublicIP(String publicIP) {
		this.publicIP = publicIP;
	}
	public String getPrivateIP() {
		return privateIP;
	}
	public void setPrivateIP(String privateIP) {
		this.privateIP = privateIP;
	}
	@Override
	public String toString() {
		return "Instances [id=" + id + ", name=" + name + ", instance_id=" + instance_id + ", type=" + type + ", state="
				+ state + ", az=" + az + ", publicIP=" + publicIP + ", privateIP=" + privateIP + "]";
	}
	public String getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}
	


	
}
	
