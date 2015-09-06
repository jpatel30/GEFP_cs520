package gefp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gefp.model.Cell;
import gefp.model.Checkpoint;
import gefp.model.Plan;
import gefp.model.Runway;
import gefp.model.Stage;
import gefp.model.dao.CellDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CellDaoImpl implements CellDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cell> getcells() {
		return entityManager.createQuery("from Cell ", Cell.class)
				.getResultList();
	}

	@Override
	@Transactional
	public Cell savecell(Cell cell) {

		return entityManager.merge(cell);
	}

	@Override
	public List<Cell> getcelldetail(Plan plan, Runway runway, Stage stage) {
		List<Cell> cell=(List<Cell>) entityManager
				.createQuery(
						"from Cell where plan =:plan and stage =:stage and runway =:runway",
						Cell.class).setParameter("plan", plan)
				.setParameter("stage", stage)
				.setParameter("runway", runway).getResultList();
		return cell.size()==0 ? null : cell ;
	}

	@Override
	public Cell getcellbyId(long cid) {
		
		return entityManager.find(Cell.class, cid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cell getcell(Plan plan, Runway runway, Stage stage) {
		
		List<Cell> cell =  entityManager
				.createQuery(
						"from Cell where plan =:plan and stage =:stage and runway =:runway",
						Cell.class).setParameter("plan", plan)
				.setParameter("stage", stage)
				.setParameter("runway", runway).getResultList();
		
		return  cell.size() == 0 ? null : cell.get(0);
		
		}

	

}
