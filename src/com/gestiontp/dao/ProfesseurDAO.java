package com.gestiontp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

import utils.HibernateUtil;

public class ProfesseurDAO implements ProfesseurIDAO{

	private static Session session = HibernateUtil.getHibernateSession();
	private Professeur prof=null;
	@Override
	public void ajouterProfesseur(Professeur p) {
		
		
		// TODO Auto-generated method stub
		session.beginTransaction();
		String s = (String) session.save(p);
		session.getTransaction().commit();

	}
	@Override
	public void supprimeProfesseur(Professeur p) {

		// TODO Auto-generated method stub
		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
	
	}
	@Override
	public void modifierProfesseur(Professeur p) {
		
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
	}
	@Override
	public List<Professeur> listerTous() {
		
		
		// TODO Auto-generated method stub
		List<Professeur> fs= session.createCriteria(Professeur.class).list();
		
		return fs;
	}
	@Override
	public List<Professeur> listerParFiliere(int idFil) {
	
		// TODO Auto-generated method stub
		
		String hql="from Professeur p where p.idFil="+idFil+"";
		List<Professeur> fs = session.createQuery(hql).list();
		

		return fs;
	}
	@Override
	public Professeur getProfesseurByCIN(String CIN) {
		// TODO Auto-generated method stub
		
		
		 Professeur p= session.get(Professeur.class,CIN);
		 
		
		 return p;
	}
	@Override
	public boolean authentification(String CIN, String motDePasse) {
		// TODO Auto-generated method stub
		 prof= getProfesseurByCIN(CIN);
		 if(prof!=null && prof.getMotDePasse().equals(motDePasse)) 
			 return true;
		 else
		     return false;
	}
	@Override
	public List<Tp> getTpsByProf(Professeur p) {
		EntityManager em = session.getEntityManagerFactory().createEntityManager();
		return em.createQuery(
			    "select t " +
			    "from Tp t " +
			    "join fetch t.filiere " +
			    "where t.CIN = :CIN",Tp.class)
			.setParameter("CIN", p.getCIN())
			.getResultList();
	}
}
