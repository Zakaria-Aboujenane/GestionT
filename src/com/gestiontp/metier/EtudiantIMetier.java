package com.gestiontp.metier;

import java.util.List;

import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;

public interface EtudiantIMetier {
	public void ajouterEtud(Etudiant e);
	public void supprimeEtudiant(Etudiant e);
	public void modifierEtudiant(Etudiant e);
	public List<Etudiant> listerTous();
	public Etudiant getEtudiantByCNE(String CNE);
	public boolean authentifier(String CNE,String mdp);
	public List<Tp> getEtudiantTp(Etudiant e);
}
