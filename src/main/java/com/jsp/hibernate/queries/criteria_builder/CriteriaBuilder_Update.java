package com.jsp.hibernate.queries.criteria_builder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.enitity.Actor;

public class CriteriaBuilder_Update {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Builder
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaUpdate<Actor> cu = cb.createCriteriaUpdate(Actor.class);
		Root<Actor>root = cu.from(Actor.class);
		cu.set(root.get("actorAge"), 45);
		cu.where(cb.equal(root.get("actorId"), 101));
		
		Query<Actor> query= session.createQuery(cu);
		int rowsUpdated=query.executeUpdate();
		System.out.println(rowsUpdated+" data updated!!");
		
		tran.commit();
		session.close();
		sf.close();
	}
}
