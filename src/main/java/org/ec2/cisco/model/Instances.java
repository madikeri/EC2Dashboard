
package org.ec2.cisco.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "instances")
@NamedQueries({
@NamedQuery(name="instances.findForMenus", query="SELECT a.id, ap.first_name,ap.last_name FROM Agent a LEFT JOIN a.person ap WHERE a.active = 1"),
@NamedQuery(name="instances.findForMenusWithEmail", query="SELECT a.id, ap.first_name,ap.last_name, ap.email FROM Agent a LEFT JOIN a.person ap WHERE a.active = 1"),
@NamedQuery(name="instances.findAgentPerson", query="SELECT a.id, ap.first_name,ap.last_name FROM Agent a LEFT JOIN a.person ap where a.id =:id"),
//@NamedQuery(name="agent.byUserName", query="SELECT a.id,a.username,ar.role_id FROM Agent a  LEFT JOIN a.role ar where a.google_user_name =:username AND a.active=1"),
@NamedQuery(name="instances.byUserName", query="SELECT a.id,a.username FROM Agent a where a.google_user_name =:username AND a.active=1"),
})
public class Instances implements Serializable, Comparable<Instances>{

	//This is auto generated, not sure why
	public int compareTo(Instances o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private String name;
	private String id;
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
		return "Instances [name=" + name + ", id=" + id + ", type=" + type + ", state=" + state + ", az=" + az
				+ ", publicIP=" + publicIP + ", privateIP=" + privateIP + "]";
	}
	


	
}
	
