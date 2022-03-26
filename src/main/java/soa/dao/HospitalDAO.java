package soa.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.Query;

import soa.model.Doctor;
import soa.model.Hospital;

public class HospitalDAO {

	public ArrayList<Hospital> getAllHospital() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Hospital");
		ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();
		session.close();
		return hospital;
	}

	public Hospital findByID(int id) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Hospital where hospitalId =" + id);
		ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();
		session.close();
		if(hospital.isEmpty())
		{
			return null;
		}
		else
		{
		return hospital.get(0);
		}

	}
	
	public boolean DeleteByID(int id) {
		try {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from Hospital where hospitalId =" + id);
		int result = query.executeUpdate();
		//ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();
		

		tx.commit();
		session.close();
		}
		catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}
		return true;

	}

	public boolean addHospital(Hospital h) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			// tx.begin();

			session.save(h);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;
	}
	
	public boolean updateHospital(Hospital h) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			//tx.begin();

			session.saveOrUpdate(h);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;
		
		}

		return true;
	} 

}
