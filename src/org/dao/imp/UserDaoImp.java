package org.dao.imp;

import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.User;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class UserDaoImp implements UserDao {

	@Override
	public User getUser(String username) {
		try {
			Session session = HibernateSessionFactory.getSession();

			Query query = session.createQuery("from User where username=?");
			query.setParameter(0, username);
			query.setMaxResults(1);
			User u = (User) query.uniqueResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return new User();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public User getUser(String username, String password) {
		try {
			Session session = HibernateSessionFactory.getSession();

			Query query = session
					.createQuery("from User where username=? and password=?");
			query.setParameter(0, username);
			query.setParameter(1, password);
			query.setMaxResults(1);
			User u = (User) query.uniqueResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long addUser(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			User user = new User();
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setAck(u.getAck());
			long id = (Long) session.save(user);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean getAck(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();

			Query query = session.createQuery("from User where id=?");
			query.setParameter(0, u.getId());
			query.setMaxResults(1);
			User user = (User) query.uniqueResult();

			return user.getAck();
		} catch (Exception e) {
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
