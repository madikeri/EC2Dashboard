package org.ec2.cisco.services;

import java.util.List;
import org.ec2.cisco.model.Instances;

public interface InstancesService {
    Iterable<Instances> listAllInstances();

    Instances getInstanceById(Long id);

    Instances saveInstance(Instances Instance);
        
   


}
