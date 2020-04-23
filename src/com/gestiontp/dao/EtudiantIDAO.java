package com.gestiontp.dao;

import java.util.List;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;

public interface EtudiantIDAO {
		//methodes etudiant m3a bd 
	void ajouterEtud(Etudiant e);
	void supprimeEtudiant(Etudiant e);
	void modifierEtudiant(Etudiant e);
	List<Etudiant> listerTous();
	List<Etudiant> listerParFiliere(int idFil);
	Etudiant getEtudiantByCNE(String CNE);
	boolean authentification(String CNE,String motDePasse);
	List<Tp> getEtudianttp(Etudiant e);
	public List<Tp> rechercherPar(String search);
}
