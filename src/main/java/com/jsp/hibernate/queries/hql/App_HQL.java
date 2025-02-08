package com.jsp.hibernate.queries.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.queries.enitity.Actor;

public class App_HQL {
	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
//		Feching
//		Query<Actor> query= session.createQuery("FROM Actor a");
//		List<Actor> actors = query.list();
//		for(Actor actor: actors) {
//			System.out.println(actor);
//		}
		
//		Update Operation
//		Query<Actor> query= session.createQuery("UPDATE Actor a SET a.actorAge=?1 WHERE a.actorId=:id");
//		query.setParameter(1, 45);
//		query.setParameter("id", 101);
//		int rowsUpdated = query.executeUpdate();
//		System.out.println(rowsUpdated+" data updated");
		
		Query<Actor> query= session.createQuery("DELETE Actor a WHERE a.actorId=106");
		
		int rowsDeleted = query.executeUpdate();
		System.out.println(rowsDeleted+" data deleted");
		tran.commit();
		session.close();
		sf.close();
	}
}
