package com.gestiontp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

import utils.HibernateUtil;

public class FiliereDAO implements FiliereIDAO {

	private Session session ;
	public FiliereDAO() {
		session = HibernateUtil.getHibernateSession();
	}
	
	@Override
	public void ajouterFilier(Filiere f) {
		
		// TODO Auto-generated method stub
		session.beginTransaction();
		String s = (String) session.save(f);
		session.getTransaction().commit();
	
	}
	@Override
	public void modifierFilier(Filiere f) {
		
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.update(f);
		session.getTransaction().commit();
	
	}
	@Override
	public void supprimerFilier(Filiere f) {

		// TODO Auto-generated method stub
		session.beginTransaction();
		session.delete(f);
		session.getTransaction().commit();
	
	}
	@Override
	public List<Filiere> listTousFilier() {
		// TODO Auto-generated method stub
			session.beginTransaction();
			session.flush();
			session.clear();
		 List<Filiere> fs = session.createQuery("select o from Filiere o").list();
		 
		 session.getTransaction().commit();
		return fs;
	}
	@Override
	public Filiere getFilById(int idF) {
		
		// TODO Auto-generated method stub
	
		
		Filiere f= session.get(Filiere.class,idF);
		

		return f;
	}

	@Override
	public List<Filiere> getTpsByProf(Professeur p) {
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		return em.createQuery(
			    "select f " +
			    "from Filiere f " +
			    "join fetch f.professeurs p " +
			    "where p.CIN = :CIN",Filiere.class)
			.setParameter("CIN", p.getCIN())
			.getResultList();
	}
	

}
