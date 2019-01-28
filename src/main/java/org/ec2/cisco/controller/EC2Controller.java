
package org.ec2.cisco.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import org.ec2.cisco.dao.*;
import org.ec2.cisco.dao.crudrepository.*;
import org.ec2.cisco.dao.customrepository.*;
import org.ec2.cisco.services.*;
import org.ec2.cisco.model.*;


import org.apache.commons.compress.utils.IOUtils;
import org.apache.log4j.Logger;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import org.ec2.cisco.model.*;


@Controller
public class EC2Controller {
	
	@Autowired
	private InstancesService instanceService;
	
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
	
	public @ResponseBody List<Instances> instanceResults(ModelMap model, Principal principal) {
			
//		String n = principal.getName().toString();
		
		List<Instances> listAllInstances = new ArrayList();	
		Iterable<Instances> instanceList = instanceService.listAllInstances();
		
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
//		String n = principal.getName().toString();
		
		String searchObj = request.getParameter("searchObj");
		//searchObj= searchObj.substring(1,searchObj.length()-1);
		//log.debug("searchObj:"+searchObj);
		
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
		System.out.println("after for:");
		
		
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
    	
    	return "view";
    }
	
	
}


 