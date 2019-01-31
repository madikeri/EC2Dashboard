package org.ec2.cisco;

import org.apache.log4j.Logger;
import org.ec2.cisco.Instances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class BaseLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger log = Logger.getLogger(BaseLoader.class);

	@Autowired
	private InstancesService instanceService;

	private void loadInstances() {
		//creating mock instances for demo purposes
		
		Instances instance = new Instances();		
		instance.setName("A_instance");
		instance.setInstance_id("h-123456abcd");
		instance.setType("t2.medium");
		instance.setState("running");
		instance.setAz("us-east-1b");
		instance.setPublicIP("54.210.555.204");
		instance.setPrivateIP("10.40.30.40");
		instanceService.saveInstance(instance);

		instance = new Instances();		
		instance.setName("B_instance");
		instance.setInstance_id("b-123457abcd");
		instance.setType("t1.micro");
		instance.setState("pending");
		instance.setAz("us-east-1d");
		instance.setPublicIP("54.210.167.205");
		instance.setPrivateIP("10.20.30.41");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("C_instance");
		instance.setInstance_id("c-123458abcd");
		instance.setType("m3.large");
		instance.setState("shutting down");
		instance.setAz("us-east-1c");
		instance.setPublicIP("54.210.167.206");
		instance.setPrivateIP("10.20.30.42");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("D_instance");
		instance.setInstance_id("d-123459abcd");
		instance.setType("r3.medium");
		instance.setState("terminated");
		instance.setAz("us-west-1c");
		instance.setPublicIP("34.210.167.208");
		instance.setPrivateIP("10.20.30.47");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("E_instance");
		instance.setInstance_id("t-123461abcd");
		instance.setType("m2.large");
		instance.setState("running");
		instance.setAz("us-east-1c");
		instance.setPublicIP("54.210.137.301");
		instance.setPrivateIP("10.20.33.52");
		instanceService.saveInstance(instance);
		
		
		instance = new Instances();		
		instance.setName("F_instance");
		instance.setInstance_id("s-123462abcd");
		instance.setType("r3.medium");
		instance.setState("running");
		instance.setAz("us-west-1b");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		
		instance = new Instances();		
		instance.setName("G_instance");
		instance.setInstance_id("r-123462abcd");
		instance.setType("b3.small");
		instance.setState("running");
		instance.setAz("us-east-1b");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("H_instance");
		instance.setInstance_id("q-123462abcd");
		instance.setType("m1.micro");
		instance.setState("shutting down");
		instance.setAz("us-east-1b");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("I_instance");
		instance.setInstance_id("p-123462abcd");
		instance.setType("m3.medium");
		instance.setState("pending");
		instance.setAz("us-east-1b");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("J_instance");
		instance.setInstance_id("o-123462abcd");
		instance.setType("m3.large");
		instance.setState("terminated");
		instance.setAz("us-west-1c");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("K_instance");
		instance.setInstance_id("n-123462abcd");
		instance.setType("m3.medium");
		instance.setState("pending");
		instance.setAz("us-east-1a");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("L_instance");
		instance.setInstance_id("m-123462abcd");
		instance.setType("m3.medium");
		instance.setState("running");
		instance.setAz("us-west-1c");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("M_instance");
		instance.setInstance_id("l-123462abcd");
		instance.setType("m3.medium");
		instance.setState("shutting down");
		instance.setAz("us-east-1a");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("N_instance");
		instance.setInstance_id("k-123462abcd");
		instance.setType("m3.small");
		instance.setState("pending");
		instance.setAz("us-west-1s");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("O_instance");
		instance.setInstance_id("j-123462abcd");
		instance.setType("h2.large");
		instance.setState("shutting down");
		instance.setAz("us-east-1c");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("P_instance");
		instance.setInstance_id("i-123462abcd");
		instance.setType("p3.small");
		instance.setState("pending");
		instance.setAz("us-west-1e");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("V_instance");
		instance.setInstance_id("h-123462abcd");
		instance.setType("r2.micro");
		instance.setState("terminated");
		instance.setAz("us-east-1f");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("R_instance");
		instance.setInstance_id("g-123462abcd");
		instance.setType("m3.micro");
		instance.setState("running");
		instance.setAz("us-west-1c");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		instance = new Instances();		
		instance.setName("S_instance");
		instance.setInstance_id("z-123462abcd");
		instance.setType("r3.large");
		instance.setState("pending");
		instance.setAz("us-east-1e");
		instance.setPublicIP("54.260.167.304");
		instance.setPrivateIP("10.40.30.56");
		instanceService.saveInstance(instance);
		
		System.out.println("loading instances done");
		
	}

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		log.debug("about to call loadInstances");
		System.out.println("about to call loadInstances");
		
		loadInstances();

	}

}
