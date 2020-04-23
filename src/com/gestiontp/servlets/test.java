package com.gestiontp.servlets;

import com.gestiontp.dao.TpDAO;
import com.gestiontp.dao.entities.Etudiant;
import com.gestiontp.dao.entities.Tp;
import com.gestiontp.metier.EtudiantMetier;;

public class test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TpDAO t = new TpDAO();
		Tp tp = new Tp();
		Etudiant e = new Etudiant();
		tp.setIdTp(1);
		e.setCNE("CD744952");
		if(t.getFaireTp(tp, e))
			System.out.println("good");
		else
			System.out.println("no");
		
	}

}