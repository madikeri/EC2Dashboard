package org.ec2.cisco;

import org.ec2.cisco.Instances;


public interface InstancesService {
    Iterable<Instances> listAllInstances();

    Instances getInstanceById(Long id);

    Instances saveInstance(Instances Instance);
        
    Iterable<Instances> search(InstancesSearchCriteria instanceSearchCriteria);
	


}
