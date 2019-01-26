package org.ec2.cisco.dao.customrepository;

import java.util.List;


import org.ec2.cisco.model.Instances;

public interface InstancesCustomRepository {
	
	List<Instances> retrieveInstancessForMenus();

}
