package org.dao.imp;

import java.util.List;

import org.dao.InterfaceDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Interface;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class InterfaceDaoImp implements InterfaceDao {

	@Override
	public long addInterface(Interface r) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Interface i = new Interface();
			i.setDescription(r.getDescription());
			i.setInput(r.getInput());
			i.setMId(r.getMId());
			i.setName(r.getName());
			i.setOutput(r.getOutput());
			i.setTime(r.getTime());

			long id = (Long) session.save(i);
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
	public List getInterfaceList(long mId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from Interface where MId=?");
			query.setParameter(0, mId);
			List<Interface> list = query.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Interface getInterface(String name) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from Interface where name=?");
			query.setParameter(0, name);
			query.setMaxResults(1);
			Interface i = (Interface) query.uniqueResult();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateInterface(Interface i) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.update(i);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteInterfaceById(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Interface in = (Interface) session.load(Interface.class, id);
			session.delete(in);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteInterfaceByMId(long MId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			SQLQuery sqlQuery = session.createSQLQuery("delete from interface where m_id=?");
			sqlQuery.setParameter(0, MId);
			sqlQuery.executeUpdate();
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
