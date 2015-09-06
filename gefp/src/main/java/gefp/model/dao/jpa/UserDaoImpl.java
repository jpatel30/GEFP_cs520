package gefp.model.dao.jpa;
import gefp.model.Cell;
import gefp.model.Checkpoint;
import gefp.model.User;
import gefp.model.dao.UserDao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean getUserByName(String username) {
		List<User> user=entityManager.createQuery("from User",User.class).getResultList();
		for(int i=0 ;i<user.size();i++)
		{
			if(user.get(i).getUsername().equalsIgnoreCase(username))
			{
				return true;
			}
		}
		return false;
		
		
	}

	@Override
	public Set<Checkpoint> getcheckpoint(String username) {
	User user=entityManager.createQuery("from User where userName= :username",User.class).setParameter("username", username).getResultList().get(0);
	long id =user.getId();
	System.out.println(id);
	return entityManager.find(User.class, id).getCheckpoints();
		 
	}

	@Override
	public int gettotalcheckpoint() {
		User user=entityManager.createQuery("from User ",User.class).getResultList().get(0);
		long id=user.getPlan().getId();
		int size =entityManager.find(Cell.class,id).getCheckpoints().size();
		System.out.println(size);
		return size;
	}

	@Override
	public List<User>  getUserlist() {
		
		List<User> users=entityManager.createQuery("from User",User.class).getResultList();
		return users;
		
		
	}

	@Override
	public User getuser(long id) {
		
		return entityManager.find(User.class, id) ;
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		user=entityManager.merge(user);
		return user;
	}

	@Override
	public List<User> searchUsersByPrefix(String term) {
		term = term.toLowerCase();
        String query = "from User where CIN  like :term or lower(username)  like :term or lower(email) like :term order by username  asc";
        return entityManager.createQuery( query, User.class ).setParameter("term", "%"+term+"%").getResultList();
	}

	@Override
	public User getuser(String username) {
		return entityManager.createQuery("from User where username=:username", User.class).setParameter("username", username).getSingleResult();
	}

	 



	

}