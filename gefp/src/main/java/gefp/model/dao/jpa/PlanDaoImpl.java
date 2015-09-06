package gefp.model.dao.jpa;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gefp.model.Cell;
import gefp.model.Plan;
import gefp.model.dao.PlanDao;

@Repository
public class PlanDaoImpl implements PlanDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Plan> getPlan() {
		return entityManager.createQuery("from Plan ", Plan.class)
				.getResultList();
	}

	@Override
	public Plan getPlanDetail(long id) {
		return entityManager.find(Plan.class, id);

	}

	@Override
	@Transactional
	public Plan addplan(Plan plan) {
		 plan= entityManager.merge(plan);
		 long time = System.currentTimeMillis();
		 java.sql.Date date = new java.sql.Date(time);
		 plan.setPublishedDate(date);
		 return plan;
	}

	@Override
	@Transactional
	public Plan saveplan(Plan plan) {
		return entityManager.merge(plan);
	}

/*	@Override
	public Plan getPlanById(long planid) {
		
		return entityManager.find(Plan.class, planid);
	}*/

	@Override
	@Transactional
	public Cell saveCell(Cell cell) {
		
		return entityManager.merge(cell);
	}

	

}
