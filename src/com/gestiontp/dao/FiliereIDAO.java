package com.gestiontp.dao;

import java.util.List;

import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public interface FiliereIDAO {

	public void ajouterFilier(Filiere f);
	public void modifierFilier(Filiere f);
	public void supprimerFilier(Filiere f);
	public List<Filiere> listTousFilier();
	public Filiere getFilById(int idF);
	public List<Filiere> getTpsByProf(Professeur p);
	
}
