package com.jsp.hibernate.queries.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jsp.hibernate.queries.enitity.Actor;

public class App_Criteria {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Actor.class);
		//where condition
//		criteria.add(Restrictions.eqOrIsNull("actorId", 101));
//		criteria.add(Restrictions.gt("actorId", 101));
//		criteria.add(Restrictions.lt("actorId", 103));
//		criteria.add(Restrictions.like("actorId", 101));
//		criteria.add(Restrictions.between("actorId", 102,104));
		//select
		criteria.setProjection(Projections.property("nationality"));
		List<String>actors = criteria.list();
		for(String a: actors) {
			System.out.println(a);
		}
		
		tran.commit();
		session.close();
		sf.close();
	}
}
