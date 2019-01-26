
package org.ec2.cisco.services;

import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.ec2.cisco.dao.crudrepository.InstancesCrudRepository;
import org.ec2.cisco.model.Instances;
import org.ec2.cisco.dao.customrepository.*;


@Service
public class InstancesServiceImpl implements InstancesService{

	@Autowired
	private InstancesCrudRepository doa;
	
	@Autowired
	private InstancesCustomRepository customDoa;

	
	public Iterable<Instances> listAllInstances() {
		return doa.findAll();
	}

	public Instances getInstanceById(Long id) {
		return doa.findOne(id);
	}

	public Instances saveInstance(Instances instance) {
		return doa.save(instance);
	}

	public List<Instances> listInstancessForMenu() {
		List instances = customDoa.retrieveInstancessForMenus();
		Collections.sort(instances);
		return instances;

	}
	
}
