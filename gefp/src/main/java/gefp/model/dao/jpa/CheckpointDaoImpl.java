package gefp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gefp.model.Checkpoint;
import gefp.model.dao.CheckpointDao;
@Repository
public class CheckpointDaoImpl implements CheckpointDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Checkpoint addcheckpoint(Checkpoint checkpoint) {
		checkpoint =entityManager.merge(checkpoint);
		return checkpoint;
	}

	@Override
	public String getnamebyId(long cid) {
		
		return entityManager.find(Checkpoint.class, cid).getDescription();
	}

	@Override
	public Checkpoint getcheckpoint(long id) {
		
		return entityManager.find(Checkpoint.class, id);
	}

	@Override
	@Transactional
	public Checkpoint savecheckpoint(Checkpoint checkpoint) {
		
		return entityManager.merge(checkpoint);
	}

}
