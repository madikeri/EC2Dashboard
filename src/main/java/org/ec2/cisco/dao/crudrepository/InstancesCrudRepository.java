
package org.ec2.cisco.dao.crudrepository;


import org.springframework.data.repository.CrudRepository;

import org.ec2.cisco.model.Instances;


public interface InstancesCrudRepository extends CrudRepository<Instances, Long>{

	Instances findOne(String id);
	
}

