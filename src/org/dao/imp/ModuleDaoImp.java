package org.dao.imp;

import java.util.List;

import org.dao.ModuleDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Module;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class ModuleDaoImp implements ModuleDao {

	@Override
	public long addModule(Module m) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Module module = new Module();
			module.setName(m.getName());
			module.setDescription(m.getDescription());

			long id = (Long) session.save(module);
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
	public List getModuleList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("from Module order by name");
			List<Module> list = query.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Module getModule(String name) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("from Module where name=?");
			query.setParameter(0, name);
			query.setMaxResults(1);
			Module m = (Module) query.uniqueResult();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteModule(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Module m = (Module) session.load(Module.class, id);
			session.delete(m);
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
	public boolean updateModule(Module m) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.update(m);
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
