package com.gestiontp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;

import utils.HibernateUtil;

public class EtudiantDAO implements EtudiantIDAO {
	
	private static Session session = HibernateUtil.getHibernateSession();;
	private Etudiant etudiant=null;
	@Override
	public void ajouterEtud(Etudiant e) {
		
		session.beginTransaction();
		String s = (String) session.save(e);// returns id primaire
		// requests in Hibernate -- CRUD
		session.getTransaction().commit();
		
	}

	@Override
	public void supprimeEtudiant(Etudiant e) {
		
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.delete(e);
		session.getTransaction().commit();
		
	}

	@Override
	public void modifierEtudiant(Etudiant e) {
		
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
	
	}

	@Override
	public List<Etudiant> listerTous() {
		
		// TODO Auto-generated method stub
		
		List<Etudiant> es= session.createCriteria(Etudiant.class).list();
		
		
		return es;
	}

	@Override
	public Etudiant getEtudiantByCNE(String CNE) {
		try {
			Etudiant e = session.get(Etudiant.class,CNE);
			return e;
		} catch (Exception e) {
			return null;
		}
	
		
	}
	
	@Override
	public List<Etudiant> listerParFiliere(int idFil) {
	
		// TODO Auto-generated method stub
		
		String hql="from Etudiant e where e.idFil="+idFil+"";
		return session.createQuery(hql).list();
	}

	@Override
	public boolean authentification(String CNE, String motDePasse) {
		
		 etudiant= getEtudiantByCNE(CNE);
		 if(etudiant!=null && etudiant.getMotDePasse().equals(motDePasse)) 
			 return true;
		 else
		     return false;
	}
	

	@Override
	public List<Tp> getEtudianttp(Etudiant e) {
		if(session.getTransaction().isActive()) {
			System.out.println("sesison is in transaction");
			session.beginTransaction();
			session.flush();
			session.clear();
			Hibernate.initialize(e.getTps());
			List<Tp> tps = e.getTps();
			session.getTransaction().commit();
			return tps;
		}else {
			System.out.println("nope");
			session.beginTransaction();
			System.out.println("now yes");
			session.flush();
			session.clear();
			
			Hibernate.initialize(e.getTps());
			List<Tp> tps1 = e.getTps();
			session.getTransaction().commit();
			return tps1;
		}
	
		
	}

	@Override
	public List<Tp> rechercherPar(String search) {
		// TODO Auto-generated method stub
		return null;
	}
}
