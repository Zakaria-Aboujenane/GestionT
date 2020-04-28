package com.gestiontp.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.gestiontp.dao.TpIDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

import utils.HibernateUtil;

public class TpDAO implements TpIDAO {

	private static Session session = HibernateUtil.getHibernateSession();

	@Override
	public String ajouterTp(Tp tp) {

		// TODO Auto-generated method stub
		session.beginTransaction();
		int s =  (int) session.save(tp);
		session.getTransaction().commit();
		return s+"";

	}

	@Override
	public void supprimeTp(Tp tp) {

		// TODO Auto-generated method stub
		session.beginTransaction();
		session.delete(tp);
		session.getTransaction().commit();
	}

	@Override
	public void modifierTp(Tp tp) {

		// TODO Auto-generated method stub
		session.beginTransaction();
		session.update(tp);
		session.getTransaction().commit();

	}

	@Override
	public List<Tp> listerTousTp() {

		// TODO Auto-generated method stub
		session.beginTransaction();
		List<Tp> tps = session.createQuery("select o from Tp o").list();
		session.getTransaction().commit();

		return tps;
	}

	@Override
	public List<Tp> listerTpParFiliere(int idFil) {

		session.beginTransaction();
		// TODO Auto-generated method stub
		String hql = "from Tp tp where tp.idFil=" + idFil + "";
		List<Tp> tps = session.createQuery(hql).list();
		session.getTransaction().commit();

		return tps;
	}

	@Override
	public Tp getTpByidTp(int idTp) {
		if(!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		// TODO Auto-generated method stub
		Tp tp = session.get(Tp.class, idTp);
		session.getTransaction().commit();

		return tp;
	}

	@Override
	public List<Tp> rechercherParProf(String search) {
		if (session.getTransaction().isActive()) {
			Query qry = session.createQuery("From Tp as t where t.getProfesseur().getNom()  like 'Mehdi' ");
			List<Tp> tps = qry.list();
			session.getTransaction().commit();
			return tps;
		} else {
			session.beginTransaction();
			System.out.println("val :" + search);
			String sql = "SELECT t.* FROM tp t " + "INNER JOIN professeur p ON t.CIN=p.CIN Where p.nom Like ? ;";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1, "%" + search + "%");
			query.addEntity(Tp.class);
			session.getTransaction().commit();
			return query.list();
		}
	}

