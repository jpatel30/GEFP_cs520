package gefp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gefp.model.Runway;
import gefp.model.Stage;
import gefp.model.dao.StageDao;
@Repository
public class StageDaoImpl implements StageDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Stage addstage(Stage stage) {
		 stage= entityManager.merge(stage);
		return stage;
	}

	@Override
	public Stage getstage(String stage) {
		return entityManager.createQuery("from Stage where name=:name order by id", Stage.class).setParameter("name",stage).getResultList().get(0);
		
	}

	@Override
	public Stage getstagebyId(Long id) {
		return entityManager.find(Stage.class, id);
	}

	@Override
	public List<Stage> getstage() {
		
		return entityManager.createQuery("from Stage order by id", Stage.class).getResultList();
	}

	@Override
	@Transactional
	public Stage saveStage(Stage stage) {
		
		return entityManager.merge(stage);
	}

}
