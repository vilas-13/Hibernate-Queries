package com.jsp.hibernate.queries.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.jsp.hibernate.queries.enitity.Actor;

public class App_SQL {
	public static void main(String[] args) {
		Configuration cfg= new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Fetch operation
//		NativeQuery<Actor> nativeQuery= session.createNativeQuery("SELECT * from actor WHERE actorId=?1",Actor.class);
//		nativeQuery.setParameter(1, 101);
//		List<Actor> actors= nativeQuery.list();
//		for(Actor actor: actors) {
//			System.out.println(actor);
//		}
		
		//Update operation
//		NativeQuery<Actor> nativeQuery= session.createNativeQuery("UPDATE actor SET actorAge=?1 WHERE actorId=?2",Actor.class);
//		nativeQuery.setParameter(1, 41);
//		nativeQuery.setParameter(2, 101);
//		int rowsUpdated =nativeQuery.executeUpdate();
//		System.out.println(rowsUpdated+" data updated!!");
		
//		Delete operation
		NativeQuery<Actor> nativeQuery= session.createNativeQuery("DELETE FROM actor WHERE actorName=?1",Actor.class);
		nativeQuery.setParameter(1, "Tata");
		int rowsUpdated =nativeQuery.executeUpdate();
		System.out.println(rowsUpdated+" data deleted!!");
		tran.commit();
		session.close();
		sf.close();
	}
}
