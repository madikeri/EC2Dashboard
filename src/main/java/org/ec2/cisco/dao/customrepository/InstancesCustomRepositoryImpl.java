
package org.ec2.cisco.dao.customrepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import org.ec2.cisco.controller.*;
import org.ec2.cisco.dao.crudrepository.*;
import org.ec2.cisco.model.Instances;

import org.apache.log4j.Logger;



@Service
@Transactional
public class InstancesCustomRepositoryImpl implements InstancesCustomRepository{

	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	InstancesCrudRepository instanceRepo;
	
	
	public List<Instances> retrieveInstancessForMenus() {
		List<Instances> instances = new ArrayList();
		List<Object[]> objs = em.createNamedQuery("instance.findForMenus").getResultList();
		for(Object[] o : objs){
			Instances instance = new Instances();
			instance.setId((String)o[0]);
				
		}
		return instances;
	}
	
	public Instances retrieveInstancebyname(String name) {
		
		List<Object[]> objs = em.createNamedQuery("instance.byName").setParameter("name", name).getResultList();
		for(Object[] o : objs){
			Instances instance = new Instances();
			instance.setId((String)o[0]);
			instance.setName((String) o[1]);


			return instanceRepo.findOne(instance.getId());	
		}
		return null;
	}



	
}
	