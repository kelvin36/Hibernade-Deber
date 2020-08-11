package com.ejerciciopoo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ejerciciopoo.entidades.Persona;
import com.ejerciciopoo.entidades.Ranking;
import com.ejerciciopoo.entidades.Skill;



public class Main {
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

	public static void main(String[] args) {
		Persona persona= new Persona("Kelvin Matamoros ");
		ingresarPersona(persona);
		Persona persona1= new Persona("Andrea Matamoros ");
		ingresarPersona(persona1);
		
		Ranking ranking= new Ranking(1);
		ingresarRanking(ranking);
		Ranking ranking1= new Ranking(2);
		ingresarRanking(ranking1);
		
		Skill skill= new Skill("PROGRAMACION 2 ");
		ingresarSkill(skill);
		Skill skil= new Skill("SOCIALES");
		ingresarSkill(skil);

		
	}
	static void ingresarPersona(Persona persona) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(persona);
		session.getTransaction().commit();
		session.close();
	}
	
	static void ingresarSkill(Skill skill) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(skill);
		session.getTransaction().commit();
		session.close();

	}
	
	static void ingresarRanking(Ranking ranking) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ranking);
		session.getTransaction().commit();
		session.close();

	}

	


}
