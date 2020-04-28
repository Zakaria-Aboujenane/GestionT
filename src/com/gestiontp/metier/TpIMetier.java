package com.gestiontp.metier;

import java.util.List;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public interface TpIMetier {

	public String ajouterTp(Tp tp);
	public void supprimeTp(Tp tp);
	public void modifierTp(Tp tp);
	public List<Tp> listerTous();
	public List<Tp> ListerTpParProf(Professeur p);
	public List<Tp> ListerTpParPEtFil(Professeur p,Filiere f);
	public Tp getTpByidTp(int idTp);
	public List<Tp> rechercherParProf(String search);
	public List<Tp> rechercherParTitreOuMatiere(String search);
	public List<Tp> rechercheGenerale(int idFil,String search);
	public boolean getFaireTp(Tp t,Etudiant e);
	public void toogleFaireTp(Tp t,Etudiant e);
}
