package org.ec2.cisco.services;

import java.util.List;
import org.ec2.cisco.model.Instances;
import org.ec2.cisco.model.*;


public interface InstancesService {
    Iterable<Instances> listAllInstances();

    Instances getInstanceById(Long id);

    Instances saveInstance(Instances Instance);
        
    Iterable<Instances> search(InstancesSearchCriteria instanceSearchCriteria);
	


}
