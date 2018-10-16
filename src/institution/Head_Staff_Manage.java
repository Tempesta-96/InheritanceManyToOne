package institution;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Head_Staff_Manage {

	public void list() {
		SessionFactory sf = null;
		Session session = null;
		Centre_Head ch = null;
		sf = util.HibernateUtil.getSessionFactory();
		session = sf.openSession();
		List l1 = session.createQuery("from Centre_Head").list();
		for (int i = 0; i < l1.size(); i++) {
			ch = (Centre_Head) l1.get(i);
			System.out.println(ch.getC_name() + " " + ch.getStaff());
		}
		session.close();

	}

	public void insertHead(int code, String name, String centre) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();

			Centre_Head ch = new Centre_Head();
			ch.setC_code(code);
			ch.setC_name(name);
			ch.setCentre_name(centre);
			Integer l = (Integer) session.save(ch);
			tr.commit();
		}

		catch (Exception e) {
			System.out.println(e + "  Error with insert block");
			tr.rollback();
			session.close();
		}
	}

	public void insertStaff(int code, String name, String subject, String centre) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			Staff stf = new Staff();
			stf.setS_code(code);
			stf.setS_name(name);
			stf.setSpecialization(subject);
			stf.setCentre_name(centre);
			session.save(stf);
			tr.commit();
		}

		catch (Exception e) {
			System.out.println(e + "  Error with insert block");
			tr.rollback();
			session.close();
		}
	}

	public void add_to_centre_head(int head, String centre) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			Centre_Head ch = (Centre_Head) session.createQuery("from Centre_Head where c_code=" + head).list().get(0);
			List s1 = session.createQuery("from Staff").list();

			if (s1 != null) {
				Set temp = ch.getStaff();
				for (int i = 0; i < s1.size(); i++) {
					Staff s = (Staff) s1.get(i);
					if (s.getCentre_name().equals(centre)) {
						temp.add(s);
						System.out.println(temp);

					} else
						continue;
				}
				ch.setStaff(temp);
				session.save(ch);
				tr.commit();
			}
		} catch (Exception e) {
			System.out.println(e + "  Error with add block");
			tr.rollback();
			session.close();
		}
	}

	public void deleteCHead(int code) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			Centre_Head ch = (Centre_Head) session.load(Centre_Head.class, new Integer(code));
			session.delete(ch);
			tr.commit();
		} catch (Exception e) {
			System.out.println(e + "  Error with delete block");
			tr.rollback();
			session.close();
		}
	}
}
