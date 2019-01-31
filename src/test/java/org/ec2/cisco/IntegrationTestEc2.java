
package org.ec2.cisco;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

// Integration Test - Here, we are "mocking the mvc" and test without starting the server.

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=  SpringBootTest.WebEnvironment.MOCK, classes = App.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class IntegrationTestEc2  {

		
	@Autowired
	private MockMvc mvc;
	
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	public void testListAllEc2()
	  throws Exception {
	     
		System.out.println("inside testListAllEc2");

		// This test is expected to be passed because, the baseloader is loading 19 instances
		// and the name of the first instance matches "A_instance"
		
	    MvcResult result =   mvc.perform(get("/listAll")	    			
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(19)))
	      .andExpect(jsonPath("$[0].name", is("A_instance"))).andReturn();
	    
	    String content = result.getResponse().getContentAsString();

	    System.out.println("TEST PASSED: " + content);
	   
	}
	
}
