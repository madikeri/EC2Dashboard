package org.ec2.cisco;

import org.ec2.cisco.Instances;
import org.ec2.cisco.InstancesSearchCriteria;


public interface InstancesCustomRepository {

	Iterable<Instances> searchAll(InstancesSearchCriteria instanceSearchCriteria);


}
