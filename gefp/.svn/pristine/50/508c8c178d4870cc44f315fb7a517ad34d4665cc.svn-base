package gefp.model.dao;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;


@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	UserDao userDao;

	
	@Test
	public void getUserByName(){
		assert userDao.getUserByName("jdoe1");
		assert userDao.getUserByName("jdoe2");
	}
	@Test
	public void getcheckpoint()
	{
		assert userDao.getcheckpoint("jdoe1").size()==1;
		assert userDao.getcheckpoint("jdoe2").size()==userDao.gettotalcheckpoint();
	}
}