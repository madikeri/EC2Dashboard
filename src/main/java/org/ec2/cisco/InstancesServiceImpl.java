
package org.ec2.cisco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.ec2.cisco.InstancesCrudRepository;
import org.ec2.cisco.Instances;
import org.ec2.cisco.InstancesSearchCriteria;


@Service
public class InstancesServiceImpl implements InstancesService{

	@Autowired
	private InstancesCrudRepository doa;
	
	@Autowired
	private InstancesCustomRepository customDao;

	
	public Iterable<Instances> listAllInstances() {
		System.out.println("inside service list all");
		return doa.findAll();
	}

	public Instances getInstanceById(Long id) {
		return doa.findOne(id);
	}

	public Instances saveInstance(Instances instance) {
		return doa.save(instance);
	}

	public Iterable<Instances> search(InstancesSearchCriteria instanceSearchCriteria) {
		return customDao.searchAll(instanceSearchCriteria);
	}

	
	
}
