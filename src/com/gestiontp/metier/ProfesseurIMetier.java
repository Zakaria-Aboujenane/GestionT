package com.gestiontp.metier;

import java.util.List;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public interface ProfesseurIMetier {
	public void ajouterProfesseur(Professeur p);
	public void supprimeProfesseur(Professeur p);
	public void modifierProfesseur(Professeur p);
	public List<Professeur> listerTous();
	public Professeur getProfesseurByCIN(String CIN);
	public boolean authentifier(String CIN,String mdp);
	public boolean verifierExis(String CIN);
	public List<Tp> getTpsByProf(Professeur p);
}
