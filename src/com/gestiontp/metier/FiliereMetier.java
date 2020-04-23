package com.gestiontp.metier;

import java.util.List;

import com.gestiontp.dao.FiliereDAO;
import com.gestiontp.dao.FiliereIDAO;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;

public class FiliereMetier implements FiliereIMetier{

	private FiliereIDAO filierDao=new FiliereDAO();
	@Override
	public void ajouterFilier(Filiere f) {
		// TODO Auto-generated method stub
		filierDao.ajouterFilier(f);
	}

	@Override
	public void supprimeFilier(Filiere f) {
		// TODO Auto-generated method stub
		filierDao.supprimerFilier(f);
	}

	@Override
	public void modifierFilier(Filiere f) {
		// TODO Auto-generated method stub
		filierDao.modifierFilier(f);
	}

	@Override
	public List<Filiere> listerTous() {
		// TODO Auto-generated method stub
		return filierDao.listTousFilier();
	}

	@Override
	public Filiere getFiliereById(int idF) {
		// TODO Auto-generated method stub
		return filierDao.getFilById(idF);
	}

	@Override
	public List<Filiere> getTpsByProf(Professeur p) {
		
		return filierDao.getTpsByProf(p);
	}

}
