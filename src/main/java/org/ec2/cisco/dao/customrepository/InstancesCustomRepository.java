package org.ec2.cisco.dao.customrepository;

import java.util.List;


import org.ec2.cisco.model.Instances;
import org.ec2.cisco.model.InstancesSearchCriteria;
import org.springframework.data.domain.Pageable;


public interface InstancesCustomRepository {
	
//	List<Instances> retrieveInstancessForMenus();

//	Instances retrieveInstancebyname(String name);
	
//	List<Instances> findAll(Pageable pageable,String searchParam);

	Iterable<Instances> searchAll(InstancesSearchCriteria instanceSearchCriteria);


}
