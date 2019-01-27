package org.ec2.cisco.bootstrap;

import org.apache.log4j.Logger;
import org.ec2.cisco.model.Instances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import org.ec2.cisco.services.*;
//import com.nationaltravel.portal.bootstrap.BaseLoader;

//name, id (e.g. a-123456abcd), type (e.g. t2.medium), state (e.g. running), az (e.g. "us-east-1b"), 
//public IP (e.g. "54.210.167.204"), private IPs (e.g. "10.20.30.40").

//@Profile("default")
public class BaseLoader implements ApplicationListener<ContextRefreshedEvent> {
//	@Autowired
	private String name;
	private String id;
	private String type;
	private String state;
	private String az;
	private String publicIP;
	private String privateIP;
	
	
	private static final Logger log = Logger.getLogger(BaseLoader.class);

	@Autowired
	private InstancesService instanceService;





	
	private void loadInstances() {
		
		Instances instance = new Instances();		
		instance.setName("MyFirstServer");
		instance.setId("a-123456abcd");
		instance.setType("t2.medium");
		instance.setState("running");
		instance.setAz("us-east-1b");
		instance.setPublicIP("54.210.167.204");
		instance.setPrivateIP("10.20.30.40");
		instanceService.saveInstance(instance);

		instance = new Instances();		
		instance.setName("MySecondServer");
		instance.setId("b-123457abcd");
		instance.setType("t1.micro");
		instance.setState("pending");
		instance.setAz("us-east-1d");
		instance.setPublicIP("54.210.167.205");
		instance.setPrivateIP("10.20.30.41");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("MythirdServer");
		instance.setId("c-123458abcd");
		instance.setType("m3.large");
		instance.setState("shutting down");
		instance.setAz("us-east-1c");
		instance.setPublicIP("54.210.167.206");
		instance.setPrivateIP("10.20.30.42");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("MyFourthServer");
		instance.setId("d-123459abcd");
		instance.setType("r3.medium");
		instance.setState("terminated");
		instance.setAz("us-west-1c");
		instance.setPublicIP("54.210.167.208");
		instance.setPrivateIP("10.20.30.47");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("MyFifthServer");
		instance.setId("e-123461abcd");
		instance.setType("m3.large");
		instance.setState("running");
		instance.setAz("us-west-1c");
		instance.setPublicIP("54.210.167.301");
		instance.setPrivateIP("10.20.30.52");
		instanceService.saveInstance(instance);
		
		
		instance = new Instances();		
		instance.setName("MySixthServer");
		instance.setId("f-123462abcd");
		instance.setType("m3.medium");
		instance.setState("running");
		instance.setAz("us-west-1b");
		instance.setPublicIP("54.210.167.304");
		instance.setPrivateIP("10.20.30.56");
		instanceService.saveInstance(instance);
		
		
		
		
		
	
	}





	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		loadInstances();

	}



}
