
package org.ec2.cisco.dao.customrepository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.ec2.cisco.controller.*;
import org.ec2.cisco.dao.crudrepository.*;
import org.ec2.cisco.model.Instances;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger;



@Service
@Transactional
public class InstancesCustomRepositoryImpl implements InstancesCustomRepository{

	@PersistenceContext
    private EntityManager em;
	
	private static final Logger log = Logger.getLogger(InstancesCustomRepository.class);

	@Autowired
	InstancesCrudRepository instanceRepo;

	public List<Instances> findAll(Pageable pageable, String searchParam) {
		log.debug("entering customdao findall");
		Session session = (Session) em.getDelegate();
		
		Criteria criteria;
		if (searchParam != null && !searchParam.equals("")) {
			long val = Long.valueOf(searchParam);
			criteria = session.createCriteria(Instances.class)
					.add(Restrictions.disjunction().add(Restrictions.like("instance_id", val)));
		} else {
			criteria = session.createCriteria(Instances.class);
		}
		
		criteria.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
		criteria.setMaxResults(pageable.getPageSize());
		criteria.addOrder(Order.asc("instance_id"));
		// criteria.addOrder(Order.asc("date_closed"));
		List<Instances> instances = criteria.list();
		
		log.debug("returning from customdao findall");
		return instances;
	}
	
	


	


	
}
	