	@Override
	public List<Tp> rechercherParTitreOuMatiere(String search) {
		if (session.getTransaction().isActive()) {
			Query qry = session.createQuery("From Tp as t where t.getProfesseur().getNom()  like 'Mehdi' ");
			List<Tp> tps = qry.list();
			session.getTransaction().commit();
			return tps;
		} else {
			session.beginTransaction();
			System.out.println("val :" + search);
			String sql = "SELECT t.* FROM tp t "
					+ "INNER JOIN professeur p ON t.CIN=p.CIN Where t.titre Like ? OR t.matiere Like ? ;";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1, "%" + search + "%");
			query.setString(2, "%" + search + "%");
			query.addEntity(Tp.class);
			session.getTransaction().commit();
			return query.list();
		}

	}

	@Override
	public List<Tp> rechercheGenerale(int idFil, String search) {
		if (session.getTransaction().isActive()) {
			String sql = "SELECT t.* FROM tp t "
					+ "INNER JOIN professeur p ON t.CIN=p.CIN Where (t.titre Like ? OR t.matiere Like ? OR p.nom Like ? OR t.titre = ? OR  p.nom = ? OR t.matiere = ?) AND t.idFil = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1, "%" + search + "%");
			query.setString(2, "%" + search + "%");
			query.setString(3, "%" + search + "%");
			query.setString(4, "%" + search + "%");
			query.setString(5, "%" + search + "%");
			query.setString(6, "%" + search + "%");
			query.setString(7, idFil + "");

			query.addEntity(Tp.class);
			List<Tp> tps = query.list();
			session.getTransaction().commit();
			return tps;
		} else {
			session.beginTransaction();
			System.out.println("val :" + search);
			String sql = "SELECT t.* FROM tp t "
					+ "INNER JOIN professeur p ON t.CIN=p.CIN Where (t.titre Like ? OR t.matiere Like ? OR p.nom Like ? OR t.titre = ? OR  p.nom = ? OR t.matiere = ?) AND t.idFil = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1, "%" + search + "%");
			query.setString(2, "%" + search + "%");
			query.setString(3, "%" + search + "%");
			query.setString(4, "%" + search + "%");
			query.setString(5, "%" + search + "%");
			query.setString(6, "%" + search + "%");
			query.setString(7, idFil + "");
			query.addEntity(Tp.class);
			session.getTransaction().commit();
			return query.list();
		}
	}

	@Override
	public boolean getFaireTp(Tp t, Etudiant e) {
		if (session.getTransaction().isActive()) {
			session.flush();
			session.clear();
			String sql = "SELECT faireTp from voirtp WHERE idTp = ? ANd CNE = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1, t.getIdTp() + "");
			query.setString(2, e.getCNE());
			boolean b = false;
			try {
				b = (boolean) query.getSingleResult();
				session.getTransaction().commit();
				System.out.println("yep");
			} catch (NoResultException nre) {
				System.out.println("no result");
			}
			if (b)
				return true;
			else
				return false;
		} else {
			session.beginTransaction();
			session.flush();
			session.clear();
			String sql = "SELECT faireTp from voirtp WHERE idTp = ? ANd CNE = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1, t.getIdTp() + "");
			query.setString(2, e.getCNE());
			boolean b = false;
			try {
				b = (boolean) query.getSingleResult();
				session.getTransaction().commit();
				System.out.println("yep");
			} catch (NoResultException nre) {
				System.out.println("no result");
			}
			if (b)
				return true;
			else
				return false;
		}

	}

	@Override
	public void toogleFaireTp(Tp t, Etudiant e) {
		if (this.getFaireTp(t, e)) {
			uncheckTp(t, e);
		} else {
			checkTp(t, e);
		}
	}

	public void checkTp(Tp t, Etudiant e) {
		if (session.getTransaction().isActive()) {
			session.flush();
			session.clear();
			String sql = "UPDATE voirtp " + "SET faireTp = 1 " + "WHERE CNE= '"+e.getCNE()+"' AND idTp = "+t.getIdTp()+" ";
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			query.executeUpdate();
			session.getTransaction().commit();
		} else {
			session.beginTransaction();
			session.flush();
			session.clear();
			String sql = "UPDATE voirtp " + "SET faireTp = 1 " + "WHERE CNE= '"+e.getCNE()+"' AND idTp = "+t.getIdTp()+" ";
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			session.getTransaction().commit();
		}
	}

	public void uncheckTp(Tp t, Etudiant e) {
		if (session.getTransaction().isActive()) {
			String sql = "UPDATE voirtp " + "SET faireTp = 0 " + "WHERE CNE= '"+e.getCNE()+"' AND idTp = "+t.getIdTp()+" ";
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			query.executeUpdate();
			session.getTransaction().commit();
		} else {
			session.beginTransaction();
			String sql = "UPDATE voirtp " + "SET faireTp = 0 " + "WHERE CNE= '"+e.getCNE()+"' AND idTp = "+t.getIdTp()+" ";
			SQLQuery query = session.createSQLQuery(sql);
			query.executeUpdate();
			query.executeUpdate();
			session.getTransaction().commit();
		}
	}

	@Override
	public List<Tp> ListerTpParProf(Professeur p) {
		List<Tp> tps;
		if (session.getTransaction().isActive()) {
			session.flush();
			session.clear();
			String sql = "SELECT * from tp WHERE CIN = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1,p.getCIN());
			query.addEntity(Tp.class);
			tps = query.list();
			session.getTransaction().commit();
			return tps;
		} else {
			session.beginTransaction();
			session.flush();
			session.clear();
			String sql = "SELECT * from tp WHERE CIN = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1,p.getCIN());
			query.addEntity(Tp.class);
			tps = query.list();
			session.getTransaction().commit();
			return tps;
		}
	}

	@Override
	public List<Tp> ListerTpParPEtFil(Professeur p, Filiere f) {
		List<Tp> tps;
		if (session.getTransaction().isActive()) {
			session.flush();
			session.clear();
			String sql = "SELECT * from tp WHERE CIN = ? AND idFil = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1,p.getCIN());
			query.setInteger(2,f.getIdFil());
			query.addEntity(Tp.class);
			tps = query.list();
			session.getTransaction().commit();
			return tps;
		} else {
			session.beginTransaction();
			session.flush();
			session.clear();
			String sql = "SELECT * from tp WHERE CIN = ? AND idFil = ? ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(1,p.getCIN());
			query.setInteger(2,f.getIdFil());
			query.addEntity(Tp.class);
			tps = query.list();
			session.getTransaction().commit();
			return tps;
		}
	}
}
