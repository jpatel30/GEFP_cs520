package gefp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gefp.model.Department;
import gefp.model.Plan;
import gefp.model.dao.DepartmentDao;
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Department> getDepartmentName() 
	{
		return entityManager.createQuery("from Department", Department.class).getResultList();
	}

	@Override
	public List<Plan> getPlan(String name) {
		List<Plan> id = null ;
		List<Department> department=entityManager.createQuery("  from Department plans where name=:name", Department.class).setParameter("name", name).getResultList();
		for(int i=0;i<department.size();i++)
		{
			if(department.get(i).getName().equalsIgnoreCase(name))
			{
				id=department.get(i).getPlans();
			}
		}
		return id;
	
	}

	@Override
	public Department getIdByName(String department) {
		Department dept=  entityManager.createQuery("from Department where name=:name", Department.class).setParameter("name", department).getResultList().get(0);
		return dept;
	}

	@Override
	@Transactional
	public Department savedept(Department department) {
		return entityManager.merge(department);
		 
	}

	@Override
	public Department getDepartment(Long department) {
		
		return entityManager.find(Department.class, department);
	}

}
