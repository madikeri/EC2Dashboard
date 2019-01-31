
package org.ec2.cisco;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import org.ec2.cisco.Instances;
import org.ec2.cisco.InstancesService;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.ec2.cisco.EC2Controller;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRunner.class)
@WebMvcTest(EC2Controller.class)

public class TestEc2  {

	@MockBean
	 InstancesService service ; 
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void testListAllEc2()
	  throws Exception {
	     
		System.out.println("inside testListAllEc2");

	    List<Instances> allInstances = new ArrayList<Instances>();	 
	    
		Instances instance = new Instances();		
		instance.setName("MyFirstServer");
		instance.setInstance_id("a-123456abcd");
		instance.setType("t2.medium");
		instance.setState("running");
		instance.setAz("us-east-1b");
		instance.setPublicIP("54.210.167.204");
		instance.setPrivateIP("10.20.30.40");
		
		allInstances.add(instance);
		
		Instances instance1 = new Instances();		
		instance1.setName("MySecondServer");
		instance1.setInstance_id("b-123457abcd");
		instance1.setType("t1.micro");
		instance1.setState("pending");
		instance1.setAz("us-east-1d");
		instance1.setPublicIP("54.210.167.205");
		instance1.setPrivateIP("10.20.30.41");
	
		allInstances.add(instance1);
		System.out.println("size:" + allInstances.size());

	    given(service.listAllInstances()).willReturn(allInstances);
	    System.out.println("entering test");

	    // this test is expected to pass because, we are creating only 2 instances 
	    // and here we are checking to see if it has the size 2  
	    // and matching the first name to the name of the instance
	    MvcResult result =   mvc.perform(get("/listAll")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(2)))
	      .andExpect(jsonPath("$[0].name", is(instance.getName()))).andReturn();
	    
	    String content = result.getResponse().getContentAsString();

	    System.out.println("Test Passed: " + content);
	    
	}
	
}
