
package org.ec2.cisco;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.ec2.cisco.Instances;
import org.ec2.cisco.InstancesSearchCriteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
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

	public Iterable<Instances> searchAll(InstancesSearchCriteria searchObj) {
		Conjunction and = Restrictions.conjunction();

		boolean criteriaDefined = false;
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(Instances.class);
		
		if(searchObj.getName() != null && searchObj.getName().length() > 0){
		
                and.add( Restrictions.like("name", searchObj.getName(), MatchMode.ANYWHERE) );
                criteriaDefined = true;
		}
		
		if(searchObj.getType() != null && searchObj.getType().length() > 0){
			
            and.add( Restrictions.like("type", searchObj.getType(), MatchMode.ANYWHERE) );
            criteriaDefined = true;
		}
		criteria.add(and);
		System.out.println("criteria here:" + criteria.toString());
		
		System.out.println("criteria output size before :" + criteria.list().size());
		
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		System.out.println("criteria output size after transform:" + criteria.list().size());

		if (criteriaDefined) {
			return criteria.list();
		} else {
			return null;
		}
	}
	
	
}
	