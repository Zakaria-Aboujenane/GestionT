package com.gestiontp.metier;

import java.util.List;

import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;

public interface FiliereIMetier {
	public void ajouterFilier(Filiere f);
	public void supprimeFilier(Filiere f);
	public void modifierFilier(Filiere f);
	public List<Filiere> listerTous();
	public Filiere getFiliereById(int idF);
	public List<Filiere> getTpsByProf(Professeur p);
}
