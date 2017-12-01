package com.BackEnd.DAO;

//import javax.persistence.Query;
import javax.transaction.Transactional;


import org.hibernate.Session;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.BackEnd.Model.UserDetail;

@Repository

public class UserDAOImpl  implements UserDAO{
    
	@Autowired
	public SessionFactory sessionfactory;
	
	public UserDAOImpl(SessionFactory sessionfactory) {
	 this.sessionfactory=sessionfactory;
	}

	/* (non-Javadoc)
	 * @see com.SocialNetworkBackEnd.Dao.UserDao#addUser(com.SocialNetworkBackEnd.Model.UserDetail)
	 */
	@Transactional
//	@Override
	public boolean addUser(UserDetail user) {
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin();
			session.save(user);
			transaction.commit();
			session.close();
			/*System.out.println("1");
		    System.out.println(sessionfactory);

			sessionfactory.getCurrentSession().save(user);*/
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
   
	//@Override
	public boolean updateOnlineStatus(String status, UserDetail user) {
			return false;
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateOnlineStatus(String Status, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDetail getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetail getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
