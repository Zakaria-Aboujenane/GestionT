package com.gestiontp.metier;

import java.util.List;

import com.gestiontp.dao.ProfesseurDAO;
import com.gestiontp.dao.ProfesseurIDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public class ProfesseurMetier implements ProfesseurIMetier{

	private ProfesseurIDAO profDao = new ProfesseurDAO() ;
	
	@Override
	public void ajouterProfesseur(Professeur p) {
		// TODO Auto-generated method stub
		profDao.ajouterProfesseur(p);
	}

	@Override
	public void supprimeProfesseur(Professeur p) {
		// TODO Auto-generated method stub
		profDao.supprimeProfesseur(p);
	}

	@Override
	public void modifierProfesseur(Professeur p) {
		// TODO Auto-generated method stub
		profDao.modifierProfesseur(p);
	}

	@Override
	public List<Professeur> listerTous() {
		// TODO Auto-generated method stub
		return profDao.listerTous();
	}

	@Override
	public Professeur getProfesseurByCIN(String CIN) {
		// TODO Auto-generated method stub
		return profDao.getProfesseurByCIN(CIN);
	}

	@Override
	public boolean authentifier(String CIN, String mdp) {
		// TODO Auto-generated method stub
		Professeur p = this.getProfesseurByCIN(CIN);
		if(p!=null)
			if(mdp.equalsIgnoreCase(p.getMotDePasse()))
				return true;
		return false;
	}

	@Override
	public boolean verifierExis(String CIN) {
		try {
			if(this.getProfesseurByCIN(CIN)!=null)
				return true;
			else
				return false;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public List<Tp> getTpsByProf(Professeur p) {
		return profDao.getTpsByProf(p);
	}

}
