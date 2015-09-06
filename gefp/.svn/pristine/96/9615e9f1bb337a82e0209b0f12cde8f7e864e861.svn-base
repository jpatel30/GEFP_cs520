package gefp.model.dao;

import gefp.model.Checkpoint;





import java.util.List;
import java.util.Set;

import gefp.model.User;

public interface UserDao {

	boolean getUserByName(String username);
	Set<Checkpoint> getcheckpoint(String username);
	int gettotalcheckpoint();
	List<User> getUserlist();
	User getuser(long id);
	User saveUser(User user);
	List<User> searchUsersByPrefix( String term );
	User getuser(String username);
}