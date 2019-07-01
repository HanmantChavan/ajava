package dao;

import pojos.User;
import static utils.HibernateUtils.*;
import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User u) {
		// get session from SF
		Session hs=getSf().openSession();
		//begin tx
		Transaction tx=hs.beginTransaction();
		try {
			//CRUD for user reg
			hs.save(u);
			//commit tx
			tx.commit();
		}catch (HibernateException e) {
			//rollback tx 
			if(tx != null)
				tx.rollback();
			//re throw exception to caller
			throw e;
		} finally {
			//close hib session
			if(hs != null)
				hs.close();
		}
		
		return "User registed with ID "+u.getUserId();
	}

}
