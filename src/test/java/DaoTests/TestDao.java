package DaoTests;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dta.services.dao.IUserDao;
import com.dta.services.model.Role;
import com.dta.services.model.User;


public class TestDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	
	@Test
	public void Dao() {
		IUserDao userDao = (IUserDao) context.getBean("userDao");

		userDao.create(new User("caca", "pass", 0, "caca@prout.com", Role.ADMINISTRATOR));
		
	}

}
