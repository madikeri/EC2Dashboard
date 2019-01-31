package org.ec2.cisco;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class EC2Controller {
	
	@Autowired
	private InstancesService instanceService;
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
	
	public @ResponseBody List<Instances> instanceResults(ModelMap model, Principal principal) {
			System.out.println("inside listAll");
		
		List<Instances> listAllInstances = new ArrayList();	
		Iterable<Instances> instanceList = instanceService.listAllInstances();
		//Doa returns an iterable, so converting to a list
		for(Instances instance_i : instanceList){	
			listAllInstances.add(instance_i);			
		}
		if(listAllInstances == null || listAllInstances.isEmpty())
		{
			System.out.println("The List is null or there is a Error");
			return null;
		}
		System.out.println("DATASET:"+ listAllInstances);
		

		return listAllInstances;
		
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Instances> searchResults(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {			
		
		String searchObj = request.getParameter("searchObj");

		ObjectMapper mapper = new ObjectMapper();

		InstancesSearchCriteria instanceSearchCriteria = mapper.readValue(searchObj, InstancesSearchCriteria.class);
		System.out.println("name: " + instanceSearchCriteria.getName());
		System.out.println("type: " + instanceSearchCriteria.getType());
		
		Iterable<Instances> instanceList = instanceService.search(instanceSearchCriteria);
		if(instanceList == null){
			return null;
		}
		System.out.println("back from search:"+ instanceList.toString());
		
		List<Instances> listAllInstances = new ArrayList();	
		
		for(Instances instance_i : instanceList){	
			listAllInstances.add(instance_i);			
		}
		
		if( listAllInstances.isEmpty())
		{
			System.out.println("The List is null or there is a Error");
			return listAllInstances;
		}
		System.out.println("DATASET:"+ listAllInstances);
		

		return listAllInstances;
		
	}
	
	
    @RequestMapping("/listAllec2s")
	String listEC2(ModelMap model, Principal principal) {
    	//returns the html page
    	return "view";
    }
	
	
}


 