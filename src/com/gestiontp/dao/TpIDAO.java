package com.gestiontp.dao;

import java.util.List;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Filiere;
import com.gestiontp.dao.entities.Professeur;
import com.gestiontp.dao.entities.Tp;

public interface TpIDAO {
	String ajouterTp(Tp tp);
	void supprimeTp(Tp tp);
	void modifierTp(Tp tp);
	List<Tp> listerTousTp();
	List<Tp> listerTpParFiliere(int idFil);
	Tp getTpByidTp(int idTp);
	public List<Tp> ListerTpParProf(Professeur p);
	public List<Tp> ListerTpParPEtFil(Professeur p,Filiere f);
	public List<Tp> rechercherParProf(String search);
	public List<Tp> rechercherParTitreOuMatiere(String search);
	public List<Tp> rechercheGenerale(int idFil,String search);
	public boolean getFaireTp(Tp t,Etudiant e);
	public void toogleFaireTp(Tp t,Etudiant e);
}
