package first.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RepositoryService {
	
	private Session getSession() {
		SessionFactory sf = new Configuration().configure("hibernate.xml").buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	
	public Map<String, String> getValue(String name) {
		MoBasic basic = new MoBasic();
		basic.setEmpName(name);
		Session session = getSession();
		persistData(session, basic);
		Query query = session.getNamedQuery(MoBasic.GET_EMPLOYEE_LIST);
		List<MoBasic> employeeList = query.getResultList();
		Map<String, String> map = new HashMap<String, String>();
		for(MoBasic emp : employeeList) {
			map.put("id", emp.getId());
			map.put("name", emp.getEmpName());
		}
		return map;
	}
	
	private void persistData(Session session, Object object) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(object);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Transaction Rolled Back due to :" + e);
		}
	}
	
}
