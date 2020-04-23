package com.gestiontp.metier;

import java.util.List;

import org.hibernate.SessionFactory;

import com.gestiontp.dao.EtudiantDAO;
import com.gestiontp.dao.EtudiantIDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.*;

public class EtudiantMetier implements EtudiantIMetier {
	private EtudiantIDAO etudiantDAO = new EtudiantDAO() ;
	@Override
	public void ajouterEtud(Etudiant e) {
		etudiantDAO.ajouterEtud(e);
	}

	@Override
	public void supprimeEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		etudiantDAO.supprimeEtudiant(e);
      
	}

	@Override
	public void modifierEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		etudiantDAO.modifierEtudiant(e);

	}

	@Override
	public List<Etudiant> listerTous() {
		// TODO Auto-generated method stub
		return etudiantDAO.listerTous();
	}

	@Override
	public Etudiant getEtudiantByCNE(String CNE) {
		
		return etudiantDAO.getEtudiantByCNE(CNE);
	}

	@Override
	public boolean authentifier(String CNE, String mdp) {
		Etudiant e = this.getEtudiantByCNE(CNE);
		if(e!=null)
			if(mdp.equalsIgnoreCase(e.getMotDePasse()))
				return true;
		return false;
	}

	@Override
	public List<Tp> getEtudiantTp(Etudiant e) {
		return etudiantDAO.getEtudianttp(e);
	}
}
