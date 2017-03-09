package org.dao.imp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Test;
import org.util.HibernateSessionFactory;

public class TestDaoImp {
	public void addTest() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			Test t = new Test();
			t.setName("dsf");
			t.setContent("");

			session.save(t);
			ts.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
