
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

	public List<Instances> retrieveInstancessForMenus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	