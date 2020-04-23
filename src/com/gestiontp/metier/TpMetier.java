package com.gestiontp.metier;

import java.util.List;

import com.gestiontp.dao.TpDAO;
import com.gestiontp.dao.TpIDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public class TpMetier implements TpIMetier {

	private TpIDAO tpDao=new TpDAO();
	@Override
	public void ajouterTp(Tp tp) {
		// TODO Auto-generated method stub
		tpDao.ajouterTp(tp);
	}

	@Override
	public void supprimeTp(Tp tp) {
		// TODO Auto-generated method stub
		tpDao.supprimeTp(tp);
	}

	@Override
	public void modifierTp(Tp tp) {
		// TODO Auto-generated method stub
		tpDao.modifierTp(tp);
	}

	@Override
	public List<Tp> listerTous() {
		// TODO Auto-generated method stub
		return tpDao.listerTousTp();
	}

	@Override
	public Tp getTpByidTp(int idTp) {
		// TODO Auto-generated method stub
		return tpDao.getTpByidTp(idTp);
	}

	@Override
	public List<Tp> rechercherParProf(String search) {
		
		return tpDao.rechercherParProf(search);
	}

	@Override
	public List<Tp> rechercherParTitreOuMatiere(String search) {
		
		return tpDao.rechercherParTitreOuMatiere(search);
	}

	@Override
	public List<Tp> rechercheGenerale(int idFil,String search) {
		
		return tpDao.rechercheGenerale(idFil,search);
	}

	@Override
	public boolean getFaireTp(Tp t, Etudiant e) {
		return tpDao.getFaireTp(t, e);
	}

	@Override
	public void toogleFaireTp(Tp t, Etudiant e) {
		tpDao.toogleFaireTp(t, e);
	}

	@Override
	public List<Tp> ListerTpParProf(Professeur p) {
		
		return tpDao.ListerTpParProf(p);
	}

	@Override
	public List<Tp> ListerTpParPEtFil(Professeur p, Filiere f) {
		return tpDao.ListerTpParPEtFil(p, f);
	}

}
