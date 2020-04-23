package com.gestiontp.dao;

import java.util.List;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public interface ProfesseurIDAO {
	void ajouterProfesseur(Professeur p);
	void supprimeProfesseur(Professeur p);
	void modifierProfesseur(Professeur p);
	List<Professeur> listerTous();
	List<Professeur> listerParFiliere(int idFil);
	Professeur getProfesseurByCIN(String CIN);
	boolean authentification(String CIN,String motDePasse);
	public List<Tp> getTpsByProf(Professeur p);
}
