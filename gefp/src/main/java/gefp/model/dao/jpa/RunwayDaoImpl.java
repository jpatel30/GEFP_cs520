package gefp.model.dao.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gefp.model.Runway;
import gefp.model.dao.RunwayDao;
@Repository
public class RunwayDaoImpl implements RunwayDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Runway addrunway(Runway runway) {
		 runway= entityManager.merge(runway);
		return runway;
	}

	@Override
	public Runway getrunway(String runway) {
		System.out.println("+++++");
		return entityManager.createQuery("from Runway where name=:name order by id",Runway.class).setParameter("name",runway).getResultList().get(0);
	}

	@Override
	public Runway getrunwaybyId(Long id) {
		
		return entityManager.find(Runway.class , id);
	}

	@Override
	public List<Runway> getrunway() {
		
		return entityManager.createQuery("from Runway order by id", Runway.class).getResultList();
	}

	@Override
	@Transactional
	public Runway saveRunway(Runway runway) {
		
		return entityManager.merge(runway);
	}

}
