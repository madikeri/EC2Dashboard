
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



@Controller
public class EC2Controller {
	
	@Autowired
	private InstancesService instanceService;
	
	
	//opens list of instances with details using data tables 
	@RequestMapping("/instance/manage")
	public String instanceManage(ModelMap model, Principal principal) {
		
		String n = principal.getName().toString();
		model.addAttribute("username", n);
		Instances instance = instanceService.getInstanceById(principal.get) .getAgentByUsername(n);
		model.addAttribute("role", agent.getRole());
		
		Agent updatingAgent = agentService.getAgentByUsername(n);
		
		if ((updatingAgent.getRole().getRole_id() == 3)) {
			model.addAttribute("edit", true);
		}
		else{
			model.addAttribute("edit", false);
		}

		List<Department> depts = Lists.newArrayList(departmentService.listAllDepartment());
		if (depts.size() > 0) {
			Collections.sort(depts, new Comparator<Department>() {
				@Override
				public int compare(final Department object1, final Department object2) {
					return object1.getName().compareTo(object2.getName());
				}
			});
		}


		model.addAttribute("agents", agentService.listAgentsForMenu());
		
		return "user_management";
	}
	
	
	@RequestMapping("/instance/view")
	public String instanceView(ModelMap model, Principal principal) {
	
		String n = principal.getName().toString();
		model.addAttribute("username", n);
		Agent agent = agentService.getAgentByUsername(n);
		

		model.addAttribute("role", agent.getRole());
		
		
		Agent updatingAgent = agentService.getAgentByUsername(n);
		
		if ((updatingAgent.getRole().getRole_id() == 3)) {
			model.addAttribute("edit", true);
		}
		else{
			model.addAttribute("edit", false);
		}
		List<Department> depts = Lists.newArrayList(departmentService.listAllDepartment());
		
		
		/*
		if (depts.size() > 0) {
			Collections.sort(depts, new Comparator<Department>() {
				@Override
				public int compare(final Department object1, final Department object2) {
					return object1.getName().compareTo(object2.getName());
				}
			});
		}
		*/
		model.addAttribute("roles", roleService.listAllRole());
		model.addAttribute("departments", depts);

		model.addAttribute("agents", agentService.listAgentsForMenu());
		log.debug("returning user_add");
		return "user_add";
	}
	
	
	
	
	
}


 