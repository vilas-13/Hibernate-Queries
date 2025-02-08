package com.jsp.hibernate.queries.criteria_builder;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.enitity.Actor;

public class CriteriaBuilder_Fetch {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Builder
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//Query Construction
//		CriteriaQuery<Actor>cq = cb.createQuery(Actor.class);
		//SELECTING DIRECTLY
//		cq.from(Actor.class);
		CriteriaQuery<String>cq = cb.createQuery(String.class);
		//Using reference to use select and where clause
		Root<Actor> root = cq.from(Actor.class);
//		cq.select(root);
//		cq.where(cb.equal(root.get("actorId"), 103));
		cq.select(root.get("nationality"));
		//cq.where(cb.equal(root.get("actorName"), 103));
		//Query Execution
		Query<String> q= session.createQuery(cq);
		List<String>actors = q.list();
		for(String a : actors) {
			System.out.println(a);
		}
		
		tran.commit();
		session.close();
		sf.close();
				
	}

}
